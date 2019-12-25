package com.baidu.android.imsdk.mcast;

import android.annotation.SuppressLint;
import android.support.media.ExifInterface;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.util.time.DateTimeUtil;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class ParseM3u8 {
    private static final String TAG = ParseM3u8.class.getSimpleName();
    private int mDuration;
    private ArrayList<TS> mTslist = new ArrayList<>();
    private boolean mIsend = false;

    /* loaded from: classes2.dex */
    public class TS {
        public double duration;
        public long relativetime;
        public String stime;
        public long time;
        public String tsfile;

        public TS() {
        }
    }

    public long getMaxTime() {
        if (this.mTslist.size() > 0) {
            return this.mTslist.get(this.mTslist.size() - 1).time;
        }
        return 0L;
    }

    public ArrayList<TS> getTslist() {
        return this.mTslist;
    }

    public List<TS> getTslist(int i) {
        boolean z;
        Iterator<TS> it = this.mTslist.iterator();
        int i2 = -1;
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            i2++;
            if (it.next().relativetime >= i) {
                z = true;
                break;
            }
        }
        if (z) {
            return this.mTslist.subList(i2, this.mTslist.size());
        }
        return null;
    }

    public List<TS> getNewAppendTS(long j) {
        boolean z = false;
        Iterator<TS> it = this.mTslist.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            i++;
            if (it.next().time == j) {
                z = true;
                break;
            }
        }
        if (!z || this.mTslist.size() <= i) {
            return null;
        }
        return this.mTslist.subList(i, this.mTslist.size());
    }

    public List<TS> getLatestTS(long j) {
        boolean z;
        Iterator<TS> it = this.mTslist.iterator();
        int i = -1;
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            i++;
            if (it.next().time == j) {
                z = true;
                break;
            }
        }
        if (!z || this.mTslist.size() <= i) {
            return null;
        }
        return this.mTslist.subList(i, this.mTslist.size());
    }

    public boolean isEnd() {
        return this.mIsend;
    }

    public int getTsSize() {
        return this.mTslist.size();
    }

    public void readByte(byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            } else if (readLine.matches("#EXT-X-TARGETDURATION(.*)")) {
                String[] split = readLine.split(":");
                if (split.length == 2) {
                    try {
                        this.mDuration = Integer.valueOf(split[1]).intValue();
                    } catch (NumberFormatException e) {
                        this.mDuration = 0;
                    }
                }
            } else if (readLine.matches("#EXT-X-PROGRAM-DATE-TIME(.*)")) {
                parseTSattr(readLine, bufferedReader.readLine(), bufferedReader.readLine());
            } else if (readLine.matches("#EXT-X-ENDLIST(.*)")) {
                this.mIsend = true;
            }
        }
        if (bufferedReader != null) {
            bufferedReader.close();
        }
        if (inputStreamReader != null) {
            inputStreamReader.close();
        }
        if (byteArrayInputStream != null) {
            byteArrayInputStream.close();
        }
    }

    private void parseTSattr(String str, String str2, String str3) {
        LogUtils.d(TAG, "parseTSline attr:   " + str + "  " + str2 + "  " + str3);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            TS ts = new TS();
            String trim = str.substring(str.indexOf(":") + 1).replace(ExifInterface.GPS_DIRECTION_TRUE, HanziToPinyin.Token.SEPARATOR).trim();
            ts.stime = trim;
            if (trim.length() < 20) {
                LogUtils.e(TAG, "parseTSattr exception 2.");
                return;
            }
            try {
                ts.time = stringToLong(trim.substring(0, 19), DateTimeUtil.TIME_FORMAT);
            } catch (ParseException e) {
                e.printStackTrace();
                LogUtils.e(TAG, "stringToLong execption");
            }
            int indexOf = str2.indexOf(":");
            if (str2.length() <= indexOf + 1) {
                LogUtils.e(TAG, "parseTSattr exception 2.");
                return;
            }
            String replace = str2.substring(indexOf + 1).trim().replace(Constants.ACCEPT_TIME_SEPARATOR_SP, "");
            try {
                ts.duration = Double.valueOf(replace).doubleValue();
            } catch (Exception e2) {
                LogUtils.e(TAG, " String to double execption " + replace);
            }
            ts.tsfile = str3.trim();
            LogUtils.d(TAG, " parseTSline: " + ts.tsfile);
            if (this.mTslist.size() == 0) {
                ts.relativetime = 0L;
            } else {
                ts.relativetime = (ts.time - this.mTslist.get(0).time) / 1000;
            }
            LogUtils.d(TAG, "  parseTSline attr:   " + ts.time + HanziToPinyin.Token.SEPARATOR + ts.relativetime + "  " + ts.duration + "  " + str3);
            this.mTslist.add(ts);
        }
    }

    public static long dateToLong(Date date) {
        return date.getTime();
    }

    @SuppressLint({"SimpleDateFormat"})
    public static Date stringToDate(String str, String str2) throws ParseException {
        return new SimpleDateFormat(str2).parse(str);
    }

    public static long stringToLong(String str, String str2) throws ParseException {
        Date stringToDate = stringToDate(str, str2);
        if (stringToDate == null) {
            return 0L;
        }
        return dateToLong(stringToDate);
    }
}

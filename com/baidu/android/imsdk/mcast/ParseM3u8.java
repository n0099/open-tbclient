package com.baidu.android.imsdk.mcast;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.utils.LogUtils;
import com.bumptech.glide.load.engine.GlideException;
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
/* loaded from: classes.dex */
public class ParseM3u8 {
    public static final String TAG = "ParseM3u8";
    public int mDuration;
    public ArrayList<TS> mTslist = new ArrayList<>();
    public boolean mIsend = false;

    /* loaded from: classes.dex */
    public class TS {
        public double duration;
        public long relativetime;
        public String stime;
        public long time;
        public String tsfile;

        public TS() {
        }
    }

    public static long dateToLong(Date date) {
        return date.getTime();
    }

    private void parseTSattr(String str, String str2, String str3) {
        String str4 = TAG;
        LogUtils.d(str4, "parseTSline attr:   " + str + GlideException.IndentedAppendable.INDENT + str2 + GlideException.IndentedAppendable.INDENT + str3);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        TS ts = new TS();
        String trim = str.substring(str.indexOf(":") + 1).replace(ExifInterface.GPS_DIRECTION_TRUE, " ").trim();
        ts.stime = trim;
        if (trim.length() >= 20) {
            try {
                ts.time = stringToLong(trim.substring(0, 19), "yyyy-MM-dd HH:mm:ss");
            } catch (ParseException e2) {
                e2.printStackTrace();
                LogUtils.e(TAG, "stringToLong execption");
            }
            int indexOf = str2.indexOf(":") + 1;
            if (str2.length() > indexOf) {
                String replace = str2.substring(indexOf).trim().replace(",", "");
                try {
                    ts.duration = Double.valueOf(replace).doubleValue();
                } catch (Exception unused) {
                    String str5 = TAG;
                    LogUtils.e(str5, " String to double execption " + replace);
                }
                ts.tsfile = str3.trim();
                String str6 = TAG;
                LogUtils.d(str6, " parseTSline: " + ts.tsfile);
                if (this.mTslist.size() == 0) {
                    ts.relativetime = 0L;
                } else {
                    ts.relativetime = (ts.time - this.mTslist.get(0).time) / 1000;
                }
                String str7 = TAG;
                LogUtils.d(str7, "  parseTSline attr:   " + ts.time + " " + ts.relativetime + GlideException.IndentedAppendable.INDENT + ts.duration + GlideException.IndentedAppendable.INDENT + str3);
                this.mTslist.add(ts);
                return;
            }
            LogUtils.e(TAG, "parseTSattr exception 2.");
            return;
        }
        LogUtils.e(TAG, "parseTSattr exception 2.");
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
        ArrayList<TS> arrayList = this.mTslist;
        return arrayList.subList(i, arrayList.size());
    }

    public long getMaxTime() {
        if (this.mTslist.size() > 0) {
            ArrayList<TS> arrayList = this.mTslist;
            return arrayList.get(arrayList.size() - 1).time;
        }
        return 0L;
    }

    public List<TS> getNewAppendTS(long j) {
        Iterator<TS> it = this.mTslist.iterator();
        boolean z = false;
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
        ArrayList<TS> arrayList = this.mTslist;
        return arrayList.subList(i, arrayList.size());
    }

    public int getTsSize() {
        return this.mTslist.size();
    }

    public ArrayList<TS> getTslist() {
        return this.mTslist;
    }

    public boolean isEnd() {
        return this.mIsend;
    }

    public void readByte(byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                if (readLine.matches("#EXT-X-TARGETDURATION(.*)")) {
                    String[] split = readLine.split(":");
                    if (split.length == 2) {
                        try {
                            this.mDuration = Integer.valueOf(split[1]).intValue();
                        } catch (NumberFormatException unused) {
                            this.mDuration = 0;
                        }
                    }
                } else if (readLine.matches("#EXT-X-PROGRAM-DATE-TIME(.*)")) {
                    parseTSattr(readLine, bufferedReader.readLine(), bufferedReader.readLine());
                } else if (readLine.matches("#EXT-X-ENDLIST(.*)")) {
                    this.mIsend = true;
                }
            } else {
                bufferedReader.close();
                inputStreamReader.close();
                byteArrayInputStream.close();
                return;
            }
        }
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
            ArrayList<TS> arrayList = this.mTslist;
            return arrayList.subList(i2, arrayList.size());
        }
        return null;
    }
}

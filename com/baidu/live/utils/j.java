package com.baidu.live.utils;

import android.util.Log;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.util.TextHelper;
import com.kwad.sdk.core.response.model.SdkConfigData;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
/* loaded from: classes10.dex */
public class j {
    public static String numFormatOverWanNaForAudienceNum(long j) {
        if (j > 99990000) {
            return String.format("9999%s+", TbadkCoreApplication.getInst().getResources().getString(a.h.sdk_unit_wan));
        }
        if (j >= 10000000) {
            return String.valueOf(j / 10000) + TbadkCoreApplication.getInst().getResources().getString(a.h.sdk_unit_wan);
        }
        if (j > 10000) {
            return String.format(Locale.getDefault(), "%.1f%s", Float.valueOf(((float) j) / 10000.0f), TbadkCoreApplication.getInst().getResources().getString(a.h.sdk_unit_wan));
        }
        if (j == 10000) {
            return "1" + TbadkCoreApplication.getInst().getResources().getString(a.h.sdk_unit_wan);
        }
        if (j < 0) {
            return "--";
        }
        return "" + j;
    }

    public static String formatTosepara(long j) {
        return new DecimalFormat("#,###").format(j);
    }

    public static String getCountDownTime(Long l) {
        return new SimpleDateFormat("HH:mm:ss").format(new Date((l.longValue() * 1000) - 28800000));
    }

    public static String c(Long l) {
        return new SimpleDateFormat("mm:ss").format(new Date((l.longValue() * 1000) - 28800000));
    }

    public static String fc(int i) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHH");
        Date date = new Date();
        date.setHours(date.getHours() - i);
        return simpleDateFormat.format(date);
    }

    public static String Vq() {
        return new SimpleDateFormat("HH").format(new Date());
    }

    public static String Vr() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH");
        Date date = new Date();
        date.setHours(date.getHours() - 1);
        return simpleDateFormat.format(date);
    }

    public static String stringForLastTime(int i) {
        if (i < 1) {
            i = 1;
        }
        int i2 = i % 60;
        int i3 = (i / 60) % 60;
        int i4 = i / SdkConfigData.DEFAULT_REQUEST_INTERVAL;
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb, Locale.getDefault());
        sb.setLength(0);
        return i4 > 0 ? formatter.format("%d:%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i2)).toString() : formatter.format("%02d:%02d", Integer.valueOf(i3), Integer.valueOf(i2)).toString();
    }

    public static boolean ig(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (fd(Character.codePointAt(str, i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean fd(int i) {
        return (128 <= i && i <= 687) || (768 <= i && i <= 1023) || ((1536 <= i && i <= 1791) || ((3072 <= i && i <= 3199) || ((7616 <= i && i <= 7679) || ((7680 <= i && i <= 7935) || ((8192 <= i && i <= 8351) || ((8400 <= i && i <= 8527) || ((8592 <= i && i <= 9215) || ((9312 <= i && i <= 9727) || ((9728 <= i && i <= 10223) || ((10496 <= i && i <= 10751) || ((11008 <= i && i <= 11263) || ((11360 <= i && i <= 11391) || ((11776 <= i && i <= 11903) || ((42128 <= i && i <= 42191) || ((57344 <= i && i <= 63743) || ((65024 <= i && i <= 65039) || ((65072 <= i && i <= 65103) || ((126976 <= i && i <= 127023) || ((127136 <= i && i <= 127231) || ((127232 <= i && i <= 128591) || ((128640 <= i && i <= 128767) || ((129296 <= i && i <= 129387) || (129408 <= i && i <= 129504)))))))))))))))))))))));
    }

    public static String K(String str, int i) {
        if (TextHelper.getTextLengthWithEmoji(str) > i) {
            String str2 = TextHelper.subStringWithEmoji(str, i) + StringHelper.STRING_MORE;
            Log.d("TAG", "AlaStringHelper sub string with emoji " + str2);
            return str2;
        }
        return str;
    }
}

package com.baidu.ala.utils;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.webkit.sdk.VideoCloudSetting;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
/* loaded from: classes.dex */
public class AlaStringHelper {
    public static String formatLowercasekDou(long j) {
        if (j < 100) {
            return String.valueOf(j);
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.0k");
        decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        return decimalFormat.format(j / 1000.0d);
    }

    public static String formatTosepara(long j) {
        return new DecimalFormat("#,###").format(j);
    }

    public static String formatkDou(long j) {
        DecimalFormat decimalFormat = new DecimalFormat("0.0K");
        decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        return decimalFormat.format(j / 1000.0d);
    }

    public static String getCountDownTime(Long l) {
        return new SimpleDateFormat("HH:mm:ss").format(new Date((l.longValue() * 1000) - 28800000));
    }

    public static String getGiftTimeLimitDesc(long j, long j2) {
        long j3 = j2 - j;
        if (j3 < 60000) {
            return TbadkCoreApplication.getInst().getResources().getString(R.string.ala_time_limited_gift_last_one_minute);
        }
        StringBuilder sb = new StringBuilder(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_left_prefix));
        if (j3 < VideoCloudSetting.HOUR_MILLISECOND) {
            String string = TbadkCoreApplication.getInst().getResources().getString(R.string.time_minute);
            sb.append((int) (j3 / 60000));
            sb.append(string);
            return sb.toString();
        } else if (j3 < 86400000) {
            String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.time_hour);
            sb.append(j3 / VideoCloudSetting.HOUR_MILLISECOND);
            sb.append(string2);
            return sb.toString();
        } else {
            String string3 = TbadkCoreApplication.getInst().getResources().getString(R.string.day);
            sb.append(j3 / 86400000);
            sb.append(string3);
            return sb.toString();
        }
    }

    public static String getLeftTimeDesc(long j) {
        StringBuilder sb = new StringBuilder();
        if (j < 60) {
            String string = TbadkCoreApplication.getInst().getResources().getString(R.string.time_second);
            sb.append(j);
            sb.append(string);
            return sb.toString();
        } else if (j < 3600) {
            String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.minute);
            sb.append((int) (j / 60));
            sb.append(string2);
            int i = (int) (j % 60);
            if (i > 0) {
                String string3 = TbadkCoreApplication.getInst().getResources().getString(R.string.time_second);
                sb.append(i);
                sb.append(string3);
            }
            return sb.toString();
        } else if (j < 86400) {
            String string4 = TbadkCoreApplication.getInst().getResources().getString(R.string.time_hour);
            sb.append((int) (j / 3600));
            sb.append(string4);
            int i2 = ((int) (j % 3600)) / 60;
            if (i2 > 0) {
                String string5 = TbadkCoreApplication.getInst().getResources().getString(R.string.minute);
                sb.append(i2);
                sb.append(string5);
            }
            return sb.toString();
        } else {
            String string6 = TbadkCoreApplication.getInst().getResources().getString(R.string.day);
            sb.append((int) (j / 86400));
            sb.append(string6);
            int i3 = ((int) (j % 86400)) / 3600;
            if (i3 > 0) {
                String string7 = TbadkCoreApplication.getInst().getResources().getString(R.string.time_hour);
                sb.append(i3);
                sb.append(string7);
            }
            return sb.toString();
        }
    }

    public static String numFormatMarkLevel(long j) {
        if (j > 99990000) {
            return String.format("9999%s", "w");
        }
        if (j >= 100000) {
            return String.valueOf(j / 10000) + "w";
        }
        int i = (j > 10000L ? 1 : (j == 10000L ? 0 : -1));
        if (i <= 0) {
            if (i == 0) {
                return "1w";
            }
            if (j < 0) {
                return "--";
            }
            return "" + j;
        }
        String format = String.format(Locale.getDefault(), "%.1f%s", Float.valueOf(((float) j) / 10000.0f), "w");
        if (StringUtils.isNull(format) || !format.endsWith(".0w") || format.indexOf(".0w") <= 0 || format.indexOf(".0w") >= format.length()) {
            return format;
        }
        return format.substring(0, format.indexOf(".0w")) + "w";
    }

    public static String numFormatOver10Wan(long j) {
        if (j > 99990000) {
            return "9999W+";
        }
        if (j >= 100000) {
            return String.format(Locale.getDefault(), "%dW", Long.valueOf(j / 10000));
        }
        return "" + j;
    }

    public static String numFormatOverWanForAudienceNum(long j) {
        if (j > 99990000) {
            return String.format("9999%s+", "w");
        }
        if (j >= 10000000) {
            return String.valueOf(j / 10000) + "w";
        }
        int i = (j > 10000L ? 1 : (j == 10000L ? 0 : -1));
        if (i > 0) {
            return String.format(Locale.getDefault(), "%.1f%s", Float.valueOf(((float) j) / 10000.0f), "w");
        }
        if (i == 0) {
            return "1w";
        }
        if (j < 0) {
            return "--";
        }
        return "" + j;
    }

    public static String numFormatOverWanNaForAudienceNum(long j) {
        if (j > 99990000) {
            return String.format("9999%s+", TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan));
        }
        if (j >= 10000000) {
            return String.valueOf(j / 10000) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
        }
        int i = (j > 10000L ? 1 : (j == 10000L ? 0 : -1));
        if (i > 0) {
            return String.format(Locale.getDefault(), "%.1f%s", Float.valueOf(((float) j) / 10000.0f), TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan));
        }
        if (i == 0) {
            return "1" + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
        } else if (j < 0) {
            return "--";
        } else {
            return "" + j;
        }
    }

    public static String stringForLastTime(int i) {
        if (i < 1) {
            i = 1;
        }
        int i2 = i % 60;
        int i3 = (i / 60) % 60;
        int i4 = i / 3600;
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb, Locale.getDefault());
        sb.setLength(0);
        return i4 > 0 ? formatter.format("%d:%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i2)).toString() : formatter.format("%02d:%02d", Integer.valueOf(i3), Integer.valueOf(i2)).toString();
    }
}

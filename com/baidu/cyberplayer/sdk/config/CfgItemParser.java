package com.baidu.cyberplayer.sdk.config;

import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.DeviceInfoUtils;
import com.baidu.webkit.sdk.WebChromeClient;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class CfgItemParser {
    public static final String DEFAULT_ERROR_LOG_CLOSE_ALL = "close_all";
    public static final String DEFAULT_ERROR_LOG_ENABLE_ALL = "enable_all";
    public static final int SETTING_HOST = 1;
    public static final int SETTING_VERSION = 0;
    public static final String TAG = "CfgItemParser";

    /* loaded from: classes3.dex */
    public enum MatchedType {
        FAILED,
        AND_NEED_CHECK_NEXT,
        OR_NEED_CHECK_NEXT,
        SUCCESS
    }

    /* loaded from: classes3.dex */
    public static class VideoCloudSettingItem {
        public int mType;
        public boolean mIsEnableAll = false;
        public boolean mIsCloseAll = false;
        public String[] mSubItems = null;
        public boolean mIsAdd = true;

        private boolean parseLogicalSymbol(String str) {
            if (!TextUtils.isEmpty(str) && str.toLowerCase().equals("or")) {
                return false;
            }
            return true;
        }

        public MatchedType match(String str) {
            if (this.mIsCloseAll) {
                return MatchedType.FAILED;
            }
            boolean find = find(str);
            if (this.mIsAdd) {
                if (find) {
                    return MatchedType.AND_NEED_CHECK_NEXT;
                }
                return MatchedType.FAILED;
            } else if (find) {
                return MatchedType.SUCCESS;
            } else {
                return MatchedType.OR_NEED_CHECK_NEXT;
            }
        }

        public void setType(int i) {
            this.mType = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void parseSettingItem(String str, String str2, String str3) {
            if (!TextUtils.isEmpty(str)) {
                if (str.equals("close_all")) {
                    this.mIsCloseAll = true;
                    this.mIsEnableAll = false;
                } else if (str.equals("enable_all")) {
                    this.mIsEnableAll = true;
                    this.mIsCloseAll = false;
                } else if (str.contains(str2)) {
                    if (str2.endsWith("|")) {
                        str2 = WebChromeClient.PARAM_SEPARATOR;
                    }
                    String[] split = str.split(str2);
                    if (split.length != 2) {
                        if (split.length == 1) {
                            this.mSubItems = parseSubItems(split[0], str3);
                            return;
                        }
                        return;
                    }
                    this.mSubItems = parseSubItems(split[0], str3);
                    this.mIsAdd = parseLogicalSymbol(split[1]);
                } else {
                    this.mSubItems = parseSubItems(str, str3);
                }
            }
        }

        private String[] parseSubItems(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (str.contains(str2)) {
                String[] split = str.split(str2);
                int length = split.length;
                for (int i = 0; i < length; i++) {
                    if (TextUtils.isEmpty(split[i]) || split[i].equals(".")) {
                        split[i] = null;
                    }
                }
                return split;
            } else if (TextUtils.isEmpty(str)) {
                return null;
            } else {
                return new String[]{str};
            }
        }

        public boolean find(String str) {
            String[] strArr;
            if (this.mIsEnableAll) {
                return true;
            }
            if (!TextUtils.isEmpty(str) && (strArr = this.mSubItems) != null) {
                int length = strArr.length;
                for (int i = 0; i < length; i++) {
                    if (!str.equals(this.mSubItems[i]) && (this.mType != 0 || !illegibilityMatch(str, this.mSubItems[i], "\\.", "*"))) {
                        if (this.mType == 1) {
                            if (str.contains("." + this.mSubItems[i])) {
                            }
                        }
                    }
                    return true;
                }
            }
            return false;
        }

        public boolean illegibilityMatch(String str, String str2, String str3, String str4) {
            String[] split = str.split(str3);
            String[] split2 = str2.split(str3);
            if (split.length != split2.length) {
                return false;
            }
            int length = split.length;
            for (int i = 0; i < length; i++) {
                if (!TextUtils.isEmpty(split[i]) && !TextUtils.isEmpty(split2[i])) {
                    if (!split2[i].equals(str4) && !split2[i].equals(split[i])) {
                        return false;
                    }
                } else if (!TextUtils.isEmpty(split2[i]) || !TextUtils.isEmpty(split[i])) {
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean checkDeviceInfoMatch(String str, ArrayList<String> arrayList) {
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (str.equalsIgnoreCase(arrayList.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean doBlackUrlLocalCheck(String str, ArrayList<String> arrayList) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if (str.indexOf(arrayList.get(i)) > -1) {
                return true;
            }
        }
        return false;
    }

    public static boolean doDeviceInfoCheck(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (checkDeviceInfoMatch(DeviceInfoUtils.getDeviceDevice(), arrayList) || checkDeviceInfoMatch(DeviceInfoUtils.getDeviceModel(), arrayList2)) {
            return true;
        }
        return false;
    }

    public static Boolean versionMatchCheck(String str, String str2) {
        VideoCloudSettingItem videoCloudSettingItem = new VideoCloudSettingItem();
        boolean z = false;
        videoCloudSettingItem.setType(0);
        videoCloudSettingItem.parseSettingItem(str, "|", ParamableElem.DIVIDE_PARAM);
        MatchedType match = videoCloudSettingItem.match(str2);
        return Boolean.valueOf((match == MatchedType.SUCCESS || match == MatchedType.AND_NEED_CHECK_NEXT) ? true : true);
    }
}

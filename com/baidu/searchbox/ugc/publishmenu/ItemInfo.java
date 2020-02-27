package com.baidu.searchbox.ugc.publishmenu;

import android.text.TextUtils;
import com.baidu.searchbox.ugc.R;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
/* loaded from: classes13.dex */
public class ItemInfo {
    public static final String TYPE_ANSWER = "6";
    public static final String TYPE_ASK = "11";
    public static final String TYPE_FORWARD = "5";
    public static final String TYPE_PHOTO_ALBUM = "4";
    public static final String TYPE_TEXT = "0";
    public static final String TYPE_VIDEO_CAMERA = "3";
    public static final String TYPE_VOTE = "12";
    public int iconId;
    public int nameId;
    public String type;

    public static ItemInfo newInstance(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    c = 0;
                    break;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    c = 2;
                    break;
                }
                break;
            case 52:
                if (str.equals("4")) {
                    c = 1;
                    break;
                }
                break;
            case 1568:
                if (str.equals("11")) {
                    c = 3;
                    break;
                }
                break;
            case 1569:
                if (str.equals("12")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                ItemInfo itemInfo = new ItemInfo();
                itemInfo.type = str;
                itemInfo.nameId = R.string.ugc_text;
                itemInfo.iconId = R.drawable.ugc_publish_text_icon;
                return itemInfo;
            case 1:
                ItemInfo itemInfo2 = new ItemInfo();
                itemInfo2.type = str;
                itemInfo2.nameId = R.string.ugc_iamge;
                itemInfo2.iconId = R.drawable.ugc_publish_image_icon;
                return itemInfo2;
            case 2:
                ItemInfo itemInfo3 = new ItemInfo();
                itemInfo3.type = str;
                itemInfo3.nameId = R.string.ugc_video;
                itemInfo3.iconId = R.drawable.ugc_publish_video_icon;
                return itemInfo3;
            case 3:
                ItemInfo itemInfo4 = new ItemInfo();
                itemInfo4.type = str;
                itemInfo4.nameId = R.string.ugc_ask;
                itemInfo4.iconId = R.drawable.ugc_publish_ask_icon;
                return itemInfo4;
            case 4:
                ItemInfo itemInfo5 = new ItemInfo();
                itemInfo5.type = str;
                itemInfo5.nameId = R.string.ugc_vote;
                itemInfo5.iconId = R.drawable.ugc_publish_vote_icon;
                return itemInfo5;
            default:
                return null;
        }
    }

    public String toUbcType() {
        if (TextUtils.isEmpty(this.type)) {
            return null;
        }
        String str = this.type;
        char c = 65535;
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    c = 0;
                    break;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    c = 2;
                    break;
                }
                break;
            case 52:
                if (str.equals("4")) {
                    c = 1;
                    break;
                }
                break;
            case 1568:
                if (str.equals("11")) {
                    c = 3;
                    break;
                }
                break;
            case 1569:
                if (str.equals("12")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return "text";
            case 1:
                return "pic";
            case 2:
                return "video";
            case 3:
                return UgcUBCUtils.UGC_TYPE_ASK;
            case 4:
                return "vote";
            default:
                return null;
        }
    }
}

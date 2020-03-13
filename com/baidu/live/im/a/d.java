package com.baidu.live.im.a;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Base64;
import android.view.View;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.adp.base.IScrollableHelper;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.au;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.u.a;
import com.baidu.tbadk.TbConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends b {
    /* JADX INFO: Access modifiers changed from: protected */
    public d(Context context) {
        super(context, com.baidu.live.im.a.aqy);
    }

    @Override // com.baidu.live.im.a.b
    protected void wP() {
        if (wQ()) {
            wR();
        } else {
            wS();
        }
    }

    @Override // com.baidu.live.im.a.b
    protected int getColor() {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:194:0x051e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x016b  */
    @Override // com.baidu.live.im.a.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected SpannableStringBuilder a(com.baidu.live.im.data.a aVar, com.baidu.live.im.c cVar) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        String str;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String str10 = null;
        if (aVar != null) {
            if (aVar != null && (aVar instanceof com.baidu.live.im.a) && ((com.baidu.live.im.a) aVar).vP() != null && aVar.xo() != null) {
                ((com.baidu.live.im.a) aVar).vP().equals(aVar.xo().userId);
            }
            int color = TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_im_official_color);
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                try {
                    str10 = jSONObject.optString("content_type");
                    if (str10.equals("start_grab_wheel")) {
                        str9 = jSONObject.optString("ext_data");
                    } else {
                        str9 = new String(Base64.decode(jSONObject.optString("ext").getBytes(), 0));
                    }
                    if (TextUtils.isEmpty(str9)) {
                        jSONObject2 = null;
                    } else {
                        jSONObject2 = new JSONObject(str9);
                    }
                    try {
                        str = jSONObject.optString("text");
                    } catch (JSONException e) {
                        str = "";
                    }
                    try {
                        jSONObject3 = jSONObject;
                        jSONObject4 = jSONObject2;
                        str2 = str;
                        str3 = str10;
                        str4 = jSONObject.optString("level_id");
                    } catch (JSONException e2) {
                        jSONObject3 = jSONObject;
                        jSONObject4 = jSONObject2;
                        str2 = str;
                        str3 = str10;
                        str4 = "";
                        if (!TextUtils.isEmpty(str4)) {
                            aVar.xo().level_id = JavaTypesHelper.toInt(str4, 0);
                        }
                        str5 = null;
                        if (str3 != null) {
                        }
                        if (!"send_redpacket".equals(str3)) {
                        }
                        SpannableString valueOf = SpannableString.valueOf(str5);
                        if (jSONObject4 != null) {
                        }
                        spannableStringBuilder.append((CharSequence) valueOf, 0, str5 == null ? str5.length() : 0);
                        com.baidu.live.view.c cVar2 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_redpacket);
                        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("  ");
                        spannableStringBuilder2.setSpan(cVar2, 0, 1, 33);
                        spannableStringBuilder.insert(0, (CharSequence) spannableStringBuilder2);
                        com.baidu.live.view.c cVar3 = new com.baidu.live.view.c(this.mContext, a.f.redpacket_im_arrow);
                        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("  ");
                        spannableStringBuilder3.setSpan(cVar3, 0, 1, 33);
                        spannableStringBuilder.insert(spannableStringBuilder.length(), (CharSequence) spannableStringBuilder3);
                        return spannableStringBuilder;
                    }
                } catch (JSONException e3) {
                    jSONObject2 = null;
                    str = "";
                }
            } catch (JSONException e4) {
                jSONObject = null;
                jSONObject2 = null;
                str = "";
            }
            if (!TextUtils.isEmpty(str4) && JavaTypesHelper.toInt(str4, 0) > 0) {
                aVar.xo().level_id = JavaTypesHelper.toInt(str4, 0);
            }
            str5 = null;
            if (str3 != null) {
                str5 = aVar.getContent();
            } else if (str3.equals("enter_live")) {
                if (wQ()) {
                    color = -1647769;
                } else {
                    color = TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_cont_d);
                }
                if (!TextUtils.isEmpty(null)) {
                    str5 = null;
                } else {
                    str5 = this.mContext.getString(a.i.ala_enter_live);
                }
                a(spannableStringBuilder, aVar.xo(), cVar, false, false, false);
            } else if (str3.equals("backstage_live")) {
                str5 = str2;
            } else if (str3.equals("offline_type")) {
                str5 = str2;
            } else if (str3.equals("close_live")) {
                str5 = this.mContext.getString(a.i.ala_close_live);
            } else if (str3.equals("follow_anchor")) {
                int i = wQ() ? -1647769 : color;
                str5 = this.mContext.getString(a.i.ala_follow_live);
                a(spannableStringBuilder, aVar.xo(), cVar, false, false);
                color = i;
            } else if (str3.equals(TbConfig.TMP_SHARE_DIR_NAME)) {
                if (wQ()) {
                    color = -1647769;
                }
                String string = this.mContext.getString(a.i.ala_share_live);
                a(spannableStringBuilder, aVar.xo(), cVar, false, false);
                str5 = string;
            } else if (str3.equals("share_tieba")) {
                str5 = str2;
            } else if (str3.equals("remove_video")) {
                str5 = str2;
            } else if (str3.equals("ueg_warn")) {
                str5 = str2;
            } else if (str3.equals("live_admin")) {
                a(spannableStringBuilder, aVar.xo(), cVar, false, false);
                str5 = str2;
            } else if (str3.equals("live_talk_ban")) {
                a(spannableStringBuilder, aVar.xo(), cVar, false, false);
                str5 = str2;
            } else if (str3.equals("challenge_direct_start")) {
                str5 = str2;
            } else if (str3.equals("challenge_direct_matched")) {
                str5 = str2;
            } else if (str3.equals("challenge_random_start")) {
                str5 = str2;
            } else if (str3.equals("challenge_random_matched")) {
                str5 = str2;
            } else if (str3.equals("avts")) {
                str5 = str2;
            } else if (str3.equals("allin")) {
                str5 = str2;
            } else if (str3.equals("share_rmb")) {
                if (wQ()) {
                    color = -1647769;
                }
                String string2 = this.mContext.getString(a.i.ala_share_rmb);
                a(spannableStringBuilder, aVar.xo(), cVar, false, false);
                str5 = string2;
            } else if (str3.equals("zan_rmb")) {
                if (wQ()) {
                    color = -1647769;
                }
                String string3 = this.mContext.getString(a.i.ala_zan_rmb);
                a(spannableStringBuilder, aVar.xo(), cVar, false, false);
                str5 = string3;
            } else if (str3.equals("start_grab_wheel")) {
                if (wQ()) {
                    color = -1647769;
                }
                if (jSONObject4 == null) {
                    str6 = "";
                    str7 = "";
                    str8 = "";
                } else {
                    String optString = jSONObject4.optString(LogConfig.LOG_AMOUNT);
                    String optString2 = jSONObject4.optString("keywords");
                    str6 = jSONObject4.optString("gift_url");
                    str7 = optString2;
                    str8 = optString;
                }
                String string4 = this.mContext.getString(a.i.ala_lucky_tab_tips);
                str5 = (TextUtils.isEmpty(str8) || TextUtils.isEmpty(str7)) ? String.format(string4, "", "") : String.format(string4, str8, str7);
                a(spannableStringBuilder, aVar.xo(), cVar, false, false);
                spannableStringBuilder.append(com.baidu.live.utils.f.s(str5, color), 0, str5 != null ? str5.length() : 0);
                AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                alaLiveMarkData.mark_pic = str6;
                com.baidu.live.view.c cVar4 = new com.baidu.live.view.c(this.mContext, alaLiveMarkData, false, null);
                SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder("  ");
                spannableStringBuilder4.setSpan(cVar4, 0, 1, 33);
                spannableStringBuilder.insert(spannableStringBuilder.length(), (CharSequence) spannableStringBuilder4);
                aVar.setLink(str3);
            } else if (str3.equals("guard_club_join")) {
                color = -22844;
                String string5 = this.mContext.getString(a.i.ala_guard_club_join);
                str5 = (aVar.xo() == null || TextUtils.isEmpty(aVar.xo().getNameShow())) ? String.format(string5, "") : String.format(string5, "【" + aVar.xo().getNameShow() + "】");
            } else if (str3.equals("send_redpacket")) {
                color = -1;
                String str11 = "";
                if (jSONObject4 != null) {
                    str11 = jSONObject4.optString(LogConfig.LOG_AMOUNT);
                }
                String string6 = this.mContext.getString(a.i.ala_send_redpacket);
                String format = (aVar.xo() == null || TextUtils.isEmpty(aVar.xo().getNameShow()) || TextUtils.isEmpty(str11)) ? String.format(string6, "", "") : String.format(string6, aVar.xo().getNameShow(), str11);
                aVar.setLink(str3);
                str5 = format;
            } else if (str3.equals("start_grab_redpacket")) {
                color = -1;
                String string7 = this.mContext.getString(a.i.ala_start_grab_redpacket);
                String format2 = (aVar.xo() == null || TextUtils.isEmpty(aVar.xo().getNameShow())) ? String.format(string7, "") : String.format(string7, aVar.xo().getNameShow());
                aVar.setLink(str3);
                str5 = format2;
            } else if (str3.equals("guard_seat")) {
                color = -1;
                aVar.setLink(str3);
            } else if (str3.equals("challenge_mvp")) {
                color = -1647769;
            } else if (str3.equals("wish_list_success") || str3.equals("wish_list_finish")) {
                aVar.setLink(str3);
                str5 = str2;
            } else {
                str5 = aVar.getContent();
            }
            if (!"send_redpacket".equals(str3) || "start_grab_redpacket".equals(str3)) {
                SpannableString valueOf2 = SpannableString.valueOf(str5);
                if (jSONObject4 != null) {
                    valueOf2.setSpan(new a(this.mContext, aVar.getLink(), jSONObject4.optString("live_id"), jSONObject4.optString("anchor_id"), jSONObject4.optString("red_packet_id"), wO()), 0, str5 != null ? str5.length() : 0, 33);
                }
                spannableStringBuilder.append((CharSequence) valueOf2, 0, str5 == null ? str5.length() : 0);
                com.baidu.live.view.c cVar22 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_redpacket);
                SpannableStringBuilder spannableStringBuilder22 = new SpannableStringBuilder("  ");
                spannableStringBuilder22.setSpan(cVar22, 0, 1, 33);
                spannableStringBuilder.insert(0, (CharSequence) spannableStringBuilder22);
                com.baidu.live.view.c cVar32 = new com.baidu.live.view.c(this.mContext, a.f.redpacket_im_arrow);
                SpannableStringBuilder spannableStringBuilder32 = new SpannableStringBuilder("  ");
                spannableStringBuilder32.setSpan(cVar32, 0, 1, 33);
                spannableStringBuilder.insert(spannableStringBuilder.length(), (CharSequence) spannableStringBuilder32);
            } else if (jSONObject3 != null && "guard_seat".equals(str3)) {
                String optString3 = jSONObject3.optString("prefix");
                String optString4 = jSONObject3.optString("nickname");
                String optString5 = jSONObject3.optString("suffix");
                StringBuilder sb = new StringBuilder(optString3);
                if (!TextUtils.isEmpty(optString4)) {
                    sb.append(HanziToPinyin.Token.SEPARATOR);
                    sb.append(optString4);
                    sb.append(HanziToPinyin.Token.SEPARATOR);
                }
                sb.append(optString5);
                String sb2 = sb.toString();
                SpannableString valueOf3 = SpannableString.valueOf(sb2);
                a aVar2 = new a(this.mContext, aVar.getLink());
                aVar2.setClickable(jSONObject3.optInt("is_jump") == 1);
                valueOf3.setSpan(aVar2, 0, sb2.length(), 33);
                if (!TextUtils.isEmpty(optString4)) {
                    valueOf3.setSpan(new ForegroundColorSpan(-2109100), optString3.length() + 1, optString3.length() + 1 + optString4.length(), 33);
                }
                spannableStringBuilder.append((CharSequence) valueOf3, 0, sb2.length());
                com.baidu.live.view.c cVar5 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_throne_arrow);
                SpannableStringBuilder spannableStringBuilder5 = new SpannableStringBuilder("  ");
                spannableStringBuilder5.setSpan(cVar5, 0, 1, 33);
                spannableStringBuilder.insert(spannableStringBuilder.length(), (CharSequence) spannableStringBuilder5);
            } else if (jSONObject3 != null && "challenge_mvp".equals(str3)) {
                String optString6 = jSONObject3.optString("prefix");
                String optString7 = jSONObject3.optString("nickname");
                String optString8 = jSONObject3.optString("suffix");
                StringBuilder sb3 = new StringBuilder(optString6);
                if (!TextUtils.isEmpty(optString7)) {
                    sb3.append(HanziToPinyin.Token.SEPARATOR);
                    sb3.append(optString7);
                    sb3.append(HanziToPinyin.Token.SEPARATOR);
                }
                sb3.append(optString8);
                String sb4 = sb3.toString();
                SpannableString valueOf4 = SpannableString.valueOf(sb4);
                valueOf4.setSpan(new ForegroundColorSpan(color), 0, sb4.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf4, 0, sb4.length());
                com.baidu.live.view.c cVar6 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_pk);
                SpannableStringBuilder spannableStringBuilder6 = new SpannableStringBuilder("  ");
                spannableStringBuilder6.setSpan(cVar6, 0, 1, 33);
                spannableStringBuilder.insert(0, (CharSequence) spannableStringBuilder6);
            } else if ("wish_list_success".equals(str3) || "wish_list_finish".equals(str3)) {
                SpannableString valueOf5 = SpannableString.valueOf(str5);
                valueOf5.setSpan(new a(this.mContext, aVar.getLink()), 0, str5 != null ? str5.length() : 0, 33);
                spannableStringBuilder.append((CharSequence) valueOf5, 0, str5 != null ? str5.length() : 0);
                com.baidu.live.view.c cVar7 = new com.baidu.live.view.c(this.mContext, a.f.wishlist_im_arrow);
                SpannableStringBuilder spannableStringBuilder7 = new SpannableStringBuilder("  ");
                spannableStringBuilder7.setSpan(cVar7, 0, 1, 33);
                spannableStringBuilder.insert(spannableStringBuilder.length(), (CharSequence) spannableStringBuilder7);
            } else if (TextUtils.isEmpty(aVar.getLink())) {
                spannableStringBuilder.append(com.baidu.live.utils.f.s(str5, color));
            } else if (!"start_grab_wheel".equals(str3)) {
                SpannableString valueOf6 = SpannableString.valueOf(str5);
                valueOf6.setSpan(new a(this.mContext, aVar.getLink()), 0, str5 != null ? str5.length() : 0, 33);
                spannableStringBuilder.append((CharSequence) valueOf6);
            }
        }
        return spannableStringBuilder;
    }

    /* loaded from: classes3.dex */
    private static class a extends ClickableSpan {
        private String adB;
        private String adC;
        private boolean atn;
        private boolean isHost;
        private String liveId;
        private String url;

        public a(Context context, String str) {
            this.url = str;
        }

        public a(Context context, String str, String str2, String str3, String str4, boolean z) {
            this.url = str;
            this.liveId = str2;
            this.adC = str3;
            this.adB = str4;
            this.isHost = z;
        }

        public void setClickable(boolean z) {
            this.atn = z;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if ("send_redpacket".equals(this.url) || "start_grab_redpacket".equals(this.url) || "guard_seat".equals(this.url)) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_white_alpha100));
            } else if ("wish_list_finish".equals(this.url) || "wish_list_success".equals(this.url)) {
                textPaint.setColor(Color.parseColor("#84E2FF"));
            } else {
                if (1 == b.asQ) {
                    textPaint.setColor(Color.parseColor("#84E2FF"));
                } else if (2 == b.asQ) {
                    textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_link_tip_a));
                }
                textPaint.setUnderlineText(true);
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = this.url;
            char c = 65535;
            switch (str.hashCode()) {
                case -1480538273:
                    if (str.equals("guard_seat")) {
                        c = 1;
                        break;
                    }
                    break;
                case -244328516:
                    if (str.equals("wish_list_finish")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1595898:
                    if (str.equals("wish_list_success")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1290650531:
                    if (str.equals("start_grab_redpacket")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    au auVar = new au();
                    auVar.adB = this.adB;
                    auVar.liveId = this.liveId;
                    auVar.adC = this.adC;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, auVar));
                    return;
                case 1:
                    if (this.atn) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913153));
                        return;
                    }
                    return;
                case 2:
                case 3:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913154, null));
                    return;
                default:
                    if (!TextUtils.isEmpty(this.url)) {
                        UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(view.getContext()), new String[]{this.url}, true);
                        return;
                    }
                    return;
            }
        }
    }
}

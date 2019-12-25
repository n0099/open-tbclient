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
import com.baidu.live.data.ao;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.tbadk.TbConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends b {
    /* JADX INFO: Access modifiers changed from: protected */
    public d(Context context) {
        super(context, com.baidu.live.im.a.ams);
    }

    @Override // com.baidu.live.im.a.b
    protected void uU() {
        if (uV()) {
            uW();
        } else {
            uX();
        }
    }

    @Override // com.baidu.live.im.a.b
    protected int getColor() {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:167:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0157  */
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
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String str7 = null;
        if (aVar != null) {
            if (aVar != null && (aVar instanceof com.baidu.live.im.a) && ((com.baidu.live.im.a) aVar).tU() != null && aVar.uZ() != null) {
                ((com.baidu.live.im.a) aVar).tU().equals(aVar.uZ().userId);
            }
            int color = TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_im_official_color);
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                try {
                    str7 = jSONObject.optString("content_type");
                    String optString = jSONObject.optString("ext");
                    if (TextUtils.isEmpty(optString)) {
                        jSONObject2 = null;
                    } else {
                        jSONObject2 = new JSONObject(new String(Base64.decode(optString.getBytes(), 0)));
                    }
                    try {
                        str = jSONObject.optString("text");
                    } catch (JSONException e) {
                        str = "";
                    }
                } catch (JSONException e2) {
                    jSONObject2 = null;
                    str = "";
                }
            } catch (JSONException e3) {
                jSONObject = null;
                jSONObject2 = null;
                str = "";
            }
            try {
                jSONObject3 = jSONObject;
                jSONObject4 = jSONObject2;
                str2 = str;
                str3 = str7;
                str4 = jSONObject.optString("level_id");
            } catch (JSONException e4) {
                jSONObject3 = jSONObject;
                jSONObject4 = jSONObject2;
                str2 = str;
                str3 = str7;
                str4 = "";
                if (!TextUtils.isEmpty(str4)) {
                    aVar.uZ().level_id = JavaTypesHelper.toInt(str4, 0);
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
            if (!TextUtils.isEmpty(str4) && JavaTypesHelper.toInt(str4, 0) > 0) {
                aVar.uZ().level_id = JavaTypesHelper.toInt(str4, 0);
            }
            str5 = null;
            if (str3 != null) {
                str5 = aVar.getContent();
            } else if (str3.equals("enter_live")) {
                if (uV()) {
                    color = -1647769;
                } else {
                    color = TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_cont_d);
                }
                if (!TextUtils.isEmpty(null)) {
                    str6 = null;
                } else {
                    str6 = this.mContext.getString(a.i.ala_enter_live);
                }
                a(spannableStringBuilder, aVar.uZ(), cVar, false, false, false);
                str5 = str6;
            } else if (str3.equals("backstage_live")) {
                str5 = str2;
            } else if (str3.equals("offline_type")) {
                str5 = str2;
            } else if (str3.equals("close_live")) {
                str5 = this.mContext.getString(a.i.ala_close_live);
            } else if (str3.equals("follow_anchor")) {
                int i = uV() ? -1647769 : color;
                String string = this.mContext.getString(a.i.ala_follow_live);
                a(spannableStringBuilder, aVar.uZ(), cVar, false, false);
                str5 = string;
                color = i;
            } else if (str3.equals(TbConfig.TMP_SHARE_DIR_NAME)) {
                if (uV()) {
                    color = -1647769;
                }
                String string2 = this.mContext.getString(a.i.ala_share_live);
                a(spannableStringBuilder, aVar.uZ(), cVar, false, false);
                str5 = string2;
            } else if (str3.equals("share_tieba")) {
                str5 = str2;
            } else if (str3.equals("remove_video")) {
                str5 = str2;
            } else if (str3.equals("ueg_warn")) {
                str5 = str2;
            } else if (str3.equals("live_admin")) {
                a(spannableStringBuilder, aVar.uZ(), cVar, false, false);
                str5 = str2;
            } else if (str3.equals("live_talk_ban")) {
                a(spannableStringBuilder, aVar.uZ(), cVar, false, false);
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
                if (uV()) {
                    color = -1647769;
                }
                String string3 = this.mContext.getString(a.i.ala_share_rmb);
                a(spannableStringBuilder, aVar.uZ(), cVar, false, false);
                str5 = string3;
            } else if (str3.equals("zan_rmb")) {
                if (uV()) {
                    color = -1647769;
                }
                String string4 = this.mContext.getString(a.i.ala_zan_rmb);
                a(spannableStringBuilder, aVar.uZ(), cVar, false, false);
                str5 = string4;
            } else if (str3.equals("guard_club_join")) {
                color = -22844;
                String string5 = this.mContext.getString(a.i.ala_guard_club_join);
                str5 = (aVar.uZ() == null || TextUtils.isEmpty(aVar.uZ().getNameShow())) ? String.format(string5, "") : String.format(string5, "【" + aVar.uZ().getNameShow() + "】");
            } else if (str3.equals("send_redpacket")) {
                color = -1;
                String str8 = "";
                if (jSONObject4 != null) {
                    str8 = jSONObject4.optString(LogConfig.LOG_AMOUNT);
                }
                String string6 = this.mContext.getString(a.i.ala_send_redpacket);
                str5 = (aVar.uZ() == null || TextUtils.isEmpty(aVar.uZ().getNameShow()) || TextUtils.isEmpty(str8)) ? String.format(string6, "", "") : String.format(string6, aVar.uZ().getNameShow(), str8);
                aVar.setLink(str3);
            } else if (str3.equals("start_grab_redpacket")) {
                color = -1;
                String string7 = this.mContext.getString(a.i.ala_start_grab_redpacket);
                str5 = (aVar.uZ() == null || TextUtils.isEmpty(aVar.uZ().getNameShow())) ? String.format(string7, "") : String.format(string7, aVar.uZ().getNameShow());
                aVar.setLink(str3);
            } else if (str3.equals("guard_seat")) {
                color = -1;
                aVar.setLink(str3);
            } else if (str3.equals("wish_list_success") || str3.equals("wish_list_finish")) {
                aVar.setLink(str3);
                str5 = str2;
            } else {
                str5 = aVar.getContent();
            }
            if (!"send_redpacket".equals(str3) || "start_grab_redpacket".equals(str3)) {
                SpannableString valueOf2 = SpannableString.valueOf(str5);
                if (jSONObject4 != null) {
                    valueOf2.setSpan(new a(this.mContext, aVar.getLink(), jSONObject4.optString("live_id"), jSONObject4.optString("anchor_id"), jSONObject4.optString("red_packet_id"), uT()), 0, str5 != null ? str5.length() : 0, 33);
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
                String optString2 = jSONObject3.optString("prefix");
                String optString3 = jSONObject3.optString("nickname");
                String optString4 = jSONObject3.optString("suffix");
                StringBuilder sb = new StringBuilder(optString2);
                if (!TextUtils.isEmpty(optString3)) {
                    sb.append(HanziToPinyin.Token.SEPARATOR);
                    sb.append(optString3);
                    sb.append(HanziToPinyin.Token.SEPARATOR);
                }
                sb.append(optString4);
                String sb2 = sb.toString();
                SpannableString valueOf3 = SpannableString.valueOf(sb2);
                a aVar2 = new a(this.mContext, aVar.getLink());
                aVar2.setClickable(jSONObject3.optInt("is_jump") == 1);
                valueOf3.setSpan(aVar2, 0, sb2.length(), 33);
                if (!TextUtils.isEmpty(optString3)) {
                    valueOf3.setSpan(new ForegroundColorSpan(-2109100), optString2.length() + 1, optString2.length() + 1 + optString3.length(), 33);
                }
                spannableStringBuilder.append((CharSequence) valueOf3, 0, sb2.length());
                com.baidu.live.view.c cVar4 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_throne_arrow);
                SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder("  ");
                spannableStringBuilder4.setSpan(cVar4, 0, 1, 33);
                spannableStringBuilder.insert(spannableStringBuilder.length(), (CharSequence) spannableStringBuilder4);
            } else if ("wish_list_success".equals(str3) || "wish_list_finish".equals(str3)) {
                SpannableString valueOf4 = SpannableString.valueOf(str5);
                valueOf4.setSpan(new a(this.mContext, aVar.getLink()), 0, str5 != null ? str5.length() : 0, 33);
                spannableStringBuilder.append((CharSequence) valueOf4, 0, str5 != null ? str5.length() : 0);
                com.baidu.live.view.c cVar5 = new com.baidu.live.view.c(this.mContext, a.f.wishlist_im_arrow);
                SpannableStringBuilder spannableStringBuilder5 = new SpannableStringBuilder("  ");
                spannableStringBuilder5.setSpan(cVar5, 0, 1, 33);
                spannableStringBuilder.insert(spannableStringBuilder.length(), (CharSequence) spannableStringBuilder5);
            } else if (TextUtils.isEmpty(aVar.getLink())) {
                spannableStringBuilder.append(com.baidu.live.utils.f.s(str5, color));
            } else {
                SpannableString valueOf5 = SpannableString.valueOf(str5);
                valueOf5.setSpan(new a(this.mContext, aVar.getLink()), 0, str5 != null ? str5.length() : 0, 33);
                spannableStringBuilder.append((CharSequence) valueOf5);
            }
        }
        return spannableStringBuilder;
    }

    /* loaded from: classes2.dex */
    private static class a extends ClickableSpan {
        private String abk;
        private String abl;
        private boolean aph;
        private boolean isHost;
        private String liveId;
        private String url;

        public a(Context context, String str) {
            this.url = str;
        }

        public a(Context context, String str, String str2, String str3, String str4, boolean z) {
            this.url = str;
            this.liveId = str2;
            this.abl = str3;
            this.abk = str4;
            this.isHost = z;
        }

        public void setClickable(boolean z) {
            this.aph = z;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if ("send_redpacket".equals(this.url) || "start_grab_redpacket".equals(this.url) || "guard_seat".equals(this.url)) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_white_alpha100));
            } else if ("wish_list_finish".equals(this.url) || "wish_list_success".equals(this.url)) {
                textPaint.setColor(Color.parseColor("#84E2FF"));
            } else {
                if (1 == b.aoK) {
                    textPaint.setColor(Color.parseColor("#84E2FF"));
                } else if (2 == b.aoK) {
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
                    ao aoVar = new ao();
                    aoVar.abk = this.abk;
                    aoVar.liveId = this.liveId;
                    aoVar.abl = this.abl;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, aoVar));
                    return;
                case 1:
                    if (this.aph) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913147));
                        return;
                    }
                    return;
                case 2:
                case 3:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913148, null));
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

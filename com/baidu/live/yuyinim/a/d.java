package com.baidu.live.yuyinim.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Base64;
import android.view.View;
import com.baidu.live.adp.base.IScrollableHelper;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.resourceloader.BdResourceCallback;
import com.baidu.live.adp.lib.resourceloader.BdResourceLoader;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdBitmapHelper;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.CenteredImageSpan;
import com.baidu.live.adp.widget.imageview.BdImage;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.cw;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d extends b {
    private String ble;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(Context context) {
        super(context, com.baidu.live.im.a.bhm);
    }

    @Override // com.baidu.live.yuyinim.a.b
    protected void Mb() {
        if (Mc()) {
            Md();
        } else {
            Me();
        }
    }

    @Override // com.baidu.live.yuyinim.a.b
    protected int getColor() {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x05bb  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x011c  */
    @Override // com.baidu.live.yuyinim.a.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected SpannableStringBuilder a(com.baidu.live.im.data.a aVar, final com.baidu.live.yuyinim.a aVar2) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        String str;
        Exception e;
        JSONException e2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        String str2;
        String str3;
        String str4;
        String str5;
        boolean z;
        boolean z2;
        int i;
        String string;
        String[] split;
        String format;
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        this.ble = null;
        String str6 = null;
        String str7 = "";
        if (aVar != null) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                try {
                    str6 = jSONObject.optString("content_type");
                    if (str6.equals("start_grab_wheel")) {
                        str7 = jSONObject.optString("ext_data");
                    } else {
                        String optString = jSONObject.optString("ext");
                        if (!TextUtils.isEmpty(optString)) {
                            str7 = new String(Base64.decode(optString.getBytes(), 0));
                        }
                        if (TbConfig.isForceNoticeIm) {
                            str7 = optString;
                        }
                    }
                    if (TextUtils.isEmpty(str7)) {
                        jSONObject2 = null;
                    } else {
                        jSONObject2 = new JSONObject(str7);
                    }
                    try {
                        str = jSONObject.optString("text");
                    } catch (JSONException e3) {
                        str = "";
                        e2 = e3;
                    } catch (Exception e4) {
                        str = "";
                        e = e4;
                    }
                } catch (JSONException e5) {
                    jSONObject2 = null;
                    str = "";
                    e2 = e5;
                } catch (Exception e6) {
                    jSONObject2 = null;
                    str = "";
                    e = e6;
                }
            } catch (JSONException e7) {
                jSONObject = null;
                jSONObject2 = null;
                str = "";
                e2 = e7;
            } catch (Exception e8) {
                jSONObject = null;
                jSONObject2 = null;
                str = "";
                e = e8;
            }
            try {
                jSONObject3 = jSONObject;
                jSONObject4 = jSONObject2;
                str2 = str;
                str3 = str6;
                str4 = jSONObject.optString("level_id");
            } catch (JSONException e9) {
                e2 = e9;
                e2.printStackTrace();
                jSONObject3 = jSONObject;
                jSONObject4 = jSONObject2;
                str2 = str;
                str3 = str6;
                str4 = "";
                if (!TextUtils.isEmpty(str4)) {
                    aVar.Mo().level_id = JavaTypesHelper.toInt(str4, 0);
                }
                String str8 = null;
                if (str3 == null) {
                }
                if (z) {
                }
                return spannableStringBuilder;
            } catch (Exception e10) {
                e = e10;
                e.printStackTrace();
                jSONObject3 = jSONObject;
                jSONObject4 = jSONObject2;
                str2 = str;
                str3 = str6;
                str4 = "";
                if (!TextUtils.isEmpty(str4)) {
                }
                String str82 = null;
                if (str3 == null) {
                }
                if (z) {
                }
                return spannableStringBuilder;
            }
            if (!TextUtils.isEmpty(str4) && JavaTypesHelper.toInt(str4, 0) > 0) {
                aVar.Mo().level_id = JavaTypesHelper.toInt(str4, 0);
            }
            String str822 = null;
            if (str3 == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str5 = str2;
                    z = false;
                    z2 = false;
                    i = -39322;
                } else {
                    str5 = aVar.getContent();
                    z = false;
                    i = -39322;
                    z2 = false;
                }
            } else if (str3.equals("custom_live_notice")) {
                str5 = str2;
                z2 = false;
                i = -1;
                z = false;
            } else if (str3.equals("custom_im_notice")) {
                z = true;
                str5 = null;
                i = -39322;
                z2 = false;
            } else if (str3.equals("play_rules")) {
                str5 = str2;
                z2 = false;
                i = -6574339;
                z = false;
            } else if (str3.equals("custom_im_notice_live_assistant")) {
                z = true;
                str5 = null;
                i = -39322;
                z2 = false;
            } else if (str3.equals("custom_network_change")) {
                str5 = str2;
                z = false;
                z2 = false;
                i = -39322;
            } else if (str3.equals("enter_live")) {
                String string2 = this.mContext.getString(a.h.ala_enter_live);
                a(spannableStringBuilder, aVar.Mo(), aVar2, false, false, false);
                str5 = string2;
                z = false;
                z2 = false;
                i = -1711276033;
            } else if (str3.equals("backstage_live")) {
                str5 = str2;
                z2 = false;
                i = -6574339;
                z = false;
            } else if (str3.equals("offline_type")) {
                str5 = str2;
                z = false;
                z2 = false;
                i = -39322;
            } else if (str3.equals("close_live")) {
                str5 = this.mContext.getString(a.h.ala_close_live);
                z = false;
                i = -39322;
                z2 = false;
            } else if (str3.equals("follow_anchor")) {
                str5 = this.mContext.getString(a.h.ala_follow_live);
                a(spannableStringBuilder, aVar.Mo(), aVar2, false, false);
                z = false;
                z2 = false;
                i = -6574339;
            } else if (str3.equals(com.baidu.tbadk.TbConfig.TMP_SHARE_DIR_NAME)) {
                str5 = this.mContext.getString(a.h.ala_share_live);
                a(spannableStringBuilder, aVar.Mo(), aVar2, false, false);
                z = false;
                z2 = false;
                i = -6574339;
            } else if (str3.equals("share_tieba")) {
                str5 = str2;
                z2 = false;
                i = -6574339;
                z = false;
            } else if (str3.equals("remove_video")) {
                str5 = str2;
                z = false;
                z2 = false;
                i = -39322;
            } else if (str3.equals("ueg_warn")) {
                str5 = str2;
                z = false;
                z2 = false;
                i = -39322;
            } else if (str3.equals("live_admin")) {
                a(spannableStringBuilder, aVar.Mo(), aVar2, false, false);
                z = false;
                z2 = false;
                i = -6574339;
                str5 = str2;
            } else if (str3.equals("live_talk_ban") || str3.equals("live_talk_remove_ban") || str3.equals("live_talk_admin_ban") || str3.equals("live_talk_admin_remove_ban")) {
                a(spannableStringBuilder, aVar.Mo(), aVar2, false, false);
                str5 = str2;
                z = false;
                z2 = false;
                i = -39322;
            } else if (str3.equals("challenge_direct_start")) {
                str5 = str2;
                i = -19840;
                z2 = true;
                z = false;
            } else if (str3.equals("challenge_direct_matched")) {
                str5 = str2;
                i = -19840;
                z2 = true;
                z = false;
            } else if (str3.equals("challenge_random_start")) {
                str5 = str2;
                i = -19840;
                z2 = true;
                z = false;
            } else if (str3.equals("challenge_random_matched")) {
                str5 = str2;
                i = -19840;
                z2 = true;
                z = false;
            } else if (str3.equals("avts")) {
                str5 = str2;
                z = false;
                z2 = false;
                i = -39322;
            } else if (str3.equals("allin")) {
                str5 = str2;
                z = false;
                z2 = false;
                i = -39322;
            } else if (str3.equals("share_rmb")) {
                str5 = this.mContext.getString(a.h.yuyin_ala_share_rmb);
                a(spannableStringBuilder, aVar.Mo(), aVar2, false, false);
                z = false;
                z2 = false;
                i = -6574339;
            } else if (str3.equals("zan_rmb")) {
                str5 = this.mContext.getString(a.h.ala_zan_rmb);
                a(spannableStringBuilder, aVar.Mo(), aVar2, false, false);
                z = false;
                z2 = false;
                i = -1711276033;
            } else if (str3.equals("start_grab_wheel")) {
                z = true;
                str5 = null;
                i = -39322;
                z2 = false;
            } else if (str3.equals("guard_club_join")) {
                z = true;
                str5 = null;
                i = -39322;
                z2 = false;
            } else if (str3.equals("haokan_buy_goods")) {
                z = true;
                str5 = null;
                i = -39322;
                z2 = false;
            } else if (str3.equals("send_redpacket")) {
                z = true;
                str5 = null;
                i = -39322;
                z2 = false;
            } else if (str3.equals("start_grab_redpacket")) {
                z = true;
                str5 = null;
                i = -39322;
                z2 = false;
            } else if (str3.equals("guard_seat")) {
                z = true;
                str5 = null;
                i = -39322;
                z2 = false;
            } else if (str3.equals("challenge_mvp")) {
                z = true;
                str5 = null;
                i = -39322;
                z2 = false;
            } else if (str3.equals("challenge_mvp_punish")) {
                z = true;
                str5 = null;
                i = -39322;
                z2 = false;
            } else if (str3.equals("challenge_winner_by_autofail")) {
                z = true;
                str5 = null;
                i = -39322;
                z2 = false;
            } else if (str3.equals("wish_list_success") || str3.equals("wish_list_finish")) {
                z = true;
                str5 = null;
                i = -39322;
                z2 = false;
            } else if (str3.equals("privilege_award_royal_success")) {
                z = true;
                str5 = null;
                i = -39322;
                z2 = false;
            } else if (str3.equals("custom_anchor_identity_update") || str3.equals("custom_master_identity")) {
                str5 = str2;
                z2 = false;
                i = -19840;
                z = false;
            } else if (str3.equals("add_tags_to_anchor")) {
                String str9 = null;
                if (aVar != null && (aVar instanceof com.baidu.live.im.a) && aVar.Mo() != null && TextUtils.equals(aVar.Mo().userId, TbadkCoreApplication.getCurrentAccount())) {
                    str9 = this.mContext.getString(a.h.add_tag_text_yourself);
                }
                a(spannableStringBuilder, aVar.Mo(), aVar2, false, false, true, str9, null);
                str5 = str2;
                z = false;
                z2 = false;
                i = -1;
            } else if (str3.equals("audio_emoticon")) {
                try {
                    String optString2 = jSONObject3.optJSONObject("emoticon_info").optString("result_img");
                    String optString3 = jSONObject3.optJSONObject("emoticon_info").optString("compression_img");
                    if (StringUtils.isNull(optString2, true)) {
                        a(spannableStringBuilder, aVar.Mo(), aVar2, optString3);
                    } else {
                        a(spannableStringBuilder, aVar.Mo(), aVar2, false, false, true);
                    }
                    str5 = str2;
                    z = false;
                    z2 = false;
                    i = -1;
                } catch (Exception e11) {
                    e11.printStackTrace();
                    str5 = str2;
                    z = false;
                    z2 = false;
                    i = -1;
                }
            } else if (str3.equals("follow_anchor_phone")) {
                z = true;
                str5 = null;
                i = -39322;
                z2 = false;
            } else if (str3.equals("follow_room")) {
                z = true;
                str5 = null;
                i = -39322;
                z2 = false;
            } else if (str3.equals("audio_link_toast")) {
                try {
                    str5 = jSONObject3.optJSONObject("data").optString("msg");
                } catch (Exception e12) {
                    e = e12;
                }
                try {
                    a(spannableStringBuilder, aVar.Mo(), aVar2, false, false);
                    z = false;
                    z2 = false;
                    i = -6574339;
                } catch (Exception e13) {
                    e = e13;
                    str822 = str5;
                    e.printStackTrace();
                    str5 = str822;
                    z = false;
                    i = -6574339;
                    z2 = false;
                    if (z) {
                    }
                    return spannableStringBuilder;
                }
            } else if (str3.equals("live_audio_audit_notice")) {
                z = true;
                str5 = null;
                i = -39322;
                z2 = false;
            } else if (str3.equals("audio_hat_level_toast")) {
                z = true;
                str5 = null;
                i = -39322;
                z2 = false;
            } else if (str3.equals("audio_hat_user_toast")) {
                z = true;
                str5 = null;
                i = -39322;
                z2 = false;
            } else if (str3.equals("audio_loot_gift")) {
                z = true;
                str5 = null;
                i = -39322;
                z2 = false;
            } else if (!TextUtils.isEmpty(str2)) {
                str5 = str2;
                z = false;
                z2 = false;
                i = -39322;
            } else {
                str5 = aVar.getContent();
                z = false;
                i = -39322;
                z2 = false;
            }
            if (z) {
                if (TextUtils.isEmpty(aVar.getLink())) {
                    spannableStringBuilder.append(com.baidu.live.utils.g.F(str5, i));
                    if (z2) {
                        com.baidu.live.view.b bVar = new com.baidu.live.view.b(this.mContext, a.e.icon_im_pk);
                        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("  ");
                        spannableStringBuilder2.setSpan(bVar, 0, 1, 33);
                        spannableStringBuilder.insert(0, (CharSequence) spannableStringBuilder2);
                    }
                } else {
                    SpannableString valueOf = SpannableString.valueOf(str5);
                    valueOf.setSpan(new a(this.mContext, aVar.getLink(), str3), 0, str5 != null ? str5.length() : 0, 33);
                    spannableStringBuilder.append((CharSequence) valueOf);
                }
            } else if (TextUtils.equals(str3, "custom_im_notice")) {
                SpannableString valueOf2 = SpannableString.valueOf(str2);
                valueOf2.setSpan(new ForegroundColorSpan(-1711276033), 0, str2.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf2);
                com.baidu.live.view.b bVar2 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_arrow);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("  ");
                spannableStringBuilder3.setSpan(bVar2, 1, 2, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                spannableStringBuilder.setSpan(new a(this.mContext, aVar.getLink(), str3), 0, spannableStringBuilder.length(), 33);
            } else if (TextUtils.equals(str3, "custom_im_notice_live_assistant")) {
                SpannableString valueOf3 = SpannableString.valueOf(str2);
                valueOf3.setSpan(new ForegroundColorSpan(-6574339), 0, str2.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf3);
                com.baidu.live.view.b bVar3 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_arrow);
                SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder("  ");
                spannableStringBuilder4.setSpan(bVar3, 1, 2, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder4);
                spannableStringBuilder.setSpan(new a(this.mContext, aVar.getLink(), str3), 0, spannableStringBuilder.length(), 33);
            } else if (TextUtils.equals(str3, "custom_im_notice_live_assistant")) {
                SpannableString valueOf4 = SpannableString.valueOf(str2);
                valueOf4.setSpan(new ForegroundColorSpan(-6574339), 0, str2.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf4);
                com.baidu.live.view.b bVar4 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_arrow);
                SpannableStringBuilder spannableStringBuilder5 = new SpannableStringBuilder("  ");
                spannableStringBuilder5.setSpan(bVar4, 1, 2, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder5);
                spannableStringBuilder.setSpan(new a(this.mContext, aVar.getLink(), str3), 0, spannableStringBuilder.length(), 33);
            } else if ("send_redpacket".equals(str3) || "start_grab_redpacket".equals(str3)) {
                com.baidu.live.view.b bVar5 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_redpacket);
                SpannableStringBuilder spannableStringBuilder6 = new SpannableStringBuilder("  ");
                spannableStringBuilder6.setSpan(bVar5, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder6);
                a(spannableStringBuilder, aVar.Mo(), aVar2, false, false);
                bY(false);
                if ("send_redpacket".equals(str3)) {
                    String str10 = "";
                    if (jSONObject4 != null) {
                        str10 = jSONObject4.optString(LogConfig.LOG_AMOUNT);
                    }
                    string = String.format(this.mContext.getString(a.h.ala_send_redpacket), str10);
                } else {
                    string = "start_grab_redpacket".equals(str3) ? this.mContext.getString(a.h.ala_start_grab_redpacket) : str5;
                }
                SpannableString valueOf5 = SpannableString.valueOf(string);
                valueOf5.setSpan(new ForegroundColorSpan(-19840), 0, valueOf5.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf5);
                if ("start_grab_redpacket".equals(str3)) {
                    com.baidu.live.view.b bVar6 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_kaiqiang);
                    SpannableStringBuilder spannableStringBuilder7 = new SpannableStringBuilder("  ");
                    spannableStringBuilder7.setSpan(bVar6, 1, 2, 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder7);
                }
                if (jSONObject4 != null) {
                    spannableStringBuilder.setSpan(new a(this.mContext, aVar.getLink(), str3, jSONObject4.optString("live_id"), jSONObject4.optString("anchor_uk"), jSONObject4.optString("red_packet_id"), jSONObject4.optString(UbcStatConstant.KEY_CUSTOM_ROOM_ID), Ma()), 0, spannableStringBuilder.length(), 33);
                }
            } else if (jSONObject3 != null && "guard_seat".equals(str3)) {
                com.baidu.live.view.b bVar7 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_shouhu);
                SpannableStringBuilder spannableStringBuilder8 = new SpannableStringBuilder("  ");
                spannableStringBuilder8.setSpan(bVar7, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder8);
                String optString4 = jSONObject3.optString("prefix");
                String optString5 = jSONObject3.optString("nickname");
                String optString6 = jSONObject3.optString("suffix");
                StringBuilder sb = new StringBuilder(optString4);
                if (!TextUtils.isEmpty(optString5)) {
                    sb.append(" ");
                    sb.append(optString5);
                    sb.append(" ");
                }
                sb.append(optString6);
                String sb2 = sb.toString();
                SpannableString valueOf6 = SpannableString.valueOf(sb2);
                valueOf6.setSpan(new ForegroundColorSpan(-19840), 0, sb2.length(), 33);
                if (!TextUtils.isEmpty(optString5)) {
                    valueOf6.setSpan(new ForegroundColorSpan(-5462), optString4.length() + 1, optString4.length() + 1 + optString5.length(), 33);
                }
                spannableStringBuilder.append((CharSequence) valueOf6, 0, sb2.length());
                boolean z3 = jSONObject3.optInt("is_jump") == 1;
                if (z3) {
                    com.baidu.live.view.b bVar8 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_arrow);
                    SpannableStringBuilder spannableStringBuilder9 = new SpannableStringBuilder("  ");
                    spannableStringBuilder9.setSpan(bVar8, 1, 2, 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder9);
                }
                a aVar3 = new a(this.mContext, aVar.getLink(), str3);
                aVar3.setClickable(z3);
                spannableStringBuilder.setSpan(aVar3, 0, spannableStringBuilder.length(), 33);
            } else if (jSONObject3 != null && "challenge_mvp".equals(str3)) {
                String optString7 = jSONObject3.optString("prefix");
                String optString8 = jSONObject3.optString("nickname");
                String optString9 = jSONObject3.optString("suffix");
                StringBuilder sb3 = new StringBuilder(optString7);
                ForegroundColorSpan foregroundColorSpan = null;
                int i2 = 0;
                int i3 = 0;
                if (!TextUtils.isEmpty(optString8)) {
                    sb3.append(" ");
                    i2 = sb3.length();
                    sb3.append(optString8);
                    i3 = optString8.length() + i2;
                    sb3.append(" ");
                    foregroundColorSpan = new ForegroundColorSpan(-5462);
                }
                sb3.append(optString9);
                String sb4 = sb3.toString();
                SpannableString valueOf7 = SpannableString.valueOf(sb4);
                valueOf7.setSpan(new ForegroundColorSpan(-19840), 0, sb4.length(), 33);
                if (foregroundColorSpan != null) {
                    valueOf7.setSpan(foregroundColorSpan, i2, i3, 33);
                }
                spannableStringBuilder.append((CharSequence) valueOf7, 0, sb4.length());
                com.baidu.live.view.b bVar9 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_pk);
                SpannableStringBuilder spannableStringBuilder10 = new SpannableStringBuilder("  ");
                spannableStringBuilder10.setSpan(bVar9, 0, 1, 33);
                spannableStringBuilder.insert(0, (CharSequence) spannableStringBuilder10);
            } else if (jSONObject3 != null && "challenge_mvp_punish".equals(str3)) {
                int optInt = jSONObject3.optInt("punish_type");
                String optString10 = jSONObject3.optString("mvp_nickname");
                String optString11 = jSONObject3.optString("sticker_name");
                String optString12 = jSONObject3.optString("text");
                if (optInt == 1) {
                    optString12 = String.format(this.mContext.getString(a.h.txt_im_mvp_punish_choose), optString10, optString11);
                } else if (optInt == 2) {
                    optString12 = String.format(this.mContext.getString(a.h.txt_im_mvp_punish_letoff), optString10);
                } else if (optInt == 3) {
                    optString12 = String.format(this.mContext.getString(a.h.txt_im_mvp_punish_notchoose), optString10, optString11);
                } else if (optInt != 4) {
                    optString12 = str5;
                }
                if (optString12 == null) {
                    optString12 = "";
                }
                SpannableString valueOf8 = SpannableString.valueOf(optString12);
                valueOf8.setSpan(new ForegroundColorSpan(-19840), 0, optString12.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf8);
                com.baidu.live.view.b bVar10 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_pk);
                SpannableStringBuilder spannableStringBuilder11 = new SpannableStringBuilder("  ");
                spannableStringBuilder11.setSpan(bVar10, 0, 1, 33);
                spannableStringBuilder.insert(0, (CharSequence) spannableStringBuilder11);
            } else if (jSONObject3 != null && "challenge_winner_by_autofail".equals(str3)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = this.mContext.getString(a.h.ala_challenge_winner_by_autofail);
                }
                SpannableString valueOf9 = SpannableString.valueOf(str2);
                valueOf9.setSpan(new ForegroundColorSpan(-19840), 0, str2.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf9, 0, str2.length());
                com.baidu.live.view.b bVar11 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_pk);
                SpannableStringBuilder spannableStringBuilder12 = new SpannableStringBuilder("  ");
                spannableStringBuilder12.setSpan(bVar11, 0, 1, 33);
                spannableStringBuilder.insert(0, (CharSequence) spannableStringBuilder12);
            } else if ("wish_list_success".equals(str3) || "wish_list_finish".equals(str3)) {
                com.baidu.live.view.b bVar12 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_xinyuan);
                SpannableStringBuilder spannableStringBuilder13 = new SpannableStringBuilder("  ");
                spannableStringBuilder13.setSpan(bVar12, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder13);
                SpannableString valueOf10 = SpannableString.valueOf(str2);
                valueOf10.setSpan(new ForegroundColorSpan(-6574339), 0, valueOf10.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf10);
                if (!this.bkL) {
                    com.baidu.live.view.b bVar13 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_zhuli);
                    SpannableStringBuilder spannableStringBuilder14 = new SpannableStringBuilder("  ");
                    spannableStringBuilder14.setSpan(bVar13, 1, 2, 33);
                    spannableStringBuilder.insert(spannableStringBuilder.length(), (CharSequence) spannableStringBuilder14);
                }
                spannableStringBuilder.setSpan(new a(this.mContext, aVar.getLink(), str3), 0, spannableStringBuilder.length(), 33);
            } else if ("start_grab_wheel".equals(str3)) {
                com.baidu.live.view.b bVar14 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_zhuanpan);
                SpannableStringBuilder spannableStringBuilder15 = new SpannableStringBuilder("  ");
                spannableStringBuilder15.setSpan(bVar14, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder15);
                spannableStringBuilder.append(com.baidu.live.utils.g.F(this.mContext.getString(a.h.ala_lucky_tab_tips2), -6574339));
                a(spannableStringBuilder, aVar.Mo(), aVar2, false, false);
                bY(false);
                String str11 = "";
                String str12 = "";
                String str13 = "";
                if (jSONObject4 != null) {
                    str11 = jSONObject4.optString(LogConfig.LOG_AMOUNT);
                    str12 = jSONObject4.optString("keywords");
                    str13 = jSONObject4.optString("gift_url");
                }
                spannableStringBuilder.append(com.baidu.live.utils.g.F(String.format(this.mContext.getString(a.h.ala_lucky_tab_tips), str11, str12), -6574339));
                AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                alaLiveMarkData.mark_pic = str13;
                com.baidu.live.view.b bVar15 = new com.baidu.live.view.b(this.mContext, alaLiveMarkData, false, null);
                SpannableStringBuilder spannableStringBuilder16 = new SpannableStringBuilder("  ");
                spannableStringBuilder16.setSpan(bVar15, 1, 2, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder16);
            } else if (TextUtils.equals("guard_club_join", str3)) {
                com.baidu.live.view.b bVar16 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_zhenai);
                SpannableStringBuilder spannableStringBuilder17 = new SpannableStringBuilder("  ");
                spannableStringBuilder17.setSpan(bVar16, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder17);
                spannableStringBuilder.append(com.baidu.live.utils.g.F(this.mContext.getString(a.h.ala_guard_club_join_welcome), -6574339));
                a(spannableStringBuilder, aVar.Mo(), aVar2, false, false);
                bY(false);
                spannableStringBuilder.append(com.baidu.live.utils.g.F(this.mContext.getString(a.h.ala_guard_club_join), -6574339));
                if (!this.bkL) {
                    com.baidu.live.view.b bVar17 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_jiaru);
                    SpannableStringBuilder spannableStringBuilder18 = new SpannableStringBuilder("  ");
                    spannableStringBuilder18.setSpan(bVar17, 1, 2, 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder18);
                }
                spannableStringBuilder.setSpan(new a(this.mContext, aVar.getLink(), str3), 0, spannableStringBuilder.length(), 33);
            } else if (jSONObject3 != null && TextUtils.equals(str3, "privilege_award_royal_success")) {
                final String optString13 = jSONObject3.optString("icon_url");
                this.ble = optString13;
                if (!TextUtils.isEmpty(optString13)) {
                    new AlaLiveMarkData().mark_pic = optString13;
                    BdResourceLoader.getInstance().loadResource(optString13, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.yuyinim.a.d.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                        public void onLoaded(BdImage bdImage, String str14, int i4) {
                            super.onLoaded((AnonymousClass1) bdImage, str14, i4);
                            Bitmap a2 = d.this.a(bdImage);
                            if (a2 != null && TextUtils.equals(d.this.ble, optString13)) {
                                CenteredImageSpan centeredImageSpan = new CenteredImageSpan(d.this.mContext, a2);
                                SpannableString spannableString = new SpannableString("[img] ");
                                spannableString.setSpan(centeredImageSpan, 0, spannableString.length() - 1, 33);
                                spannableStringBuilder.insert(0, (CharSequence) spannableString);
                                aVar2.bhB.setText(spannableStringBuilder);
                                aVar2.bhB.forceLayout();
                            }
                        }
                    }, null);
                }
                a(spannableStringBuilder, aVar.Mo(), aVar2, false, false);
                bY(false);
                int optInt2 = jSONObject3.optInt("royal_level");
                String str14 = "";
                if (optInt2 >= 0 && optInt2 <= 7) {
                    str14 = AlaLiveMarkData.NOBLE_LEVEL_NAMES[optInt2];
                }
                if (TextUtils.equals(aVar.Mo().userId, TbadkCoreApplication.getCurrentAccount())) {
                    format = String.format(this.mContext.getString(a.h.txt_im_noble_update_mine), str14);
                } else {
                    format = String.format(this.mContext.getString(a.h.txt_im_noble_update), str14);
                }
                spannableStringBuilder.append(com.baidu.live.utils.g.F(format, -19840));
            } else if (TextUtils.equals("haokan_buy_goods", str3)) {
                com.baidu.live.view.b bVar18 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_viewer_shopping);
                SpannableStringBuilder spannableStringBuilder19 = new SpannableStringBuilder("  ");
                spannableStringBuilder19.setSpan(bVar18, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder19);
                spannableStringBuilder.append(com.baidu.live.utils.g.F(str2, -1));
            } else if (jSONObject3 != null && TextUtils.equals("follow_anchor_phone", str3)) {
                String optString14 = jSONObject3.optString("wheat_user_nickname");
                a(spannableStringBuilder, aVar.Mo(), aVar2, false, false);
                spannableStringBuilder.append(com.baidu.live.utils.g.F("关注了 ", -6574339));
                spannableStringBuilder.append(com.baidu.live.utils.g.F(optString14, -5462));
            } else if (TextUtils.equals("follow_room", str3)) {
                a(spannableStringBuilder, aVar.Mo(), aVar2, false, false);
                spannableStringBuilder.append(com.baidu.live.utils.g.F("收藏了本房间", -6574339));
            } else if (jSONObject3 != null && TextUtils.equals("live_audio_audit_notice", str3)) {
                spannableStringBuilder.append(com.baidu.live.utils.g.F(jSONObject3.optString("text"), -39322));
            } else if (jSONObject3 != null && TextUtils.equals("audio_hat_level_toast", str3)) {
                String[] split2 = String.format(jSONObject3.optJSONObject("data").optString("msg"), jSONObject3.optJSONObject("data").optString("content")).split(" ")[1].split("，");
                a(spannableStringBuilder, aVar.Mo(), aVar2, false, false, true);
                spannableStringBuilder.append(com.baidu.live.utils.g.F(split[0] + " ", -1));
                spannableStringBuilder.append(com.baidu.live.utils.g.F(split2[0], -5462));
                spannableStringBuilder.append(com.baidu.live.utils.g.F("，" + split2[1], -1));
            } else if (jSONObject3 != null && TextUtils.equals("audio_hat_user_toast", str3)) {
                String[] split3 = String.format(jSONObject3.optJSONObject("data").optString("msg"), jSONObject3.optJSONObject("data").optString("content")).split(" ");
                a(spannableStringBuilder, aVar.Mo(), aVar2, false, false, true);
                spannableStringBuilder.append(com.baidu.live.utils.g.F(split3[0] + " ", -1));
                spannableStringBuilder.append(com.baidu.live.utils.g.F(split3[1], -5462));
                spannableStringBuilder.append(com.baidu.live.utils.g.F(" " + split3[2], -1));
            } else if (jSONObject3 != null && TextUtils.equals("audio_loot_gift", str3)) {
                String[] split4 = String.format(jSONObject3.optJSONObject("data").optString("msg"), jSONObject3.optString("user_nickname")).split(" ");
                spannableStringBuilder.append(com.baidu.live.utils.g.F(split4[0] + " ", -19840));
                spannableStringBuilder.append(com.baidu.live.utils.g.F(split4[1] + " ", -5462));
                spannableStringBuilder.append(com.baidu.live.utils.g.F(split4[2], -19840));
                com.baidu.live.view.b bVar19 = new com.baidu.live.view.b(this.mContext, a.e.yuyin_im_box);
                SpannableStringBuilder spannableStringBuilder20 = new SpannableStringBuilder("  ");
                spannableStringBuilder20.setSpan(bVar19, 0, 1, 33);
                spannableStringBuilder.insert(0, (CharSequence) spannableStringBuilder20);
            }
        }
        return spannableStringBuilder;
    }

    /* loaded from: classes4.dex */
    private static class a extends ClickableSpan {
        private String aQw;
        private String aSO;
        private boolean blm;
        private String contentType;
        private Context context;
        private String customRoomId;
        private boolean isHost;
        private String liveId;
        private String url;

        public a(Context context, String str, String str2) {
            this.context = context;
            this.url = str;
            this.contentType = str2;
        }

        public a(Context context, String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
            this.context = context;
            this.url = str;
            this.contentType = str2;
            this.liveId = str3;
            this.aSO = str4;
            this.aQw = str5;
            this.customRoomId = str6;
            this.isHost = z;
        }

        public void setClickable(boolean z) {
            this.blm = z;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = this.contentType;
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
                case 39010809:
                    if (str.equals("guard_club_join")) {
                        c = 4;
                        break;
                    }
                    break;
                case 973563845:
                    if (str.equals("custom_im_notice_live_assistant")) {
                        c = 5;
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
                    cw cwVar = new cw();
                    cwVar.aQw = this.aQw;
                    cwVar.liveId = this.liveId;
                    cwVar.aSO = this.aSO;
                    cwVar.roomId = this.customRoomId;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, cwVar));
                    return;
                case 1:
                    if (this.blm) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913153));
                        return;
                    }
                    return;
                case 2:
                case 3:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913154, null));
                    return;
                case 4:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106, "im"));
                    return;
                case 5:
                    if (!TextUtils.isEmpty(this.url)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913132, this.url));
                        return;
                    }
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

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap a(BdImage bdImage) {
        Bitmap copy;
        Bitmap copy2;
        if (bdImage == null) {
            return null;
        }
        Bitmap rawBitmap = bdImage.getRawBitmap();
        if (rawBitmap == null || rawBitmap.isRecycled()) {
            return null;
        }
        try {
            if (rawBitmap.getConfig() == null) {
                copy2 = rawBitmap.copy(Bitmap.Config.ARGB_8888, false);
            } else {
                copy2 = rawBitmap.copy(rawBitmap.getConfig(), false);
            }
            copy = copy2;
        } catch (OutOfMemoryError e) {
            BdLog.e(e);
            if (rawBitmap.getConfig() != null) {
                return null;
            }
            try {
                copy = rawBitmap.copy(Bitmap.Config.RGB_565, false);
            } catch (OutOfMemoryError e2) {
                BdLog.e(e2);
                return null;
            }
        }
        if (copy == null) {
            return null;
        }
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds32);
        try {
            Bitmap resizeBitmap = BdBitmapHelper.getInstance().resizeBitmap(copy, (int) (((copy.getWidth() * 1.0f) * dimensionPixelSize) / copy.getHeight()), dimensionPixelSize);
            if (resizeBitmap != copy) {
                copy.recycle();
                return resizeBitmap;
            }
            return resizeBitmap;
        } catch (OutOfMemoryError e3) {
            BdLog.e(e3);
            if (copy != null) {
                copy.recycle();
            }
            return null;
        }
    }
}

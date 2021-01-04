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
import com.baidu.live.data.dc;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.ubc.UbcAudioFlowStatisticManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d extends b {
    private String bpA;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(Context context) {
        super(context, com.baidu.live.im.a.blu);
    }

    @Override // com.baidu.live.yuyinim.a.b
    protected void MW() {
        if (MX()) {
            MY();
        } else {
            MZ();
        }
    }

    @Override // com.baidu.live.yuyinim.a.b
    protected int getColor() {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x06ed  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010d  */
    @Override // com.baidu.live.yuyinim.a.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected SpannableStringBuilder a(com.baidu.live.im.data.b bVar, final com.baidu.live.yuyinim.a aVar) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        String str;
        String str2;
        String str3;
        boolean z;
        boolean z2;
        int i;
        String string;
        String[] split;
        String format;
        String str4;
        String str5;
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        this.bpA = null;
        String str6 = null;
        String str7 = "";
        String str8 = "";
        JSONObject jSONObject4 = null;
        if (bVar != null) {
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(bVar.getContent());
                }
                try {
                    str6 = jSONObject.optString("content_type");
                    if (str6.equals("start_grab_wheel")) {
                        str5 = jSONObject.optString("ext_data");
                    } else {
                        String optString = jSONObject.optString("ext");
                        if (TextUtils.isEmpty(optString)) {
                            str5 = "";
                        } else {
                            str5 = new String(Base64.decode(optString.getBytes(), 0));
                        }
                        if (TbConfig.isForceNoticeIm) {
                            str5 = optString;
                        }
                    }
                    if (!TextUtils.isEmpty(str5)) {
                        jSONObject4 = new JSONObject(str5);
                    }
                    str7 = jSONObject.optString("text");
                    str8 = jSONObject.optString("level_id");
                    jSONObject2 = jSONObject;
                    jSONObject3 = jSONObject4;
                    str = str7;
                    str2 = str6;
                } catch (JSONException e) {
                    e = e;
                    e.printStackTrace();
                    jSONObject2 = jSONObject;
                    jSONObject3 = jSONObject4;
                    str = str7;
                    str2 = str6;
                    if (!TextUtils.isEmpty(str8)) {
                        bVar.Nw().level_id = JavaTypesHelper.toInt(str8, 0);
                    }
                    String str9 = null;
                    if (str2 == null) {
                    }
                    if (z) {
                    }
                    return spannableStringBuilder;
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    jSONObject2 = jSONObject;
                    jSONObject3 = jSONObject4;
                    str = str7;
                    str2 = str6;
                    if (!TextUtils.isEmpty(str8)) {
                    }
                    String str92 = null;
                    if (str2 == null) {
                    }
                    if (z) {
                    }
                    return spannableStringBuilder;
                }
            } catch (JSONException e3) {
                e = e3;
                jSONObject = null;
            } catch (Exception e4) {
                e = e4;
                jSONObject = null;
            }
            if (!TextUtils.isEmpty(str8) && JavaTypesHelper.toInt(str8, 0) > 0) {
                bVar.Nw().level_id = JavaTypesHelper.toInt(str8, 0);
            }
            String str922 = null;
            if (str2 == null) {
                if (!TextUtils.isEmpty(str)) {
                    str3 = str;
                    z = false;
                    z2 = false;
                    i = -39322;
                } else {
                    str3 = bVar.getContent();
                    z = false;
                    z2 = false;
                    i = -39322;
                }
            } else if (str2.equals("audio_custom_live_notice")) {
                UbcAudioFlowStatisticManager.getInstance().endFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_IM_RECENT_MSG_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""));
                str3 = str;
                z = false;
                z2 = false;
                i = -1;
            } else if (str2.equals("custom_live_notice")) {
                UbcAudioFlowStatisticManager.getInstance().endFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_IM_RECENT_MSG_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""));
                str3 = str;
                z = false;
                z2 = false;
                i = -1;
            } else if (str2.equals("custom_im_notice")) {
                z = true;
                str3 = null;
                z2 = false;
                i = -39322;
            } else if (str2.equals("play_rules")) {
                str3 = str;
                z = false;
                z2 = false;
                i = -6574339;
            } else if (str2.equals("custom_im_notice_live_assistant")) {
                z = true;
                str3 = null;
                z2 = false;
                i = -39322;
            } else if (str2.equals("custom_network_change")) {
                str3 = str;
                z = false;
                z2 = false;
                i = -39322;
            } else if (str2.equals("enter_live")) {
                String string2 = this.mContext.getString(a.h.ala_enter_live);
                a(spannableStringBuilder, bVar.Nw(), aVar, false, false, false);
                str3 = string2;
                z = false;
                z2 = false;
                i = -1711276033;
            } else if (str2.equals("backstage_live")) {
                str3 = str;
                z = false;
                z2 = false;
                i = -6574339;
            } else if (str2.equals("offline_type")) {
                str3 = str;
                z = false;
                z2 = false;
                i = -39322;
            } else if (str2.equals("close_live")) {
                str3 = this.mContext.getString(a.h.ala_close_live);
                z = false;
                z2 = false;
                i = -39322;
            } else if (str2.equals("follow_anchor")) {
                str3 = this.mContext.getString(a.h.ala_follow_live);
                a(spannableStringBuilder, bVar.Nw(), aVar, false, false);
                z = false;
                z2 = false;
                i = -6574339;
            } else if (str2.equals(com.baidu.tbadk.TbConfig.TMP_SHARE_DIR_NAME)) {
                str3 = this.mContext.getString(a.h.ala_share_live);
                a(spannableStringBuilder, bVar.Nw(), aVar, false, false);
                z = false;
                z2 = false;
                i = -6574339;
            } else if (str2.equals("share_tieba")) {
                str3 = str;
                z = false;
                z2 = false;
                i = -6574339;
            } else if (str2.equals("remove_video")) {
                str3 = str;
                z = false;
                z2 = false;
                i = -39322;
            } else if (str2.equals("ueg_warn")) {
                str3 = str;
                z = false;
                z2 = false;
                i = -39322;
            } else if (str2.equals("live_admin")) {
                a(spannableStringBuilder, bVar.Nw(), aVar, false, false);
                str3 = str;
                z = false;
                z2 = false;
                i = -6574339;
            } else if (str2.equals("live_talk_ban") || str2.equals("live_talk_remove_ban") || str2.equals("live_talk_admin_ban") || str2.equals("live_talk_admin_remove_ban")) {
                a(spannableStringBuilder, bVar.Nw(), aVar, false, false);
                str3 = str;
                z = false;
                z2 = false;
                i = -39322;
            } else if (str2.equals("challenge_direct_start")) {
                i = -19840;
                JSONObject jSONObject5 = new JSONObject();
                try {
                    jSONObject5.put("text", str);
                } catch (JSONException e5) {
                    e5.printStackTrace();
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_IM, "liveroom", "challenge_direct_start").setContentExt(null, null, jSONObject5));
                str3 = str;
                z = false;
                z2 = true;
            } else if (str2.equals("challenge_direct_matched")) {
                i = -19840;
                JSONObject jSONObject6 = new JSONObject();
                try {
                    jSONObject6.put("text", str);
                } catch (JSONException e6) {
                    e6.printStackTrace();
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_IM, "liveroom", "challenge_direct_matched").setContentExt(null, null, jSONObject6));
                str3 = str;
                z = false;
                z2 = true;
            } else if (str2.equals("challenge_random_start")) {
                i = -19840;
                JSONObject jSONObject7 = new JSONObject();
                try {
                    jSONObject7.put("text", str);
                } catch (JSONException e7) {
                    e7.printStackTrace();
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_IM, "liveroom", "challenge_random_start").setContentExt(null, null, jSONObject7));
                str3 = str;
                z = false;
                z2 = true;
            } else if (str2.equals("challenge_random_matched")) {
                i = -19840;
                JSONObject jSONObject8 = new JSONObject();
                try {
                    jSONObject8.put("text", str);
                } catch (JSONException e8) {
                    e8.printStackTrace();
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_IM, "liveroom", "challenge_random_matched").setContentExt(null, null, jSONObject8));
                str3 = str;
                z = false;
                z2 = true;
            } else if (str2.equals("avts")) {
                str3 = str;
                z = false;
                z2 = false;
                i = -39322;
            } else if (str2.equals("allin")) {
                str3 = str;
                z = false;
                z2 = false;
                i = -39322;
            } else if (str2.equals("share_rmb")) {
                str3 = this.mContext.getString(a.h.yuyin_ala_share_rmb);
                a(spannableStringBuilder, bVar.Nw(), aVar, false, false);
                z = false;
                z2 = false;
                i = -6574339;
            } else if (str2.equals("zan_rmb")) {
                str3 = this.mContext.getString(a.h.ala_zan_rmb);
                a(spannableStringBuilder, bVar.Nw(), aVar, false, false);
                z = false;
                z2 = false;
                i = -1711276033;
            } else if (str2.equals("start_grab_wheel")) {
                z = true;
                str3 = null;
                z2 = false;
                i = -39322;
            } else if (str2.equals("guard_club_join")) {
                z = true;
                str3 = null;
                z2 = false;
                i = -39322;
            } else if (str2.equals("haokan_buy_goods")) {
                z = true;
                str3 = null;
                z2 = false;
                i = -39322;
            } else if (str2.equals("send_redpacket")) {
                z = true;
                str3 = null;
                z2 = false;
                i = -39322;
            } else if (str2.equals("start_grab_redpacket")) {
                z = true;
                str3 = null;
                z2 = false;
                i = -39322;
            } else if (str2.equals("guard_seat")) {
                z = true;
                str3 = null;
                z2 = false;
                i = -39322;
            } else if (str2.equals("challenge_mvp")) {
                z = true;
                str3 = null;
                z2 = false;
                i = -39322;
            } else if (str2.equals("challenge_mvp_punish")) {
                z = true;
                str3 = null;
                z2 = false;
                i = -39322;
            } else if (str2.equals("challenge_winner_by_autofail")) {
                z = true;
                str3 = null;
                z2 = false;
                i = -39322;
            } else if (str2.equals("wish_list_success") || str2.equals("wish_list_finish")) {
                z = true;
                str3 = null;
                z2 = false;
                i = -39322;
            } else if (str2.equals("privilege_award_royal_success")) {
                z = true;
                str3 = null;
                z2 = false;
                i = -39322;
            } else if (str2.equals("custom_anchor_identity_update") || str2.equals("custom_master_identity")) {
                str3 = str;
                z = false;
                z2 = false;
                i = -19840;
            } else if (str2.equals("add_tags_to_anchor")) {
                String str10 = null;
                if (bVar != null && (bVar instanceof com.baidu.live.im.a) && bVar.Nw() != null && TextUtils.equals(bVar.Nw().userId, TbadkCoreApplication.getCurrentAccount())) {
                    str10 = this.mContext.getString(a.h.add_tag_text_yourself);
                }
                a(spannableStringBuilder, bVar.Nw(), aVar, false, false, true, str10, null);
                str3 = str;
                z = false;
                z2 = false;
                i = -1;
            } else if (str2.equals("audio_emoticon")) {
                try {
                    String optString2 = jSONObject2.optJSONObject("emoticon_info").optString("result_img");
                    String optString3 = jSONObject2.optJSONObject("emoticon_info").optString("compression_img");
                    if (StringUtils.isNull(optString2, true)) {
                        a(spannableStringBuilder, bVar.Nw(), aVar, optString3);
                    } else {
                        a(spannableStringBuilder, bVar.Nw(), aVar, false, false, true);
                    }
                    str3 = str;
                    z = false;
                    z2 = false;
                    i = -1;
                } catch (Exception e9) {
                    e9.printStackTrace();
                    str3 = str;
                    z = false;
                    z2 = false;
                    i = -1;
                }
            } else if (str2.equals("follow_anchor_phone")) {
                z = true;
                str3 = null;
                z2 = false;
                i = -39322;
            } else if (str2.equals("follow_room")) {
                z = true;
                str3 = null;
                z2 = false;
                i = -39322;
            } else if (str2.equals("audio_link_toast")) {
                try {
                    str3 = jSONObject2.optJSONObject("data").optString("msg");
                    try {
                        a(spannableStringBuilder, bVar.Nw(), aVar, false, false);
                        z = false;
                        z2 = false;
                        i = -6574339;
                    } catch (Exception e10) {
                        e = e10;
                        str922 = str3;
                        e.printStackTrace();
                        str3 = str922;
                        z = false;
                        z2 = false;
                        i = -6574339;
                        if (z) {
                        }
                        return spannableStringBuilder;
                    }
                } catch (Exception e11) {
                    e = e11;
                }
            } else if (str2.equals("mode_change_stage")) {
                i = -19840;
                try {
                    str3 = jSONObject2.optString("msg");
                    z = false;
                    z2 = false;
                } catch (Exception e12) {
                    e12.printStackTrace();
                    str3 = null;
                    z = false;
                    z2 = false;
                }
            } else if (str2.equals("mode_add_time")) {
                i = -19840;
                try {
                    str3 = jSONObject2.optString("msg");
                    z = false;
                    z2 = false;
                } catch (Exception e13) {
                    e13.printStackTrace();
                    str3 = null;
                    z = false;
                    z2 = false;
                }
            } else if (str2.equals("live_audio_audit_notice")) {
                z = true;
                str3 = null;
                z2 = false;
                i = -39322;
            } else if (str2.equals("audio_hat_level_toast")) {
                z = true;
                str3 = null;
                z2 = false;
                i = -39322;
            } else if (str2.equals("audio_hat_user_toast")) {
                z = true;
                str3 = null;
                z2 = false;
                i = -39322;
            } else if (str2.equals("audio_loot_gift")) {
                z = true;
                str3 = null;
                z2 = false;
                i = -39322;
            } else if (!TextUtils.isEmpty(str)) {
                str3 = str;
                z = false;
                z2 = false;
                i = -39322;
            } else {
                str3 = bVar.getContent();
                z = false;
                z2 = false;
                i = -39322;
            }
            if (z) {
                if (TextUtils.isEmpty(bVar.getLink())) {
                    spannableStringBuilder.append(com.baidu.live.utils.g.I(str3, i));
                    if (z2) {
                        com.baidu.live.view.b bVar2 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_pk);
                        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("  ");
                        spannableStringBuilder2.setSpan(bVar2, 0, 1, 33);
                        spannableStringBuilder.insert(0, (CharSequence) spannableStringBuilder2);
                    }
                } else {
                    SpannableString valueOf = SpannableString.valueOf(str3);
                    valueOf.setSpan(new a(this.mContext, bVar.getLink(), str2), 0, str3 != null ? str3.length() : 0, 33);
                    spannableStringBuilder.append((CharSequence) valueOf);
                }
            } else if (TextUtils.equals(str2, "custom_im_notice")) {
                SpannableString valueOf2 = SpannableString.valueOf(str);
                valueOf2.setSpan(new ForegroundColorSpan(-1711276033), 0, str.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf2);
                com.baidu.live.view.b bVar3 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_arrow);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("  ");
                spannableStringBuilder3.setSpan(bVar3, 1, 2, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                spannableStringBuilder.setSpan(new a(this.mContext, bVar.getLink(), str2), 0, spannableStringBuilder.length(), 33);
            } else if (TextUtils.equals(str2, "custom_im_notice_live_assistant")) {
                SpannableString valueOf3 = SpannableString.valueOf(str);
                valueOf3.setSpan(new ForegroundColorSpan(-6574339), 0, str.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf3);
                com.baidu.live.view.b bVar4 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_arrow);
                SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder("  ");
                spannableStringBuilder4.setSpan(bVar4, 1, 2, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder4);
                spannableStringBuilder.setSpan(new a(this.mContext, bVar.getLink(), str2), 0, spannableStringBuilder.length(), 33);
            } else if (TextUtils.equals(str2, "custom_im_notice_live_assistant")) {
                SpannableString valueOf4 = SpannableString.valueOf(str);
                valueOf4.setSpan(new ForegroundColorSpan(-6574339), 0, str.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf4);
                com.baidu.live.view.b bVar5 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_arrow);
                SpannableStringBuilder spannableStringBuilder5 = new SpannableStringBuilder("  ");
                spannableStringBuilder5.setSpan(bVar5, 1, 2, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder5);
                spannableStringBuilder.setSpan(new a(this.mContext, bVar.getLink(), str2), 0, spannableStringBuilder.length(), 33);
            } else if ("send_redpacket".equals(str2) || "start_grab_redpacket".equals(str2)) {
                com.baidu.live.view.b bVar6 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_redpacket);
                SpannableStringBuilder spannableStringBuilder6 = new SpannableStringBuilder("  ");
                spannableStringBuilder6.setSpan(bVar6, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder6);
                a(spannableStringBuilder, bVar.Nw(), aVar, false, false);
                cj(false);
                if ("send_redpacket".equals(str2)) {
                    String str11 = "";
                    if (jSONObject3 != null) {
                        str11 = jSONObject3.optString(LogConfig.LOG_AMOUNT);
                    }
                    string = String.format(this.mContext.getString(a.h.ala_send_redpacket), str11);
                } else {
                    string = "start_grab_redpacket".equals(str2) ? this.mContext.getString(a.h.ala_start_grab_redpacket) : str3;
                }
                SpannableString valueOf5 = SpannableString.valueOf(string);
                valueOf5.setSpan(new ForegroundColorSpan(-19840), 0, valueOf5.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf5);
                if ("start_grab_redpacket".equals(str2)) {
                    com.baidu.live.view.b bVar7 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_kaiqiang);
                    SpannableStringBuilder spannableStringBuilder7 = new SpannableStringBuilder("  ");
                    spannableStringBuilder7.setSpan(bVar7, 1, 2, 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder7);
                }
                if (jSONObject3 != null) {
                    spannableStringBuilder.setSpan(new a(this.mContext, bVar.getLink(), str2, jSONObject3.optString("live_id"), jSONObject3.optString("anchor_uk"), jSONObject3.optString("red_packet_id"), jSONObject3.optString(UbcStatConstant.KEY_CUSTOM_ROOM_ID), MV()), 0, spannableStringBuilder.length(), 33);
                }
            } else if (jSONObject2 != null && "audio_low_version_toast".equals(str2)) {
                SpannableString valueOf6 = SpannableString.valueOf(jSONObject2.optJSONObject("data").optString("msg"));
                valueOf6.setSpan(new ForegroundColorSpan(-6574339), 0, valueOf6.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf6);
                com.baidu.live.view.b bVar8 = new com.baidu.live.view.b(this.mContext, a.e.icon_low_version_toast);
                SpannableStringBuilder spannableStringBuilder8 = new SpannableStringBuilder("  ");
                spannableStringBuilder8.setSpan(bVar8, 1, 2, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder8);
                spannableStringBuilder.setSpan(new a(this.mContext, bVar.getLink(), str2), 0, spannableStringBuilder.length(), 33);
            } else if (jSONObject2 != null && "guard_seat".equals(str2)) {
                com.baidu.live.view.b bVar9 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_shouhu);
                SpannableStringBuilder spannableStringBuilder9 = new SpannableStringBuilder("  ");
                spannableStringBuilder9.setSpan(bVar9, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder9);
                String optString4 = jSONObject2.optString("prefix");
                String optString5 = jSONObject2.optString("nickname");
                String optString6 = jSONObject2.optString("suffix");
                StringBuilder sb = new StringBuilder(optString4);
                if (!TextUtils.isEmpty(optString5)) {
                    sb.append(" ");
                    sb.append(optString5);
                    sb.append(" ");
                }
                sb.append(optString6);
                String sb2 = sb.toString();
                SpannableString valueOf7 = SpannableString.valueOf(sb2);
                valueOf7.setSpan(new ForegroundColorSpan(-19840), 0, sb2.length(), 33);
                if (!TextUtils.isEmpty(optString5)) {
                    valueOf7.setSpan(new ForegroundColorSpan(-5462), optString4.length() + 1, optString4.length() + 1 + optString5.length(), 33);
                }
                spannableStringBuilder.append((CharSequence) valueOf7, 0, sb2.length());
                boolean z3 = jSONObject2.optInt("is_jump") == 1;
                if (z3) {
                    com.baidu.live.view.b bVar10 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_arrow);
                    SpannableStringBuilder spannableStringBuilder10 = new SpannableStringBuilder("  ");
                    spannableStringBuilder10.setSpan(bVar10, 1, 2, 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder10);
                }
                a aVar2 = new a(this.mContext, bVar.getLink(), str2);
                aVar2.setClickable(z3);
                spannableStringBuilder.setSpan(aVar2, 0, spannableStringBuilder.length(), 33);
            } else if (jSONObject2 != null && "challenge_mvp".equals(str2)) {
                String optString7 = jSONObject2.optString("prefix");
                String optString8 = jSONObject2.optString("nickname");
                String optString9 = jSONObject2.optString("suffix");
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
                SpannableString valueOf8 = SpannableString.valueOf(sb4);
                valueOf8.setSpan(new ForegroundColorSpan(-19840), 0, sb4.length(), 33);
                if (foregroundColorSpan != null) {
                    valueOf8.setSpan(foregroundColorSpan, i2, i3, 33);
                }
                spannableStringBuilder.append((CharSequence) valueOf8, 0, sb4.length());
                com.baidu.live.view.b bVar11 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_pk);
                SpannableStringBuilder spannableStringBuilder11 = new SpannableStringBuilder("  ");
                spannableStringBuilder11.setSpan(bVar11, 0, 1, 33);
                spannableStringBuilder.insert(0, (CharSequence) spannableStringBuilder11);
                JSONObject jSONObject9 = new JSONObject();
                try {
                    jSONObject9.put("nickname", optString8);
                } catch (JSONException e14) {
                    e14.printStackTrace();
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_IM, "liveroom", "challenge_mvp").setContentExt(null, null, jSONObject9));
            } else if (jSONObject2 != null && "challenge_mvp_punish".equals(str2)) {
                int optInt = jSONObject2.optInt("punish_type");
                String optString10 = jSONObject2.optString("mvp_nickname");
                String optString11 = jSONObject2.optString("sticker_name");
                String optString12 = jSONObject2.optString("text");
                if (optInt == 1) {
                    str4 = String.format(this.mContext.getString(a.h.txt_im_mvp_punish_choose), optString10, optString11);
                } else if (optInt == 2) {
                    str4 = String.format(this.mContext.getString(a.h.txt_im_mvp_punish_letoff), optString10);
                } else if (optInt == 3) {
                    str4 = String.format(this.mContext.getString(a.h.txt_im_mvp_punish_notchoose), optString10, optString11);
                } else {
                    str4 = optInt == 4 ? optString12 : str3;
                }
                if (str4 == null) {
                    str4 = "";
                }
                SpannableString valueOf9 = SpannableString.valueOf(str4);
                valueOf9.setSpan(new ForegroundColorSpan(-19840), 0, str4.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf9);
                com.baidu.live.view.b bVar12 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_pk);
                SpannableStringBuilder spannableStringBuilder12 = new SpannableStringBuilder("  ");
                spannableStringBuilder12.setSpan(bVar12, 0, 1, 33);
                spannableStringBuilder.insert(0, (CharSequence) spannableStringBuilder12);
                JSONObject jSONObject10 = new JSONObject();
                try {
                    jSONObject10.put("punish_type", optInt);
                    jSONObject10.put("mvp_nickname", optString10);
                    jSONObject10.put("sticker_name", optString11);
                    jSONObject10.put("text", optString12);
                } catch (JSONException e15) {
                    e15.printStackTrace();
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_IM, "liveroom", "challenge_mvp_punish").setContentExt(null, null, jSONObject10));
            } else if (jSONObject2 != null && "challenge_winner_by_autofail".equals(str2)) {
                String string3 = TextUtils.isEmpty(str) ? this.mContext.getString(a.h.ala_challenge_winner_by_autofail) : str;
                SpannableString valueOf10 = SpannableString.valueOf(string3);
                valueOf10.setSpan(new ForegroundColorSpan(-19840), 0, string3.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf10, 0, string3.length());
                com.baidu.live.view.b bVar13 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_pk);
                SpannableStringBuilder spannableStringBuilder13 = new SpannableStringBuilder("  ");
                spannableStringBuilder13.setSpan(bVar13, 0, 1, 33);
                spannableStringBuilder.insert(0, (CharSequence) spannableStringBuilder13);
                JSONObject jSONObject11 = new JSONObject();
                try {
                    jSONObject11.put("text", str);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_IM, "liveroom", "challenge_winner_by_autofail").setContentExt(null, null, jSONObject11));
            } else if ("wish_list_success".equals(str2) || "wish_list_finish".equals(str2)) {
                com.baidu.live.view.b bVar14 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_xinyuan);
                SpannableStringBuilder spannableStringBuilder14 = new SpannableStringBuilder("  ");
                spannableStringBuilder14.setSpan(bVar14, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder14);
                SpannableString valueOf11 = SpannableString.valueOf(str);
                valueOf11.setSpan(new ForegroundColorSpan(-6574339), 0, valueOf11.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf11);
                if (!this.boZ) {
                    com.baidu.live.view.b bVar15 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_zhuli);
                    SpannableStringBuilder spannableStringBuilder15 = new SpannableStringBuilder("  ");
                    spannableStringBuilder15.setSpan(bVar15, 1, 2, 33);
                    spannableStringBuilder.insert(spannableStringBuilder.length(), (CharSequence) spannableStringBuilder15);
                }
                spannableStringBuilder.setSpan(new a(this.mContext, bVar.getLink(), str2), 0, spannableStringBuilder.length(), 33);
            } else if ("start_grab_wheel".equals(str2)) {
                com.baidu.live.view.b bVar16 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_zhuanpan);
                SpannableStringBuilder spannableStringBuilder16 = new SpannableStringBuilder("  ");
                spannableStringBuilder16.setSpan(bVar16, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder16);
                spannableStringBuilder.append(com.baidu.live.utils.g.I(this.mContext.getString(a.h.ala_lucky_tab_tips2), -6574339));
                a(spannableStringBuilder, bVar.Nw(), aVar, false, false);
                cj(false);
                String str12 = "";
                String str13 = "";
                String str14 = "";
                if (jSONObject3 != null) {
                    str12 = jSONObject3.optString(LogConfig.LOG_AMOUNT);
                    str13 = jSONObject3.optString("keywords");
                    str14 = jSONObject3.optString("gift_url");
                }
                spannableStringBuilder.append(com.baidu.live.utils.g.I(String.format(this.mContext.getString(a.h.ala_lucky_tab_tips), str12, str13), -6574339));
                AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                alaLiveMarkData.mark_pic = str14;
                com.baidu.live.view.b bVar17 = new com.baidu.live.view.b(this.mContext, alaLiveMarkData, false, null);
                SpannableStringBuilder spannableStringBuilder17 = new SpannableStringBuilder("  ");
                spannableStringBuilder17.setSpan(bVar17, 1, 2, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder17);
            } else if (TextUtils.equals("guard_club_join", str2)) {
                com.baidu.live.view.b bVar18 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_zhenai);
                SpannableStringBuilder spannableStringBuilder18 = new SpannableStringBuilder("  ");
                spannableStringBuilder18.setSpan(bVar18, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder18);
                spannableStringBuilder.append(com.baidu.live.utils.g.I(this.mContext.getString(a.h.ala_guard_club_join_welcome), -6574339));
                a(spannableStringBuilder, bVar.Nw(), aVar, false, false);
                cj(false);
                spannableStringBuilder.append(com.baidu.live.utils.g.I(this.mContext.getString(a.h.ala_guard_club_join), -6574339));
                if (!this.boZ) {
                    com.baidu.live.view.b bVar19 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_jiaru);
                    SpannableStringBuilder spannableStringBuilder19 = new SpannableStringBuilder("  ");
                    spannableStringBuilder19.setSpan(bVar19, 1, 2, 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder19);
                }
                spannableStringBuilder.setSpan(new a(this.mContext, bVar.getLink(), str2), 0, spannableStringBuilder.length(), 33);
            } else if (jSONObject2 != null && TextUtils.equals(str2, "privilege_award_royal_success")) {
                final String optString13 = jSONObject2.optString("icon_url");
                this.bpA = optString13;
                if (!TextUtils.isEmpty(optString13)) {
                    new AlaLiveMarkData().mark_pic = optString13;
                    BdResourceLoader.getInstance().loadResource(optString13, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.yuyinim.a.d.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                        public void onLoaded(BdImage bdImage, String str15, int i4) {
                            super.onLoaded((AnonymousClass1) bdImage, str15, i4);
                            Bitmap a2 = d.this.a(bdImage);
                            if (a2 != null && TextUtils.equals(d.this.bpA, optString13)) {
                                CenteredImageSpan centeredImageSpan = new CenteredImageSpan(d.this.mContext, a2);
                                SpannableString spannableString = new SpannableString("[img] ");
                                spannableString.setSpan(centeredImageSpan, 0, spannableString.length() - 1, 33);
                                spannableStringBuilder.insert(0, (CharSequence) spannableString);
                                aVar.blJ.setText(spannableStringBuilder);
                                aVar.blJ.forceLayout();
                            }
                        }
                    }, null);
                }
                a(spannableStringBuilder, bVar.Nw(), aVar, false, false);
                cj(false);
                int optInt2 = jSONObject2.optInt("royal_level");
                String str15 = "";
                if (optInt2 >= 0 && optInt2 <= 7) {
                    str15 = AlaLiveMarkData.NOBLE_LEVEL_NAMES[optInt2];
                }
                if (TextUtils.equals(bVar.Nw().userId, TbadkCoreApplication.getCurrentAccount())) {
                    format = String.format(this.mContext.getString(a.h.txt_im_noble_update_mine), str15);
                } else {
                    format = String.format(this.mContext.getString(a.h.txt_im_noble_update), str15);
                }
                spannableStringBuilder.append(com.baidu.live.utils.g.I(format, -19840));
            } else if (TextUtils.equals("haokan_buy_goods", str2)) {
                com.baidu.live.view.b bVar20 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_viewer_shopping);
                SpannableStringBuilder spannableStringBuilder20 = new SpannableStringBuilder("  ");
                spannableStringBuilder20.setSpan(bVar20, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder20);
                spannableStringBuilder.append(com.baidu.live.utils.g.I(str, -1));
            } else if (jSONObject2 != null && TextUtils.equals("follow_anchor_phone", str2)) {
                String optString14 = jSONObject2.optString("wheat_user_nickname");
                a(spannableStringBuilder, bVar.Nw(), aVar, false, false);
                spannableStringBuilder.append(com.baidu.live.utils.g.I("关注了 ", -6574339));
                spannableStringBuilder.append(com.baidu.live.utils.g.I(optString14, -5462));
            } else if (TextUtils.equals("follow_room", str2)) {
                a(spannableStringBuilder, bVar.Nw(), aVar, false, false);
                spannableStringBuilder.append(com.baidu.live.utils.g.I("收藏了本房间", -6574339));
            } else if (jSONObject2 != null && TextUtils.equals("live_audio_audit_notice", str2)) {
                spannableStringBuilder.append(com.baidu.live.utils.g.I(jSONObject2.optString("text"), -39322));
            } else if (jSONObject2 != null && TextUtils.equals("audio_hat_level_toast", str2)) {
                String[] split2 = String.format(jSONObject2.optJSONObject("data").optString("msg"), jSONObject2.optJSONObject("data").optString("content")).split(" ")[1].split("，");
                a(spannableStringBuilder, bVar.Nw(), aVar, false, false, true);
                spannableStringBuilder.append(com.baidu.live.utils.g.I(split[0] + " ", -1));
                spannableStringBuilder.append(com.baidu.live.utils.g.I(split2[0], -5462));
                spannableStringBuilder.append(com.baidu.live.utils.g.I("，" + split2[1], -1));
            } else if (jSONObject2 != null && TextUtils.equals("audio_hat_user_toast", str2)) {
                String[] split3 = String.format(jSONObject2.optJSONObject("data").optString("msg"), jSONObject2.optJSONObject("data").optString("content")).split(" ");
                a(spannableStringBuilder, bVar.Nw(), aVar, false, false, true);
                spannableStringBuilder.append(com.baidu.live.utils.g.I(split3[0] + " ", -1));
                spannableStringBuilder.append(com.baidu.live.utils.g.I(split3[1], -5462));
                spannableStringBuilder.append(com.baidu.live.utils.g.I(" " + split3[2], -1));
            } else if (jSONObject2 != null && TextUtils.equals("audio_loot_gift", str2)) {
                String[] split4 = String.format(jSONObject2.optJSONObject("data").optString("msg"), jSONObject2.optString("user_nickname")).split(" ");
                spannableStringBuilder.append(com.baidu.live.utils.g.I(split4[0] + " ", -19840));
                spannableStringBuilder.append(com.baidu.live.utils.g.I(split4[1] + " ", -5462));
                spannableStringBuilder.append(com.baidu.live.utils.g.I(split4[2], -19840));
                com.baidu.live.view.b bVar21 = new com.baidu.live.view.b(this.mContext, a.e.yuyin_im_box);
                SpannableStringBuilder spannableStringBuilder21 = new SpannableStringBuilder("  ");
                spannableStringBuilder21.setSpan(bVar21, 0, 1, 33);
                spannableStringBuilder.insert(0, (CharSequence) spannableStringBuilder21);
            }
        }
        return spannableStringBuilder;
    }

    /* loaded from: classes11.dex */
    private static class a extends ClickableSpan {
        private String aSC;
        private String aVt;
        private boolean bpK;
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
            this.aVt = str4;
            this.aSC = str5;
            this.customRoomId = str6;
            this.isHost = z;
        }

        public void setClickable(boolean z) {
            this.bpK = z;
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
                        c = 2;
                        break;
                    }
                    break;
                case -244328516:
                    if (str.equals("wish_list_finish")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1595898:
                    if (str.equals("wish_list_success")) {
                        c = 3;
                        break;
                    }
                    break;
                case 39010809:
                    if (str.equals("guard_club_join")) {
                        c = 5;
                        break;
                    }
                    break;
                case 973563845:
                    if (str.equals("custom_im_notice_live_assistant")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1290650531:
                    if (str.equals("start_grab_redpacket")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1390912044:
                    if (str.equals("audio_low_version_toast")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    dc dcVar = new dc();
                    dcVar.aSC = this.aSC;
                    dcVar.liveId = this.liveId;
                    dcVar.aVt = this.aVt;
                    dcVar.roomId = this.customRoomId;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, dcVar));
                    return;
                case 1:
                    com.baidu.live.yuyinim.b.a.bx(this.context);
                    return;
                case 2:
                    if (this.bpK) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913153));
                        return;
                    }
                    return;
                case 3:
                case 4:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913154, null));
                    return;
                case 5:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106, "im"));
                    return;
                case 6:
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

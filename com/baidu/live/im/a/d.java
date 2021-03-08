package com.baidu.live.im.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Base64;
import android.view.View;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.adp.base.IScrollableHelper;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.resourceloader.BdResourceCallback;
import com.baidu.live.adp.lib.resourceloader.BdResourceLoader;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdBitmapHelper;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.widget.CenteredImageSpan;
import com.baidu.live.adp.widget.imageview.BdImage;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.ao;
import com.baidu.live.data.bm;
import com.baidu.live.data.ci;
import com.baidu.live.gift.ac;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.util.WebviewHelper;
import com.baidu.live.utils.q;
import com.baidu.live.view.b;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tieba.ala.ALaKeepAliveService;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d extends com.baidu.live.im.a.b {
    private String bpG;
    private String bpH;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(Context context) {
        super(context, com.baidu.live.im.a.blw);
    }

    @Override // com.baidu.live.im.a.b
    protected void KC() {
        if (KD()) {
            KE();
        } else {
            KF();
        }
    }

    @Override // com.baidu.live.im.a.b
    protected int getColor() {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x06c3  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0120  */
    @Override // com.baidu.live.im.a.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected SpannableStringBuilder b(com.baidu.live.im.data.b bVar, final com.baidu.live.im.c cVar) {
        Exception e2;
        JSONObject jSONObject;
        JSONException e3;
        JSONObject jSONObject2;
        String str;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        String str2;
        String str3;
        boolean z;
        String str4;
        boolean z2;
        int i;
        boolean z3;
        int i2;
        String string;
        int i3;
        JSONObject jSONObject5;
        String format;
        com.baidu.live.entereffect.a.c i4;
        JSONObject jSONObject6;
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        this.bpG = null;
        this.bpH = null;
        String str5 = null;
        String str6 = "";
        String str7 = "";
        String str8 = "";
        JSONObject jSONObject7 = null;
        if (bVar != null) {
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject6 = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject6 = new JSONObject(bVar.getContent());
                }
                try {
                    str5 = jSONObject6.optString("content_type");
                    if (str5.equals("start_grab_wheel")) {
                        str8 = jSONObject6.optString("ext_data");
                    } else {
                        String optString = jSONObject6.optString("ext");
                        if (!TextUtils.isEmpty(optString)) {
                            str8 = new String(Base64.decode(optString.getBytes(), 0));
                        }
                        if (TbConfig.isForceNoticeIm) {
                            str8 = optString;
                        }
                    }
                    if (!TextUtils.isEmpty(str8)) {
                        jSONObject7 = new JSONObject(str8);
                    }
                    str6 = jSONObject6.optString("text");
                    str7 = jSONObject6.optString("level_id");
                    str = jSONObject6.optString("anchorName");
                    jSONObject3 = jSONObject6;
                    jSONObject4 = jSONObject7;
                    str2 = str6;
                    str3 = str5;
                } catch (JSONException e4) {
                    e3 = e4;
                    jSONObject2 = jSONObject6;
                    e3.printStackTrace();
                    str = null;
                    jSONObject3 = jSONObject2;
                    jSONObject4 = jSONObject7;
                    str2 = str6;
                    str3 = str5;
                    if (!TextUtils.isEmpty(str7)) {
                        bVar.Lc().level_id = JavaTypesHelper.toInt(str7, 0);
                    }
                    z = false;
                    String str9 = null;
                    if (str3 == null) {
                    }
                    if (!z) {
                    }
                    return spannableStringBuilder;
                } catch (Exception e5) {
                    e2 = e5;
                    jSONObject = jSONObject6;
                    e2.printStackTrace();
                    str = null;
                    jSONObject3 = jSONObject;
                    jSONObject4 = jSONObject7;
                    str2 = str6;
                    str3 = str5;
                    if (!TextUtils.isEmpty(str7)) {
                    }
                    z = false;
                    String str92 = null;
                    if (str3 == null) {
                    }
                    if (!z) {
                    }
                    return spannableStringBuilder;
                }
            } catch (JSONException e6) {
                e3 = e6;
                jSONObject2 = null;
            } catch (Exception e7) {
                e2 = e7;
                jSONObject = null;
            }
            if (!TextUtils.isEmpty(str7) && JavaTypesHelper.toInt(str7, 0) > 0) {
                bVar.Lc().level_id = JavaTypesHelper.toInt(str7, 0);
            }
            z = false;
            String str922 = null;
            if (str3 == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str4 = str2;
                    z2 = false;
                    i = -30312;
                } else {
                    str4 = bVar.getContent();
                    z2 = false;
                    i = -30312;
                }
            } else if (str3.equals("custom_live_notice")) {
                str4 = str2;
                z2 = false;
                i = -7479041;
            } else if (str3.equals("custom_im_notice")) {
                z = true;
                str4 = null;
                z2 = false;
                i = -30312;
            } else if (str3.equals("custom_im_notice_live_assistant")) {
                z = true;
                str4 = null;
                z2 = false;
                i = -30312;
            } else if (str3.equals("custom_network_change")) {
                str4 = str2;
                z2 = false;
                i = -30312;
            } else if (str3.equals("enter_live")) {
                z = true;
                String string2 = this.mContext.getString(a.h.ala_enter_live);
                a(spannableStringBuilder, bVar.Lc(), cVar, false, false, false);
                str4 = string2;
                z2 = false;
                i = -1711276033;
            } else if (str3.equals("backstage_live")) {
                str4 = str2;
                z2 = false;
                i = -7479041;
            } else if (str3.equals("content_text_only")) {
                if (jSONObject3.has("content_text_color") && !jSONObject3.optString("content_text_color").isEmpty()) {
                    i2 = Color.parseColor(jSONObject3.optString("content_text_color").trim());
                } else {
                    i2 = -7479041;
                }
                str4 = jSONObject3.optString(ALaKeepAliveService.KEY_CONTENT_TEXT);
                z2 = false;
                i = i2;
            } else if (str3.equals("offline_type")) {
                str4 = str2;
                z2 = false;
                i = -30312;
            } else if (str3.equals("close_live")) {
                str4 = this.mContext.getString(a.h.ala_close_live);
                z2 = false;
                i = -30312;
            } else if (str3.equals("follow_anchor")) {
                str4 = this.mContext.getString(a.h.ala_follow_live);
                a(spannableStringBuilder, bVar.Lc(), cVar, false, false);
                z2 = false;
                i = -7479041;
            } else if (str3.equals(com.baidu.tbadk.TbConfig.TMP_SHARE_DIR_NAME)) {
                str4 = this.mContext.getString(a.h.ala_share_live);
                a(spannableStringBuilder, bVar.Lc(), cVar, false, false);
                if ((bVar instanceof com.baidu.live.im.a) && ((com.baidu.live.im.a) bVar).Js().equals(bVar.Lc().userId)) {
                    com.baidu.live.view.b bVar2 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_anchor);
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("  ");
                    spannableStringBuilder2.setSpan(bVar2, 0, 1, 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                }
                z2 = false;
                i = -7479041;
            } else if (str3.equals("share_tieba")) {
                if ((bVar instanceof com.baidu.live.im.a) && ((com.baidu.live.im.a) bVar).Js().equals(bVar.Lc().userId)) {
                    com.baidu.live.view.b bVar3 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_anchor);
                    SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("  ");
                    spannableStringBuilder3.setSpan(bVar3, 0, 1, 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                }
                str4 = str2;
                z2 = false;
                i = -7479041;
            } else if (str3.equals("remove_video")) {
                if (jSONObject3.optString("poke_msg").isEmpty()) {
                    str922 = str2;
                    z3 = false;
                } else {
                    z3 = true;
                }
                str4 = str922;
                z = z3;
                z2 = false;
                i = -30312;
            } else if (str3.equals("ueg_warn")) {
                str4 = str2;
                z2 = false;
                i = -30312;
            } else if (str3.equals("live_admin")) {
                a(spannableStringBuilder, bVar.Lc(), cVar, false, false);
                str4 = str2;
                z2 = false;
                i = -7479041;
            } else if (str3.equals("live_talk_ban") || str3.equals("live_talk_remove_ban") || str3.equals("live_talk_admin_ban") || str3.equals("live_talk_admin_remove_ban")) {
                a(spannableStringBuilder, bVar.Lc(), cVar, false, false);
                str4 = str2;
                z2 = false;
                i = -30312;
            } else if (str3.equals("challenge_direct_start")) {
                str4 = str2;
                z2 = true;
                i = -5864;
            } else if (str3.equals("challenge_direct_matched")) {
                str4 = str2;
                z2 = true;
                i = -5864;
            } else if (str3.equals("challenge_random_start")) {
                str4 = str2;
                z2 = true;
                i = -5864;
            } else if (str3.equals("challenge_random_matched")) {
                str4 = str2;
                z2 = true;
                i = -5864;
            } else if (str3.equals("avts")) {
                str4 = str2;
                z2 = false;
                i = -30312;
            } else if (str3.equals("allin")) {
                str4 = str2;
                z2 = false;
                i = -30312;
            } else if (str3.equals("share_rmb")) {
                str4 = this.mContext.getString(a.h.ala_share_rmb);
                a(spannableStringBuilder, bVar.Lc(), cVar, false, false);
                z2 = false;
                i = -7479041;
            } else if (str3.equals("zan_rmb")) {
                if ((bVar instanceof com.baidu.live.im.a) && ((com.baidu.live.im.a) bVar).Js().equals(bVar.Lc().userId)) {
                    com.baidu.live.view.b bVar4 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_anchor);
                    SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder("  ");
                    spannableStringBuilder4.setSpan(bVar4, 0, 1, 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder4);
                }
                str4 = this.mContext.getString(a.h.ala_zan_rmb);
                a(spannableStringBuilder, bVar.Lc(), cVar, false, false);
                z2 = false;
                i = -1711276033;
            } else if (str3.equals("start_grab_wheel")) {
                z = true;
                str4 = null;
                z2 = false;
                i = -30312;
            } else if (str3.equals("guard_club_join")) {
                z = true;
                str4 = null;
                z2 = false;
                i = -30312;
            } else if (str3.equals("haokan_buy_goods")) {
                z = true;
                str4 = null;
                z2 = false;
                i = -30312;
            } else if (str3.equals("send_redpacket")) {
                z = true;
                str4 = null;
                z2 = false;
                i = -30312;
            } else if (str3.equals("start_grab_redpacket")) {
                z = true;
                str4 = null;
                z2 = false;
                i = -30312;
            } else if (str3.equals("guard_seat")) {
                z = true;
                str4 = null;
                z2 = false;
                i = -30312;
            } else if (str3.equals("challenge_mvp")) {
                z = true;
                str4 = null;
                z2 = false;
                i = -30312;
            } else if (str3.equals("challenge_mvp_punish")) {
                z = true;
                str4 = null;
                z2 = false;
                i = -30312;
            } else if (str3.equals("challenge_winner_by_autofail")) {
                z = true;
                str4 = null;
                z2 = false;
                i = -30312;
            } else if (str3.equals("wish_list_success") || str3.equals("wish_list_finish")) {
                z = true;
                str4 = null;
                z2 = false;
                i = -30312;
            } else if (str3.equals("privilege_award_royal_success")) {
                z = true;
                str4 = null;
                z2 = false;
                i = -30312;
            } else if (str3.equals("activity_gift")) {
                z = true;
                str4 = null;
                z2 = false;
                i = -30312;
            } else if (str3.equals("activity_notice")) {
                z = true;
                str4 = null;
                z2 = false;
                i = -30312;
            } else if (str3.equals("activity_common_im")) {
                z = true;
                str4 = null;
                z2 = false;
                i = -30312;
            } else if (str3.equals("pk_first_blood")) {
                z = true;
                str4 = null;
                z2 = false;
                i = -30312;
            } else if (str3.equals("pk_send_props")) {
                z = true;
                str4 = null;
                z2 = false;
                i = -30312;
            } else if (str3.equals("pk_mvp_props")) {
                z = true;
                str4 = null;
                z2 = false;
                i = -30312;
            } else if (str3.equals(UbcStatConstant.ContentType.UBC_TYPE_TYING_GIFT)) {
                z = true;
                str4 = null;
                z2 = false;
                i = -30312;
            } else if (str3.equals("live_notice_quick_chat")) {
                z = true;
                str4 = null;
                z2 = false;
                i = -30312;
            } else if (str3.equals("live_poke_back")) {
                z = true;
                str4 = null;
                z2 = false;
                i = -30312;
            } else if (str3.equals("luckybag_win_prize")) {
                z = true;
                str4 = null;
                z2 = false;
                i = -30312;
            } else if (str3.equals("mysterious_man_tip")) {
                z = true;
                str4 = null;
                z2 = false;
                i = -30312;
            } else if (str3.equals("mysterious_man_expired_remind")) {
                z = true;
                str4 = null;
                z2 = false;
                i = -30312;
            } else if (str3.equals("mysterious_man_open_live")) {
                z = true;
                str4 = null;
                z2 = false;
                i = -30312;
            } else if (str3.equals("custom_gift")) {
                z = true;
                str4 = null;
                z2 = false;
                i = -30312;
            } else if (str3.equals("custom_anchor_identity_update") || str3.equals("custom_master_identity")) {
                str4 = str2;
                z2 = false;
                i = -5864;
            } else if (str3.equals("add_tags_to_anchor")) {
                String str10 = null;
                if (bVar != null && (bVar instanceof com.baidu.live.im.a) && bVar.Lc() != null && TextUtils.equals(bVar.Lc().userId, TbadkCoreApplication.getCurrentAccount())) {
                    str10 = this.mContext.getString(a.h.add_tag_text_yourself);
                }
                a(spannableStringBuilder, bVar.Lc(), cVar, false, false, true, str10);
                str4 = str2;
                z2 = false;
                i = -1;
            } else if (str3.equals("group_guess")) {
                z = true;
                str4 = bVar.getContent();
                z2 = false;
                i = -30312;
            } else if (!TextUtils.isEmpty(str2)) {
                str4 = str2;
                z2 = false;
                i = -30312;
            } else {
                str4 = bVar.getContent();
                z2 = false;
                i = -30312;
            }
            if (!z) {
                if (TextUtils.isEmpty(bVar.getLink())) {
                    spannableStringBuilder.append(com.baidu.live.utils.g.J(str4, i));
                    if (z2) {
                        com.baidu.live.view.b bVar5 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_pk);
                        SpannableStringBuilder spannableStringBuilder5 = new SpannableStringBuilder("  ");
                        spannableStringBuilder5.setSpan(bVar5, 0, 1, 33);
                        spannableStringBuilder.insert(0, (CharSequence) spannableStringBuilder5);
                    }
                } else {
                    SpannableString valueOf = SpannableString.valueOf(str4);
                    valueOf.setSpan(new a(this.mContext, bVar.getLink(), str3), 0, str4 != null ? str4.length() : 0, 33);
                    spannableStringBuilder.append((CharSequence) valueOf);
                }
            } else if (TextUtils.equals(str3, "custom_im_notice")) {
                SpannableString valueOf2 = SpannableString.valueOf(str2);
                valueOf2.setSpan(new ForegroundColorSpan(-1711276033), 0, str2.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf2);
                com.baidu.live.view.b bVar6 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_arrow);
                SpannableStringBuilder spannableStringBuilder6 = new SpannableStringBuilder("  ");
                spannableStringBuilder6.setSpan(bVar6, 1, 2, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder6);
                spannableStringBuilder.setSpan(new a(this.mContext, bVar.getLink(), str3), 0, spannableStringBuilder.length(), 33);
            } else if (TextUtils.equals(str3, "custom_im_notice_live_assistant")) {
                SpannableString valueOf3 = SpannableString.valueOf(str2);
                valueOf3.setSpan(new ForegroundColorSpan(-7479041), 0, str2.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf3);
                com.baidu.live.view.b bVar7 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_arrow);
                SpannableStringBuilder spannableStringBuilder7 = new SpannableStringBuilder("  ");
                spannableStringBuilder7.setSpan(bVar7, 1, 2, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder7);
                spannableStringBuilder.setSpan(new a(this.mContext, bVar.getLink(), str3), 0, spannableStringBuilder.length(), 33);
            } else if (TextUtils.equals(str3, "custom_im_notice_live_assistant")) {
                SpannableString valueOf4 = SpannableString.valueOf(str2);
                valueOf4.setSpan(new ForegroundColorSpan(-7479041), 0, str2.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf4);
                com.baidu.live.view.b bVar8 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_arrow);
                SpannableStringBuilder spannableStringBuilder8 = new SpannableStringBuilder("  ");
                spannableStringBuilder8.setSpan(bVar8, 1, 2, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder8);
                spannableStringBuilder.setSpan(new a(this.mContext, bVar.getLink(), str3), 0, spannableStringBuilder.length(), 33);
            } else if ("enter_live".equals(str3)) {
                spannableStringBuilder.append(com.baidu.live.utils.g.J(str4, i));
                if (bVar.Lc() != null && TextUtils.equals(bVar.Lc().userId, TbadkCoreApplication.getCurrentAccount()) && (i4 = com.baidu.live.entereffect.a.CY().i(bVar)) != null && i4.aVZ && com.baidu.live.entereffect.a.CY().fJ(i4.id) == null) {
                    SpannableString valueOf5 = SpannableString.valueOf("（入场动效下载中）");
                    valueOf5.setSpan(new ForegroundColorSpan(i), 0, "（入场动效下载中）".length(), 33);
                    spannableStringBuilder.append((CharSequence) valueOf5);
                }
            } else if ("send_redpacket".equals(str3) || "start_grab_redpacket".equals(str3)) {
                com.baidu.live.view.b bVar9 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_redpacket);
                SpannableStringBuilder spannableStringBuilder9 = new SpannableStringBuilder("  ");
                spannableStringBuilder9.setSpan(bVar9, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder9);
                a(spannableStringBuilder, bVar.Lc(), cVar, false, false);
                cn(false);
                if ("send_redpacket".equals(str3)) {
                    String str11 = "";
                    if (jSONObject4 != null) {
                        str11 = jSONObject4.optString(LogConfig.LOG_AMOUNT);
                    }
                    string = String.format(this.mContext.getString(a.h.ala_send_redpacket), str11);
                } else {
                    string = "start_grab_redpacket".equals(str3) ? this.mContext.getString(a.h.ala_start_grab_redpacket) : str4;
                }
                SpannableString valueOf6 = SpannableString.valueOf(string);
                valueOf6.setSpan(new ForegroundColorSpan(-5864), 0, valueOf6.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf6);
                if ("start_grab_redpacket".equals(str3)) {
                    com.baidu.live.view.b bVar10 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_kaiqiang);
                    SpannableStringBuilder spannableStringBuilder10 = new SpannableStringBuilder("  ");
                    spannableStringBuilder10.setSpan(bVar10, 1, 2, 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder10);
                }
                if (jSONObject4 != null) {
                    spannableStringBuilder.setSpan(new a(this.mContext, bVar.getLink(), str3, jSONObject4.optString("live_id"), jSONObject4.optString("anchor_id"), jSONObject4.optString("red_packet_id"), KB()), 0, spannableStringBuilder.length(), 33);
                }
            } else if (jSONObject3 != null && "guard_seat".equals(str3)) {
                com.baidu.live.view.b bVar11 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_shouhu);
                SpannableStringBuilder spannableStringBuilder11 = new SpannableStringBuilder("  ");
                spannableStringBuilder11.setSpan(bVar11, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder11);
                String optString2 = jSONObject3.optString("prefix");
                String optString3 = jSONObject3.optString("nickname");
                String optString4 = jSONObject3.optString("suffix");
                StringBuilder sb = new StringBuilder(optString2);
                if (!TextUtils.isEmpty(optString3)) {
                    sb.append(" ");
                    sb.append(optString3);
                    sb.append(" ");
                }
                sb.append(optString4);
                String sb2 = sb.toString();
                SpannableString valueOf7 = SpannableString.valueOf(sb2);
                valueOf7.setSpan(new ForegroundColorSpan(-5864), 0, sb2.length(), 33);
                if (!TextUtils.isEmpty(optString3)) {
                    valueOf7.setSpan(new ForegroundColorSpan(-7801), optString2.length() + 1, optString2.length() + 1 + optString3.length(), 33);
                }
                spannableStringBuilder.append((CharSequence) valueOf7, 0, sb2.length());
                boolean z4 = jSONObject3.optInt("is_jump") == 1;
                if (z4) {
                    com.baidu.live.view.b bVar12 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_arrow);
                    SpannableStringBuilder spannableStringBuilder12 = new SpannableStringBuilder("  ");
                    spannableStringBuilder12.setSpan(bVar12, 1, 2, 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder12);
                }
                a aVar = new a(this.mContext, bVar.getLink(), str3);
                aVar.setClickable(z4);
                spannableStringBuilder.setSpan(aVar, 0, spannableStringBuilder.length(), 33);
            } else if (jSONObject3 != null && "challenge_mvp".equals(str3)) {
                String optString5 = jSONObject3.optString("prefix");
                String optString6 = jSONObject3.optString("nickname");
                String optString7 = jSONObject3.optString("suffix");
                StringBuilder sb3 = new StringBuilder(optString5);
                ForegroundColorSpan foregroundColorSpan = null;
                int i5 = 0;
                int i6 = 0;
                if (!TextUtils.isEmpty(optString6)) {
                    sb3.append(" ");
                    i5 = sb3.length();
                    sb3.append(optString6);
                    i6 = optString6.length() + i5;
                    sb3.append(" ");
                    foregroundColorSpan = new ForegroundColorSpan(-7801);
                }
                sb3.append(optString7);
                String sb4 = sb3.toString();
                SpannableString valueOf8 = SpannableString.valueOf(sb4);
                valueOf8.setSpan(new ForegroundColorSpan(-5864), 0, sb4.length(), 33);
                if (foregroundColorSpan != null) {
                    valueOf8.setSpan(foregroundColorSpan, i5, i6, 33);
                }
                spannableStringBuilder.append((CharSequence) valueOf8, 0, sb4.length());
                com.baidu.live.view.b bVar13 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_pk);
                SpannableStringBuilder spannableStringBuilder13 = new SpannableStringBuilder("  ");
                spannableStringBuilder13.setSpan(bVar13, 0, 1, 33);
                spannableStringBuilder.insert(0, (CharSequence) spannableStringBuilder13);
            } else if (jSONObject3 != null && "challenge_mvp_punish".equals(str3)) {
                int optInt = jSONObject3.optInt("punish_type");
                String optString8 = jSONObject3.optString("mvp_nickname");
                String optString9 = jSONObject3.optString("sticker_name");
                String optString10 = jSONObject3.optString("text");
                if (optInt == 1) {
                    optString10 = String.format(this.mContext.getString(a.h.txt_im_mvp_punish_choose), optString8, optString9);
                } else if (optInt == 2) {
                    optString10 = String.format(this.mContext.getString(a.h.txt_im_mvp_punish_letoff), optString8);
                } else if (optInt == 3) {
                    optString10 = String.format(this.mContext.getString(a.h.txt_im_mvp_punish_notchoose), optString8, optString9);
                } else if (optInt != 4) {
                    optString10 = str4;
                }
                if (optString10 == null) {
                    optString10 = "";
                }
                SpannableString valueOf9 = SpannableString.valueOf(optString10);
                valueOf9.setSpan(new ForegroundColorSpan(-5864), 0, optString10.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf9);
                com.baidu.live.view.b bVar14 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_pk);
                SpannableStringBuilder spannableStringBuilder14 = new SpannableStringBuilder("  ");
                spannableStringBuilder14.setSpan(bVar14, 0, 1, 33);
                spannableStringBuilder.insert(0, (CharSequence) spannableStringBuilder14);
            } else if (jSONObject3 != null && "challenge_winner_by_autofail".equals(str3)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = this.mContext.getString(a.h.ala_challenge_winner_by_autofail);
                }
                SpannableString valueOf10 = SpannableString.valueOf(str2);
                valueOf10.setSpan(new ForegroundColorSpan(-5864), 0, str2.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf10, 0, str2.length());
                com.baidu.live.view.b bVar15 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_pk);
                SpannableStringBuilder spannableStringBuilder15 = new SpannableStringBuilder("  ");
                spannableStringBuilder15.setSpan(bVar15, 0, 1, 33);
                spannableStringBuilder.insert(0, (CharSequence) spannableStringBuilder15);
            } else if ("wish_list_success".equals(str3) || "wish_list_finish".equals(str3)) {
                com.baidu.live.view.b bVar16 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_xinyuan);
                SpannableStringBuilder spannableStringBuilder16 = new SpannableStringBuilder("  ");
                spannableStringBuilder16.setSpan(bVar16, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder16);
                SpannableString valueOf11 = SpannableString.valueOf(str2);
                valueOf11.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf11.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf11);
                if (!this.bpf) {
                    com.baidu.live.view.b bVar17 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_zhuli);
                    SpannableStringBuilder spannableStringBuilder17 = new SpannableStringBuilder("  ");
                    spannableStringBuilder17.setSpan(bVar17, 1, 2, 33);
                    spannableStringBuilder.insert(spannableStringBuilder.length(), (CharSequence) spannableStringBuilder17);
                }
                spannableStringBuilder.setSpan(new a(this.mContext, bVar.getLink(), str3), 0, spannableStringBuilder.length(), 33);
            } else if ("start_grab_wheel".equals(str3)) {
                com.baidu.live.view.b bVar18 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_zhuanpan);
                SpannableStringBuilder spannableStringBuilder18 = new SpannableStringBuilder("  ");
                spannableStringBuilder18.setSpan(bVar18, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder18);
                spannableStringBuilder.append(com.baidu.live.utils.g.J(this.mContext.getString(a.h.ala_lucky_tab_tips2), -7479041));
                a(spannableStringBuilder, bVar.Lc(), cVar, false, false);
                cn(false);
                String str12 = "";
                String str13 = "";
                String str14 = "";
                if (jSONObject4 != null) {
                    str12 = jSONObject4.optString(LogConfig.LOG_AMOUNT);
                    str13 = jSONObject4.optString("keywords");
                    str14 = jSONObject4.optString("gift_url");
                }
                spannableStringBuilder.append(com.baidu.live.utils.g.J(String.format(this.mContext.getString(a.h.ala_lucky_tab_tips), str12, str13), -7479041));
                AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                alaLiveMarkData.mark_pic = str14;
                com.baidu.live.view.b bVar19 = new com.baidu.live.view.b(this.mContext, alaLiveMarkData, false, null);
                SpannableStringBuilder spannableStringBuilder19 = new SpannableStringBuilder("  ");
                spannableStringBuilder19.setSpan(bVar19, 1, 2, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder19);
            } else if (TextUtils.equals("guard_club_join", str3)) {
                com.baidu.live.view.b bVar20 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_zhenai);
                SpannableStringBuilder spannableStringBuilder20 = new SpannableStringBuilder("  ");
                spannableStringBuilder20.setSpan(bVar20, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder20);
                spannableStringBuilder.append(com.baidu.live.utils.g.J(this.mContext.getString(a.h.ala_guard_club_join_welcome), -7479041));
                a(spannableStringBuilder, bVar.Lc(), cVar, false, false);
                cn(false);
                spannableStringBuilder.append(com.baidu.live.utils.g.J(this.mContext.getString(a.h.ala_guard_club_join), -7479041));
                if (!this.bpf) {
                    com.baidu.live.view.b bVar21 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_jiaru);
                    SpannableStringBuilder spannableStringBuilder21 = new SpannableStringBuilder("  ");
                    spannableStringBuilder21.setSpan(bVar21, 1, 2, 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder21);
                }
                spannableStringBuilder.setSpan(new a(this.mContext, bVar.getLink(), str3), 0, spannableStringBuilder.length(), 33);
            } else if (jSONObject3 != null && TextUtils.equals(str3, "privilege_award_royal_success")) {
                final String optString11 = jSONObject3.optString("icon_url");
                this.bpG = optString11;
                if (!TextUtils.isEmpty(optString11)) {
                    new AlaLiveMarkData().mark_pic = optString11;
                    BdResourceLoader.getInstance().loadResource(optString11, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.im.a.d.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                        public void onLoaded(BdImage bdImage, String str15, int i7) {
                            super.onLoaded((AnonymousClass1) bdImage, str15, i7);
                            Bitmap a2 = d.this.a(bdImage);
                            if (a2 != null && TextUtils.equals(d.this.bpG, optString11)) {
                                CenteredImageSpan centeredImageSpan = new CenteredImageSpan(d.this.mContext, a2);
                                SpannableString spannableString = new SpannableString("[img] ");
                                spannableString.setSpan(centeredImageSpan, 0, spannableString.length() - 1, 33);
                                spannableStringBuilder.insert(0, (CharSequence) spannableString);
                                cVar.blL.setText(spannableStringBuilder);
                                cVar.blL.forceLayout();
                            }
                        }
                    }, null);
                }
                a(spannableStringBuilder, bVar.Lc(), cVar, false, false);
                cn(false);
                int optInt2 = jSONObject3.optInt("royal_level");
                String str15 = "";
                if (optInt2 >= 0 && optInt2 <= 7) {
                    str15 = AlaLiveMarkData.NOBLE_LEVEL_NAMES[optInt2];
                }
                if (TextUtils.equals(bVar.Lc().userId, TbadkCoreApplication.getCurrentAccount())) {
                    format = String.format(this.mContext.getString(a.h.txt_im_noble_update_mine), str15);
                } else {
                    format = String.format(this.mContext.getString(a.h.txt_im_noble_update), str15);
                }
                spannableStringBuilder.append(com.baidu.live.utils.g.J(format, -5864));
            } else if (TextUtils.equals("haokan_buy_goods", str3)) {
                com.baidu.live.view.b bVar22 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_viewer_shopping);
                SpannableStringBuilder spannableStringBuilder22 = new SpannableStringBuilder("  ");
                spannableStringBuilder22.setSpan(bVar22, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder22);
                spannableStringBuilder.append(com.baidu.live.utils.g.J(str2, -1));
            } else if (jSONObject3 != null && "activity_gift".equals(str3)) {
                JSONObject optJSONObject = jSONObject3.optJSONObject("content_data");
                a(spannableStringBuilder, bVar.Lc(), cVar, false, false);
                if (optJSONObject != null) {
                    String optString12 = optJSONObject.optString("giftName");
                    String str16 = optJSONObject.optInt("giftNumber") + " ";
                    String optString13 = optJSONObject.optString("giftPic");
                    String str17 = optJSONObject.optDouble("multipleTime") + "";
                    String optString14 = optJSONObject.optString("multipleName");
                    String optString15 = optJSONObject.optString("firstText");
                    String optString16 = optJSONObject.optString("secondText");
                    String optString17 = optJSONObject.optString("span_text_color");
                    String optString18 = optJSONObject.optString("span_color_start");
                    String optString19 = optJSONObject.optString("span_color_end");
                    SpannableString valueOf12 = SpannableString.valueOf(optString15 + optString12);
                    if (!TextUtils.isEmpty(optString15)) {
                        valueOf12.setSpan(new ForegroundColorSpan(-5864), 0, valueOf12.length(), 33);
                    }
                    spannableStringBuilder.append((CharSequence) valueOf12);
                    if (!TextUtils.isEmpty(optString13)) {
                        AlaLiveMarkData alaLiveMarkData2 = new AlaLiveMarkData();
                        alaLiveMarkData2.mark_pic = optString13;
                        alaLiveMarkData2.isWidthAutoFit = true;
                        com.baidu.live.view.b bVar23 = new com.baidu.live.view.b(this.mContext, alaLiveMarkData2, false, new b.a() { // from class: com.baidu.live.im.a.d.11
                            @Override // com.baidu.live.view.b.a
                            public void e(Bitmap bitmap) {
                                cVar.blL.forceLayout();
                            }

                            @Override // com.baidu.live.view.b.a
                            public void a(com.baidu.live.view.b bVar24, Bitmap bitmap) {
                            }
                        });
                        SpannableStringBuilder spannableStringBuilder23 = new SpannableStringBuilder(" [img]");
                        spannableStringBuilder23.setSpan(bVar23, 1, spannableStringBuilder23.length(), 33);
                        spannableStringBuilder.append((CharSequence) spannableStringBuilder23);
                    }
                    if (!TextUtils.isEmpty(str16)) {
                        SpannableString valueOf13 = SpannableString.valueOf("X" + str16);
                        valueOf13.setSpan(new ForegroundColorSpan(-5864), 0, valueOf13.length(), 33);
                        spannableStringBuilder.append((CharSequence) valueOf13);
                    }
                    if (!TextUtils.isEmpty(optString16)) {
                        SpannableString valueOf14 = SpannableString.valueOf(optString16);
                        valueOf14.setSpan(new ForegroundColorSpan(-5864), 0, valueOf14.length(), 33);
                        spannableStringBuilder.append((CharSequence) valueOf14);
                    }
                    if (!TextUtils.isEmpty(str17) && !TextUtils.isEmpty(optString14) && !TextUtils.isEmpty(optString19)) {
                        com.baidu.live.im.view.b bVar24 = new com.baidu.live.im.view.b(this.mContext, str17 + "倍" + optString14, false, true, true, optString18, optString19, optString17);
                        SpannableString spannableString = new SpannableString(" rate");
                        spannableString.setSpan(bVar24, 1, spannableString.length(), 33);
                        spannableStringBuilder.append((CharSequence) spannableString);
                    } else if (!TextUtils.isEmpty(str17) && !TextUtils.isEmpty(optString14)) {
                        com.baidu.live.im.view.b bVar25 = new com.baidu.live.im.view.b(this.mContext, str17 + "倍" + optString14, true, false, true);
                        SpannableString spannableString2 = new SpannableString(" rate");
                        spannableString2.setSpan(bVar25, 1, spannableString2.length(), 33);
                        spannableStringBuilder.append((CharSequence) spannableString2);
                    }
                }
            } else if (jSONObject3 != null && "activity_common_im".equals(str3)) {
                JSONObject optJSONObject2 = jSONObject3.optJSONObject("content_data");
                int optInt3 = optJSONObject2.optInt("is_jump");
                String optString20 = optJSONObject2.optString("left_icon");
                JSONArray optJSONArray = optJSONObject2.optJSONArray("text_array");
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("text_color_array");
                if (!TextUtils.isEmpty(optString20)) {
                    AlaLiveMarkData alaLiveMarkData3 = new AlaLiveMarkData();
                    alaLiveMarkData3.mark_pic = optString20;
                    alaLiveMarkData3.isWidthAutoFit = true;
                    com.baidu.live.view.b bVar26 = new com.baidu.live.view.b(this.mContext, alaLiveMarkData3, false, new b.a() { // from class: com.baidu.live.im.a.d.12
                        @Override // com.baidu.live.view.b.a
                        public void e(Bitmap bitmap) {
                            cVar.blL.forceLayout();
                        }

                        @Override // com.baidu.live.view.b.a
                        public void a(com.baidu.live.view.b bVar27, Bitmap bitmap) {
                        }
                    });
                    SpannableStringBuilder spannableStringBuilder24 = new SpannableStringBuilder(" [img]");
                    spannableStringBuilder24.setSpan(bVar26, 1, spannableStringBuilder24.length(), 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder24);
                }
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("jump_item");
                if (optJSONArray2 != null && optJSONArray != null) {
                    for (int i7 = 0; i7 < optJSONArray.length(); i7++) {
                        try {
                            String trim = optJSONArray2.getString(i7).trim();
                            String string3 = optJSONArray.getString(i7);
                            int parseColor = Color.parseColor(trim);
                            SpannableString valueOf15 = SpannableString.valueOf(string3);
                            valueOf15.setSpan(new ForegroundColorSpan(parseColor), 0, valueOf15.length(), 33);
                            spannableStringBuilder.append((CharSequence) valueOf15);
                        } catch (JSONException e8) {
                            e8.printStackTrace();
                        }
                    }
                    if (optJSONObject3 != null) {
                        String optString21 = optJSONObject3.optString("title");
                        String trim2 = optJSONObject3.optString("title_color").trim();
                        String optString22 = optJSONObject3.optString("url");
                        String trim3 = optJSONObject3.optString("bg").trim();
                        String optString23 = optJSONObject3.optString("screen");
                        if (optInt3 == 1 && !TextUtils.isEmpty(optString21) && !TextUtils.isEmpty(optString22)) {
                            com.baidu.live.im.view.b bVar27 = new com.baidu.live.im.view.b(this.mContext, optString21 + " >", false, true, trim3, trim3, trim2);
                            SpannableString spannableString3 = new SpannableString(" click");
                            spannableString3.setSpan(bVar27, 1, spannableString3.length(), 33);
                            spannableStringBuilder.append((CharSequence) spannableString3);
                            a aVar2 = new a(this.mContext, optString22, optString23, str3);
                            aVar2.setClickable(true);
                            spannableStringBuilder.setSpan(aVar2, 0, spannableStringBuilder.length(), 33);
                        }
                    }
                }
            } else if (jSONObject3 != null && "activity_notice".equals(str3)) {
                jSONObject3.optInt("open");
                try {
                    jSONObject5 = new JSONObject(str2);
                } catch (JSONException e9) {
                    e9.printStackTrace();
                    jSONObject5 = null;
                }
                if (jSONObject5 != null) {
                    JSONObject optJSONObject4 = jSONObject5.optJSONObject("extra");
                    JSONObject optJSONObject5 = optJSONObject4.optJSONObject(TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
                    String optString24 = optJSONObject4.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                    String optString25 = optJSONObject4.optString("text");
                    String optString26 = optJSONObject5.optString("name");
                    String optString27 = optJSONObject5.optString("url");
                    String optString28 = optJSONObject5.optString("screen");
                    SpannableString valueOf16 = SpannableString.valueOf(" " + optString25);
                    if (!TextUtils.isEmpty(optString24)) {
                        AlaLiveMarkData alaLiveMarkData4 = new AlaLiveMarkData();
                        alaLiveMarkData4.mark_pic = optString24;
                        alaLiveMarkData4.isWidthAutoFit = true;
                        com.baidu.live.view.b bVar28 = new com.baidu.live.view.b(this.mContext, alaLiveMarkData4, false, new b.a() { // from class: com.baidu.live.im.a.d.13
                            @Override // com.baidu.live.view.b.a
                            public void e(Bitmap bitmap) {
                                cVar.blL.forceLayout();
                            }

                            @Override // com.baidu.live.view.b.a
                            public void a(com.baidu.live.view.b bVar29, Bitmap bitmap) {
                            }
                        });
                        SpannableStringBuilder spannableStringBuilder25 = new SpannableStringBuilder("[img]");
                        spannableStringBuilder25.setSpan(bVar28, 0, spannableStringBuilder25.length(), 33);
                        spannableStringBuilder.append((CharSequence) spannableStringBuilder25);
                    }
                    valueOf16.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf16.length(), 33);
                    spannableStringBuilder.append((CharSequence) valueOf16);
                    if (!TextUtils.isEmpty(optString27)) {
                        com.baidu.live.im.view.b bVar29 = new com.baidu.live.im.view.b(this.mContext, optString26 + " >", false, true, "#FFF5F5F5", "#FFF5F5F5", "#FFA3A3A3");
                        SpannableString spannableString4 = new SpannableString("url");
                        spannableString4.setSpan(bVar29, 0, spannableString4.length(), 33);
                        spannableStringBuilder.append((CharSequence) spannableString4);
                        a aVar3 = new a(this.mContext, optString27, optString28, str3);
                        aVar3.setClickable(true);
                        spannableStringBuilder.setSpan(aVar3, 0, spannableStringBuilder.length(), 33);
                    }
                }
            } else if (jSONObject3 != null && "live_notice_quick_chat".equals(str3)) {
                SpannableString valueOf17 = SpannableString.valueOf(str2 + " ");
                valueOf17.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf17.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf17);
                com.baidu.live.view.b bVar30 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_quliaotian);
                SpannableStringBuilder spannableStringBuilder26 = new SpannableStringBuilder(" ");
                spannableStringBuilder26.setSpan(bVar30, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder26);
                if (!TextUtils.isEmpty(str)) {
                    a aVar4 = new a(this.mContext, true, str, str3);
                    aVar4.setClickable(true);
                    spannableStringBuilder.setSpan(aVar4, 0, spannableStringBuilder.length(), 33);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "gochat_show").setContentExt(null, null, null));
            } else if (jSONObject3 != null && "mysterious_man_tip".equals(str3)) {
                final String optString29 = jSONObject3.optString("start_icon");
                if (optString29 != null && !TextUtils.isEmpty(optString29)) {
                    this.bpG = optString29;
                    if (!TextUtils.isEmpty(optString29)) {
                        AlaLiveMarkData alaLiveMarkData5 = new AlaLiveMarkData();
                        alaLiveMarkData5.mark_pic = optString29;
                        alaLiveMarkData5.isWidthAutoFit = true;
                        alaLiveMarkData5.width = jSONObject3.optInt("start_icon_width");
                        alaLiveMarkData5.height = jSONObject3.optInt("start_icon_height");
                        BdResourceLoader.getInstance().loadResource(optString29, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.im.a.d.14
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                            public void onLoaded(BdImage bdImage, String str18, int i8) {
                                super.onLoaded((AnonymousClass14) bdImage, str18, i8);
                                Bitmap a2 = d.this.a(bdImage);
                                if (a2 != null && TextUtils.equals(d.this.bpG, optString29)) {
                                    CenteredImageSpan centeredImageSpan = new CenteredImageSpan(d.this.mContext, a2);
                                    SpannableString spannableString5 = new SpannableString("[img] ");
                                    spannableString5.setSpan(centeredImageSpan, 0, spannableString5.length() - 1, 33);
                                    spannableStringBuilder.insert(0, (CharSequence) spannableString5);
                                    cVar.blL.setText(spannableStringBuilder);
                                    cVar.blL.forceLayout();
                                }
                            }
                        }, null);
                    }
                }
                spannableStringBuilder.append(com.baidu.live.utils.g.J(jSONObject3.optString(AlaStaticKeys.ALA_STATIC_VALUE_TIP), Color.parseColor(jSONObject3.optString("tip_color"))));
                com.baidu.live.view.b bVar31 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_use_mysterious_card);
                SpannableStringBuilder spannableStringBuilder27 = new SpannableStringBuilder(" ");
                spannableStringBuilder27.setSpan(bVar31, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder27);
                String optString30 = jSONObject3.optString(BigdayActivityConfig.JUMP_URL);
                if (!TextUtils.isEmpty(optString30)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("live_id", this.mLiveId);
                    hashMap.put("scene_from", q.Fy());
                    hashMap.put("platform", "2");
                    hashMap.put("subapp_type", TbConfig.getSubappType());
                    hashMap.put(HttpRequest.SUBAPP_VERSION, Integer.valueOf(TbConfig.getSubappVersionCode()));
                    hashMap.put(HttpRequest.SDK_VERSION, TbConfig.SDK_VERSION);
                    hashMap.put("net_type", String.valueOf(BdNetTypeUtil.netType()));
                    hashMap.put("_client_type", "2");
                    optString30 = WebviewHelper.addQueryParams(optString30, hashMap);
                }
                a aVar5 = new a(this.mContext, true, optString30, "mysterious_man_tip");
                aVar5.setClickable(true);
                spannableStringBuilder.setSpan(aVar5, 0, spannableStringBuilder.length(), 33);
            } else if (jSONObject3 != null && "mysterious_man_expired_remind".equals(str3)) {
                String optString31 = jSONObject3.optString("tip_color");
                int i8 = -30312;
                if (!TextUtils.isEmpty(optString31)) {
                    i8 = Color.parseColor(optString31);
                }
                spannableStringBuilder.append(com.baidu.live.utils.g.J(str2, i8));
            } else if (jSONObject3 != null && "mysterious_man_open_live".equals(str3)) {
                String optString32 = jSONObject3.optString("tip_color");
                int i9 = -30312;
                if (!TextUtils.isEmpty(optString32)) {
                    i9 = Color.parseColor(optString32);
                }
                spannableStringBuilder.append(com.baidu.live.utils.g.J(str2, i9));
            } else if (jSONObject3 != null && "remove_video".equals(str3)) {
                if (bVar.Lc() != null) {
                    String optString33 = jSONObject3.optString("poke_user_nickname", "");
                    String optString34 = jSONObject3.optString("poke_text", "");
                    String optString35 = jSONObject3.optString("charm_user_id", "");
                    if (TbadkCoreApplication.getCurrentAccount().equals(jSONObject3.optString("poke_user_id", ""))) {
                        a(spannableStringBuilder, bVar.Lc(), cVar, false, false);
                        spannableStringBuilder.append(com.baidu.live.utils.g.J(optString34 + this.mContext.getString(a.h.sdk_string_you) + "  ", -9395));
                        com.baidu.live.view.b bVar32 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_huichuo);
                        SpannableStringBuilder spannableStringBuilder28 = new SpannableStringBuilder(" ");
                        spannableStringBuilder28.setSpan(bVar32, 0, 1, 33);
                        spannableStringBuilder.append((CharSequence) spannableStringBuilder28);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913267, jSONObject3.toString()));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913263, false));
                        a aVar6 = new a(this.mContext, true, jSONObject3.toString(), "live_poke_back");
                        aVar6.setClickable(true);
                        spannableStringBuilder.setSpan(aVar6, 0, spannableStringBuilder.length(), 33);
                    } else if (TbadkCoreApplication.getCurrentAccount().equals(optString35)) {
                        bVar.Lc().name_show = this.mContext.getString(a.h.sdk_string_you);
                        a(spannableStringBuilder, bVar.Lc(), cVar, false, false);
                        spannableStringBuilder.append(com.baidu.live.utils.g.J(optString34 + optString33, -9395));
                    } else {
                        a(spannableStringBuilder, bVar.Lc(), cVar, false, false);
                        spannableStringBuilder.append(com.baidu.live.utils.g.J(optString34 + optString33, -9395));
                    }
                }
            } else if (jSONObject3 != null && "live_poke_back".equals(str3)) {
                if (bVar.Lc() != null) {
                    String optString36 = jSONObject3.optString("poke_text", "");
                    boolean z5 = jSONObject3.optInt("is_gift", 1) == 1;
                    String optString37 = jSONObject3.optString("gift_name", "");
                    String optString38 = jSONObject3.optString("charm_user_id", "");
                    if (TbadkCoreApplication.getCurrentAccount().equals(jSONObject3.optString("poke_user_id", ""))) {
                        bVar.Lc().name_show = this.mContext.getString(a.h.sdk_string_you);
                        a(spannableStringBuilder, bVar.Lc(), cVar, false, false);
                        String str18 = optString36 + this.mContext.getString(a.h.sdk_string_host_user);
                        if (z5) {
                            str18 = str18 + this.mContext.getString(a.h.sdk_poke_send_gift) + optString37;
                        }
                        spannableStringBuilder.append(com.baidu.live.utils.g.J(str18, -9395));
                    } else if (TbadkCoreApplication.getCurrentAccount().equals(optString38)) {
                        a(spannableStringBuilder, bVar.Lc(), cVar, false, false);
                        String str19 = optString36 + this.mContext.getString(a.h.sdk_string_you);
                        if (z5) {
                            str19 = str19 + this.mContext.getString(a.h.sdk_poke_send_gift) + optString37;
                        }
                        spannableStringBuilder.append(com.baidu.live.utils.g.J(str19, -9395));
                    } else {
                        a(spannableStringBuilder, bVar.Lc(), cVar, false, false);
                        String str20 = optString36 + this.mContext.getString(a.h.sdk_string_host_user);
                        if (z5) {
                            str20 = str20 + this.mContext.getString(a.h.sdk_poke_send_gift) + optString37;
                        }
                        spannableStringBuilder.append(com.baidu.live.utils.g.J(str20, -9395));
                    }
                }
            } else if (jSONObject3 != null && "custom_gift".equals(str3)) {
                a(spannableStringBuilder, bVar.Lc(), cVar, false, false);
                f D = D(bVar);
                String str21 = "送出的" + ((D == null || TextUtils.isEmpty(D.giftName)) ? this.mContext.getString(a.h.sdk_gift) : D.giftName);
                SpannableString valueOf18 = SpannableString.valueOf(str21);
                if (str21 != null) {
                    valueOf18.setSpan(new ForegroundColorSpan(-5864), 0, valueOf18.length(), 33);
                }
                spannableStringBuilder.append((CharSequence) valueOf18);
                if (D != null && !TextUtils.isEmpty(D.aYq)) {
                    AlaLiveMarkData alaLiveMarkData6 = new AlaLiveMarkData();
                    alaLiveMarkData6.mark_pic = D.aYq;
                    alaLiveMarkData6.isWidthAutoFit = true;
                    com.baidu.live.view.b bVar33 = new com.baidu.live.view.b(this.mContext, alaLiveMarkData6, false, new b.a() { // from class: com.baidu.live.im.a.d.15
                        @Override // com.baidu.live.view.b.a
                        public void e(Bitmap bitmap) {
                            cVar.blL.forceLayout();
                        }

                        @Override // com.baidu.live.view.b.a
                        public void a(com.baidu.live.view.b bVar34, Bitmap bitmap) {
                        }
                    });
                    SpannableStringBuilder spannableStringBuilder29 = new SpannableStringBuilder(" [img]");
                    spannableStringBuilder29.setSpan(bVar33, 1, spannableStringBuilder29.length(), 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder29);
                }
                a(spannableStringBuilder, D);
            } else if (jSONObject3 != null && "pk_first_blood".equals(str3)) {
                JSONObject optJSONObject6 = jSONObject3.optJSONObject("first_blood_info");
                String str22 = bVar.Lc().name_show;
                if (optJSONObject6 != null) {
                    String optString39 = optJSONObject6.optString("front_text");
                    String optString40 = optJSONObject6.optString("behind_text");
                    final String optString41 = optJSONObject6.optString("icon_url");
                    this.bpG = optString41;
                    if (!TextUtils.isEmpty(optString41)) {
                        new AlaLiveMarkData().mark_pic = optString41;
                        BdResourceLoader.getInstance().loadResource(optString41, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.im.a.d.16
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                            public void onLoaded(BdImage bdImage, String str23, int i10) {
                                super.onLoaded((AnonymousClass16) bdImage, str23, i10);
                                Bitmap a2 = d.this.a(bdImage);
                                if (a2 != null && TextUtils.equals(d.this.bpG, optString41)) {
                                    CenteredImageSpan centeredImageSpan = new CenteredImageSpan(d.this.mContext, a2);
                                    SpannableString spannableString5 = new SpannableString("[img] ");
                                    spannableString5.setSpan(centeredImageSpan, 0, spannableString5.length() - 1, 33);
                                    spannableStringBuilder.insert(0, (CharSequence) spannableString5);
                                    cVar.blL.setText(spannableStringBuilder);
                                    cVar.blL.forceLayout();
                                }
                            }
                        }, null);
                    }
                    SpannableString valueOf19 = SpannableString.valueOf(optString39 + str22 + optString40);
                    ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(-7801);
                    ForegroundColorSpan foregroundColorSpan3 = new ForegroundColorSpan(-7479041);
                    valueOf19.setSpan(new ForegroundColorSpan(-7479041), 0, optString39.length(), 33);
                    valueOf19.setSpan(foregroundColorSpan2, optString39.length(), optString39.length() + str22.length(), 33);
                    valueOf19.setSpan(foregroundColorSpan3, str22.length() + optString39.length(), valueOf19.length(), 33);
                    spannableStringBuilder.append((CharSequence) valueOf19);
                }
            } else if (str3 != null && jSONObject3 != null && "pk_send_props".equals(str3)) {
                final String optString42 = jSONObject3.optString("pk_image_url");
                String optString43 = jSONObject3.optString("props_belong_text");
                String str23 = bVar.Lc().name_show;
                String optString44 = jSONObject3.optString("gift_name");
                final String optString45 = jSONObject3.optString("gift_url");
                String optString46 = jSONObject3.optString("props_text");
                this.bpG = optString42;
                this.bpH = optString45;
                if (!TextUtils.isEmpty(optString42)) {
                    new AlaLiveMarkData().mark_pic = optString42;
                    BdResourceLoader.getInstance().loadResource(optString42, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.im.a.d.17
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                        public void onLoaded(BdImage bdImage, String str24, int i10) {
                            super.onLoaded((AnonymousClass17) bdImage, str24, i10);
                            Bitmap a2 = d.this.a(bdImage);
                            if (a2 != null && TextUtils.equals(d.this.bpG, optString42)) {
                                CenteredImageSpan centeredImageSpan = new CenteredImageSpan(d.this.mContext, a2);
                                SpannableString spannableString5 = new SpannableString("[img] ");
                                spannableString5.setSpan(centeredImageSpan, 0, spannableString5.length() - 1, 33);
                                spannableStringBuilder.insert(0, (CharSequence) spannableString5);
                                cVar.blL.setText(spannableStringBuilder);
                                cVar.blL.forceLayout();
                            }
                        }
                    }, null);
                }
                SpannableString valueOf20 = SpannableString.valueOf(optString43 + str23);
                if (!TextUtils.isEmpty(valueOf20)) {
                    valueOf20.setSpan(new ForegroundColorSpan(-7479041), 0, optString43.length(), 33);
                    valueOf20.setSpan(new ForegroundColorSpan(-7801), optString43.length(), optString43.length() + str23.length(), 33);
                }
                spannableStringBuilder.append((CharSequence) valueOf20);
                String string4 = this.mContext.getString(a.h.ala_pk_props);
                SpannableString valueOf21 = SpannableString.valueOf(string4 + optString44);
                if (!TextUtils.isEmpty(string4)) {
                    valueOf21.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf21.length(), 33);
                }
                spannableStringBuilder.append((CharSequence) valueOf21);
                final SpannableString valueOf22 = SpannableString.valueOf("," + optString46);
                if (!TextUtils.isEmpty(valueOf22)) {
                    valueOf22.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf22.length(), 33);
                }
                spannableStringBuilder.append((CharSequence) valueOf22);
                if (!TextUtils.isEmpty(optString45)) {
                    new AlaLiveMarkData().mark_pic = optString45;
                    BdResourceLoader.getInstance().loadResource(optString45, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.im.a.d.18
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                        public void onLoaded(BdImage bdImage, String str24, int i10) {
                            super.onLoaded((AnonymousClass18) bdImage, str24, i10);
                            Bitmap a2 = d.this.a(bdImage);
                            if (a2 != null && TextUtils.equals(d.this.bpH, optString45)) {
                                CenteredImageSpan centeredImageSpan = new CenteredImageSpan(d.this.mContext, a2);
                                SpannableString spannableString5 = new SpannableString("[img] ");
                                spannableString5.setSpan(centeredImageSpan, 0, spannableString5.length() - 1, 33);
                                spannableStringBuilder.insert(spannableStringBuilder.length() - valueOf22.length(), (CharSequence) spannableString5);
                                cVar.blL.setText(spannableStringBuilder);
                                cVar.blL.forceLayout();
                            }
                        }
                    }, null);
                }
            } else if (jSONObject3 != null && "pk_mvp_props".equals(str3)) {
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(bVar.Lc().userId)) {
                    final String optString47 = jSONObject3.optString("pk_image_url");
                    String str24 = this.mContext.getString(a.h.ala_pk_front_props) + this.mContext.getString(a.h.ala_pk_middle_props) + this.mContext.getString(a.h.ala_pk_behind_props);
                    String optString48 = jSONObject3.optString("props_name");
                    final String optString49 = jSONObject3.optString("props_image_url");
                    String optString50 = jSONObject3.optString("props_text");
                    this.bpG = optString47;
                    this.bpH = optString49;
                    if (!TextUtils.isEmpty(optString47)) {
                        new AlaLiveMarkData().mark_pic = optString47;
                        BdResourceLoader.getInstance().loadResource(optString47, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.im.a.d.2
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                            public void onLoaded(BdImage bdImage, String str25, int i10) {
                                super.onLoaded((AnonymousClass2) bdImage, str25, i10);
                                Bitmap a2 = d.this.a(bdImage);
                                if (a2 != null && TextUtils.equals(d.this.bpG, optString47)) {
                                    CenteredImageSpan centeredImageSpan = new CenteredImageSpan(d.this.mContext, a2);
                                    SpannableString spannableString5 = new SpannableString("[img] ");
                                    spannableString5.setSpan(centeredImageSpan, 0, spannableString5.length() - 1, 33);
                                    spannableStringBuilder.insert(0, (CharSequence) spannableString5);
                                    cVar.blL.setText(spannableStringBuilder);
                                    cVar.blL.forceLayout();
                                }
                            }
                        }, null);
                    }
                    SpannableString valueOf23 = SpannableString.valueOf(str24 + optString48);
                    if (!TextUtils.isEmpty(valueOf23)) {
                        valueOf23.setSpan(new ForegroundColorSpan(-7479041), 0, str24.length() + optString48.length(), 33);
                    }
                    spannableStringBuilder.append((CharSequence) valueOf23);
                    final SpannableString valueOf24 = SpannableString.valueOf("," + optString50);
                    if (!TextUtils.isEmpty(valueOf24)) {
                        valueOf24.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf24.length(), 33);
                    }
                    spannableStringBuilder.append((CharSequence) valueOf24);
                    if (!TextUtils.isEmpty(optString49)) {
                        new AlaLiveMarkData().mark_pic = optString49;
                        BdResourceLoader.getInstance().loadResource(optString49, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.im.a.d.3
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                            public void onLoaded(BdImage bdImage, String str25, int i10) {
                                super.onLoaded((AnonymousClass3) bdImage, str25, i10);
                                Bitmap a2 = d.this.a(bdImage);
                                if (a2 != null && TextUtils.equals(d.this.bpH, optString49)) {
                                    CenteredImageSpan centeredImageSpan = new CenteredImageSpan(d.this.mContext, a2);
                                    SpannableString spannableString5 = new SpannableString("[img] ");
                                    spannableString5.setSpan(centeredImageSpan, 0, spannableString5.length() - 1, 33);
                                    spannableStringBuilder.insert(spannableStringBuilder.length() - valueOf24.length(), (CharSequence) spannableString5);
                                    cVar.blL.setText(spannableStringBuilder);
                                    cVar.blL.forceLayout();
                                }
                            }
                        }, null);
                    }
                } else {
                    final String optString51 = jSONObject3.optString("pk_image_url");
                    String string5 = this.mContext.getString(a.h.ala_pk_front_props);
                    String optString52 = jSONObject3.optString("user_nickname");
                    String string6 = this.mContext.getString(a.h.ala_pk_behind_props);
                    String optString53 = jSONObject3.optString("props_name");
                    final String optString54 = jSONObject3.optString("props_image_url");
                    this.bpG = optString51;
                    this.bpH = optString54;
                    if (!TextUtils.isEmpty(optString51)) {
                        new AlaLiveMarkData().mark_pic = optString51;
                        BdResourceLoader.getInstance().loadResource(optString51, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.im.a.d.4
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                            public void onLoaded(BdImage bdImage, String str25, int i10) {
                                super.onLoaded((AnonymousClass4) bdImage, str25, i10);
                                Bitmap a2 = d.this.a(bdImage);
                                if (a2 != null && TextUtils.equals(d.this.bpG, optString51)) {
                                    CenteredImageSpan centeredImageSpan = new CenteredImageSpan(d.this.mContext, a2);
                                    SpannableString spannableString5 = new SpannableString("[img] ");
                                    spannableString5.setSpan(centeredImageSpan, 0, spannableString5.length() - 1, 33);
                                    spannableStringBuilder.insert(0, (CharSequence) spannableString5);
                                    cVar.blL.setText(spannableStringBuilder);
                                    cVar.blL.forceLayout();
                                }
                            }
                        }, null);
                    }
                    SpannableString valueOf25 = SpannableString.valueOf(string5 + optString52 + string6 + optString53);
                    if (!TextUtils.isEmpty(valueOf25)) {
                        valueOf25.setSpan(new ForegroundColorSpan(-7479041), 0, string5.length(), 33);
                        valueOf25.setSpan(new ForegroundColorSpan(-7801), string5.length(), string5.length() + optString52.length(), 33);
                        valueOf25.setSpan(new ForegroundColorSpan(-7479041), string5.length() + optString52.length(), string5.length() + optString52.length() + string6.length() + optString53.length(), 33);
                    }
                    spannableStringBuilder.append((CharSequence) valueOf25);
                    if (!TextUtils.isEmpty(optString54)) {
                        new AlaLiveMarkData().mark_pic = optString54;
                        BdResourceLoader.getInstance().loadResource(optString54, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.im.a.d.5
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                            public void onLoaded(BdImage bdImage, String str25, int i10) {
                                super.onLoaded((AnonymousClass5) bdImage, str25, i10);
                                Bitmap a2 = d.this.a(bdImage);
                                if (a2 != null && TextUtils.equals(d.this.bpH, optString54)) {
                                    CenteredImageSpan centeredImageSpan = new CenteredImageSpan(d.this.mContext, a2);
                                    SpannableString spannableString5 = new SpannableString("[img] ");
                                    spannableString5.setSpan(centeredImageSpan, 0, spannableString5.length() - 1, 33);
                                    spannableStringBuilder.insert(spannableStringBuilder.length(), (CharSequence) spannableString5);
                                    cVar.blL.setText(spannableStringBuilder);
                                    cVar.blL.forceLayout();
                                }
                            }
                        }, null);
                    }
                }
            } else if (jSONObject3 != null && str3.equals(UbcStatConstant.ContentType.UBC_TYPE_TYING_GIFT)) {
                jSONObject3.optString("pay_username");
                String optString55 = jSONObject3.optString("tying_gift_name");
                int optInt4 = jSONObject3.optInt("tying_status");
                JSONArray optJSONArray3 = jSONObject3.optJSONArray("gift_member");
                a(spannableStringBuilder, bVar.Lc(), cVar, false, false);
                if (optJSONArray3 != null) {
                    int i10 = 0;
                    for (int i11 = 0; i11 < optJSONArray3.length(); i11++) {
                        String optString56 = optJSONArray3.optJSONObject(i11).optString(LogConfig.VALUE_IM_GIFT);
                        if (optString56 != null && optString56.equals("1")) {
                            i10++;
                        }
                    }
                    if (optInt4 == 0) {
                        String string7 = this.mContext.getString(a.h.ala_middle_context);
                        SpannableString valueOf26 = SpannableString.valueOf(string7);
                        if (!TextUtils.isEmpty(valueOf26)) {
                            valueOf26.setSpan(new ForegroundColorSpan(-5864), 0, string7.length(), 33);
                        }
                        spannableStringBuilder.append((CharSequence) valueOf26);
                        SpannableString valueOf27 = SpannableString.valueOf(" " + optString55 + " ");
                        if (!TextUtils.isEmpty(valueOf27)) {
                            valueOf27.setSpan(new ForegroundColorSpan(-5864), 0, valueOf27.length(), 33);
                        }
                        spannableStringBuilder.append((CharSequence) valueOf27);
                        SpannableString valueOf28 = SpannableString.valueOf(this.mContext.getString(a.h.ala_tying_gift));
                        if (!TextUtils.isEmpty(valueOf28)) {
                            valueOf28.setSpan(new ForegroundColorSpan(-5864), 0, valueOf28.length(), 33);
                        }
                        spannableStringBuilder.append((CharSequence) valueOf28);
                        SpannableString valueOf29 = SpannableString.valueOf(i10 + "/" + optJSONArray3.length());
                        if (!TextUtils.isEmpty(valueOf29)) {
                            valueOf29.setSpan(new ForegroundColorSpan(-5864), 0, valueOf29.length(), 33);
                        }
                        spannableStringBuilder.append((CharSequence) valueOf29);
                    } else {
                        String string8 = this.mContext.getString(a.h.ala_tying_gift_middle);
                        SpannableString valueOf30 = SpannableString.valueOf(string8);
                        if (!TextUtils.isEmpty(valueOf30)) {
                            valueOf30.setSpan(new ForegroundColorSpan(-5864), 0, string8.length(), 33);
                        }
                        spannableStringBuilder.append((CharSequence) valueOf30);
                        SpannableString valueOf31 = SpannableString.valueOf(" " + optString55 + " ");
                        if (!TextUtils.isEmpty(valueOf31)) {
                            valueOf31.setSpan(new ForegroundColorSpan(-5864), 0, valueOf31.length(), 33);
                        }
                        spannableStringBuilder.append((CharSequence) valueOf31);
                        SpannableString valueOf32 = SpannableString.valueOf(this.mContext.getString(a.h.ala_tying_gift_behind));
                        if (!TextUtils.isEmpty(valueOf32)) {
                            valueOf32.setSpan(new ForegroundColorSpan(-5864), 0, valueOf32.length(), 33);
                        }
                        spannableStringBuilder.append((CharSequence) valueOf32);
                    }
                }
            } else if (jSONObject3 != null && "group_guess".equals(str3)) {
                String str25 = bVar.Lc().userName + ": ";
                String optString57 = jSONObject3.optString("name_color", "");
                String trim4 = jSONObject3.optString("content_color").trim();
                String optString58 = jSONObject3.optString("to_user_id");
                String optString59 = jSONObject3.optString("from_user_id");
                SpannableString valueOf33 = SpannableString.valueOf(str25 + (jSONObject3.optString("content") + " "));
                valueOf33.setSpan(new ForegroundColorSpan(Color.parseColor(optString57)), 0, str25.length(), 33);
                valueOf33.setSpan(new ForegroundColorSpan(Color.parseColor(trim4)), str25.length(), valueOf33.length(), 33);
                valueOf33.setSpan(new AbsoluteSizeSpan(12, true), 0, valueOf33.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf33);
                com.baidu.live.view.b bVar34 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_join_group);
                SpannableStringBuilder spannableStringBuilder30 = new SpannableStringBuilder(" ");
                spannableStringBuilder30.setSpan(bVar34, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder30);
                a aVar7 = new a(this.mContext, str3);
                aVar7.hj(optString59);
                aVar7.setToUserId(optString58);
                aVar7.setClickable(true);
                spannableStringBuilder.setSpan(aVar7, 0, spannableStringBuilder.length(), 33);
            } else if (jSONObject3 != null && str3.equals("luckybag_win_prize")) {
                String optString60 = jSONObject3.optString("user_name");
                String optString61 = jSONObject3.optString("user_nickname");
                if (optString61 == null || optString61.isEmpty()) {
                    optString61 = optString60;
                }
                String str26 = " " + this.mContext.getString(a.h.ala_pk_front_props);
                String str27 = " " + this.mContext.getString(a.h.ala_luckybag_send);
                String string9 = this.mContext.getString(a.h.ala_luckybag_open);
                JSONObject optJSONObject7 = jSONObject3.optJSONObject("ext_data");
                if (optJSONObject7 != null && optJSONObject7.length() != 0) {
                    e eVar = new e();
                    eVar.bpU = optJSONObject7.optInt("lucky_bag_id");
                    eVar.bpV = optJSONObject7.optString("lucky_bag_name");
                    eVar.bpX = optJSONObject7.optInt("prize_total_value");
                    eVar.bpW = optJSONObject7.optString("lucky_bag_img");
                    eVar.buttonText = optJSONObject7.optString("button_text");
                    if (!TextUtils.isEmpty(eVar.bpW)) {
                        AlaLiveMarkData alaLiveMarkData7 = new AlaLiveMarkData();
                        alaLiveMarkData7.mark_pic = eVar.bpW;
                        alaLiveMarkData7.isWidthAutoFit = true;
                        com.baidu.live.view.b bVar35 = new com.baidu.live.view.b(this.mContext, alaLiveMarkData7, false, new b.a() { // from class: com.baidu.live.im.a.d.6
                            @Override // com.baidu.live.view.b.a
                            public void e(Bitmap bitmap) {
                                cVar.blL.forceLayout();
                            }

                            @Override // com.baidu.live.view.b.a
                            public void a(com.baidu.live.view.b bVar36, Bitmap bitmap) {
                            }
                        });
                        SpannableStringBuilder spannableStringBuilder31 = new SpannableStringBuilder("[img]");
                        spannableStringBuilder31.setSpan(bVar35, 0, spannableStringBuilder31.length(), 33);
                        spannableStringBuilder.append((CharSequence) spannableStringBuilder31);
                    }
                    SpannableString valueOf34 = SpannableString.valueOf(str26 + optString61 + str27 + eVar.bpV + string9 + " ");
                    if (!TextUtils.isEmpty(valueOf34)) {
                        valueOf34.setSpan(new ForegroundColorSpan(-7479041), 0, str26.length(), 33);
                        valueOf34.setSpan(new ForegroundColorSpan(-7801), str26.length(), str26.length() + optString61.length(), 33);
                        valueOf34.setSpan(new ForegroundColorSpan(-7479041), optString61.length() + str26.length(), valueOf34.length(), 33);
                    }
                    spannableStringBuilder.append((CharSequence) valueOf34);
                    eVar.parserJson(optJSONObject7);
                    if (eVar.bpZ == null || eVar.bpZ.length == 0) {
                        i3 = 0;
                    } else {
                        int length = 0 + eVar.bpZ.length;
                        SpannableString valueOf35 = SpannableString.valueOf(this.mContext.getString(a.h.ala_luckybag_open_surprise) + " ");
                        valueOf35.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf35.length(), 33);
                        spannableStringBuilder.append((CharSequence) valueOf35);
                        for (int i12 = 0; i12 < eVar.bpZ.length; i12++) {
                            SpannableString valueOf36 = SpannableString.valueOf(eVar.bpZ[i12].getGiftName());
                            if (!TextUtils.isEmpty(valueOf36)) {
                                valueOf36.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf36.length(), 33);
                            }
                            spannableStringBuilder.append((CharSequence) valueOf36);
                            if (!TextUtils.isEmpty(eVar.bpZ[i12].KL())) {
                                AlaLiveMarkData alaLiveMarkData8 = new AlaLiveMarkData();
                                alaLiveMarkData8.mark_pic = eVar.bpZ[i12].KL();
                                alaLiveMarkData8.isWidthAutoFit = true;
                                com.baidu.live.view.b bVar36 = new com.baidu.live.view.b(this.mContext, alaLiveMarkData8, false, new b.a() { // from class: com.baidu.live.im.a.d.7
                                    @Override // com.baidu.live.view.b.a
                                    public void e(Bitmap bitmap) {
                                        cVar.blL.forceLayout();
                                    }

                                    @Override // com.baidu.live.view.b.a
                                    public void a(com.baidu.live.view.b bVar37, Bitmap bitmap) {
                                    }
                                });
                                SpannableStringBuilder spannableStringBuilder32 = new SpannableStringBuilder("[img]");
                                spannableStringBuilder32.setSpan(bVar36, 0, spannableStringBuilder32.length(), 33);
                                spannableStringBuilder.append((CharSequence) spannableStringBuilder32);
                            }
                            SpannableString valueOf37 = SpannableString.valueOf(Config.EVENT_HEAT_X + eVar.bpZ[i12].KK() + "，");
                            if (!TextUtils.isEmpty(valueOf37)) {
                                valueOf37.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf37.length(), 33);
                            }
                            spannableStringBuilder.append((CharSequence) valueOf37);
                        }
                        i3 = length;
                    }
                    if (eVar.bpY != null && eVar.bpY.length != 0) {
                        if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(bVar.Lc().userId)) {
                            for (int i13 = 0; i13 < eVar.bpY.length; i13++) {
                                SpannableString valueOf38 = SpannableString.valueOf(eVar.bpY[i13].getGiftName());
                                valueOf38.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf38.length(), 33);
                                spannableStringBuilder.append((CharSequence) valueOf38);
                                if (!TextUtils.isEmpty(eVar.bpY[i13].KL())) {
                                    AlaLiveMarkData alaLiveMarkData9 = new AlaLiveMarkData();
                                    alaLiveMarkData9.mark_pic = eVar.bpY[i13].KL();
                                    alaLiveMarkData9.isWidthAutoFit = true;
                                    com.baidu.live.view.b bVar37 = new com.baidu.live.view.b(this.mContext, alaLiveMarkData9, false, new b.a() { // from class: com.baidu.live.im.a.d.8
                                        @Override // com.baidu.live.view.b.a
                                        public void e(Bitmap bitmap) {
                                            cVar.blL.forceLayout();
                                        }

                                        @Override // com.baidu.live.view.b.a
                                        public void a(com.baidu.live.view.b bVar38, Bitmap bitmap) {
                                        }
                                    });
                                    SpannableStringBuilder spannableStringBuilder33 = new SpannableStringBuilder("[img]");
                                    spannableStringBuilder33.setSpan(bVar37, 0, spannableStringBuilder33.length(), 33);
                                    spannableStringBuilder.append((CharSequence) spannableStringBuilder33);
                                }
                                SpannableString valueOf39 = SpannableString.valueOf(Config.EVENT_HEAT_X + eVar.bpY[i13].KK() + "，");
                                if (!TextUtils.isEmpty(valueOf39)) {
                                    valueOf39.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf39.length(), 33);
                                }
                                spannableStringBuilder.append((CharSequence) valueOf39);
                            }
                        } else if (i3 < 3) {
                            if (eVar.bpY.length <= 3 - i3) {
                                for (int i14 = 0; i14 < eVar.bpY.length; i14++) {
                                    SpannableString valueOf40 = SpannableString.valueOf(eVar.bpY[i14].getGiftName());
                                    valueOf40.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf40.length(), 33);
                                    spannableStringBuilder.append((CharSequence) valueOf40);
                                    if (!TextUtils.isEmpty(eVar.bpY[i14].KL())) {
                                        AlaLiveMarkData alaLiveMarkData10 = new AlaLiveMarkData();
                                        alaLiveMarkData10.mark_pic = eVar.bpY[i14].KL();
                                        alaLiveMarkData10.isWidthAutoFit = true;
                                        com.baidu.live.view.b bVar38 = new com.baidu.live.view.b(this.mContext, alaLiveMarkData10, false, new b.a() { // from class: com.baidu.live.im.a.d.9
                                            @Override // com.baidu.live.view.b.a
                                            public void e(Bitmap bitmap) {
                                                cVar.blL.forceLayout();
                                            }

                                            @Override // com.baidu.live.view.b.a
                                            public void a(com.baidu.live.view.b bVar39, Bitmap bitmap) {
                                            }
                                        });
                                        SpannableStringBuilder spannableStringBuilder34 = new SpannableStringBuilder("[img]");
                                        spannableStringBuilder34.setSpan(bVar38, 0, spannableStringBuilder34.length(), 33);
                                        spannableStringBuilder.append((CharSequence) spannableStringBuilder34);
                                    }
                                    SpannableString valueOf41 = SpannableString.valueOf(Config.EVENT_HEAT_X + eVar.bpY[i14].KK() + "，");
                                    if (!TextUtils.isEmpty(valueOf41)) {
                                        valueOf41.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf41.length(), 33);
                                    }
                                    spannableStringBuilder.append((CharSequence) valueOf41);
                                }
                            } else {
                                for (int i15 = 0; i15 < 3 - i3; i15++) {
                                    SpannableString valueOf42 = SpannableString.valueOf(eVar.bpY[i15].getGiftName());
                                    valueOf42.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf42.length(), 33);
                                    spannableStringBuilder.append((CharSequence) valueOf42);
                                    if (!TextUtils.isEmpty(eVar.bpY[i15].KL())) {
                                        AlaLiveMarkData alaLiveMarkData11 = new AlaLiveMarkData();
                                        alaLiveMarkData11.mark_pic = eVar.bpY[i15].KL();
                                        alaLiveMarkData11.isWidthAutoFit = true;
                                        com.baidu.live.view.b bVar39 = new com.baidu.live.view.b(this.mContext, alaLiveMarkData11, false, new b.a() { // from class: com.baidu.live.im.a.d.10
                                            @Override // com.baidu.live.view.b.a
                                            public void e(Bitmap bitmap) {
                                                cVar.blL.forceLayout();
                                            }

                                            @Override // com.baidu.live.view.b.a
                                            public void a(com.baidu.live.view.b bVar40, Bitmap bitmap) {
                                            }
                                        });
                                        SpannableStringBuilder spannableStringBuilder35 = new SpannableStringBuilder("[img]");
                                        spannableStringBuilder35.setSpan(bVar39, 0, spannableStringBuilder35.length(), 33);
                                        spannableStringBuilder.append((CharSequence) spannableStringBuilder35);
                                    }
                                    SpannableString valueOf43 = SpannableString.valueOf(Config.EVENT_HEAT_X + eVar.bpY[i15].KK() + "，");
                                    if (!TextUtils.isEmpty(valueOf43)) {
                                        valueOf43.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf43.length(), 33);
                                    }
                                    spannableStringBuilder.append((CharSequence) valueOf43);
                                }
                                SpannableString valueOf44 = SpannableString.valueOf(StringHelper.STRING_MORE);
                                valueOf44.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf44.length(), 33);
                                spannableStringBuilder.append((CharSequence) valueOf44);
                            }
                        }
                    }
                    SpannableString valueOf45 = SpannableString.valueOf(this.mContext.getString(a.h.ala_luckybag_total_prize) + eVar.bpX + "T豆");
                    valueOf45.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf45.length(), 33);
                    spannableStringBuilder.append((CharSequence) valueOf45);
                    boolean z6 = !this.bpf;
                    if (!TextUtils.isEmpty(eVar.buttonText) && z6) {
                        com.baidu.live.im.view.b bVar40 = new com.baidu.live.im.view.b(this.mContext, eVar.buttonText, false, true, "#FFFFFF", "#FFFFFF", "#000000");
                        SpannableString spannableString5 = new SpannableString(" raterate");
                        spannableString5.setSpan(bVar40, 1, spannableString5.length(), 33);
                        spannableStringBuilder.append((CharSequence) spannableString5);
                    }
                    a aVar8 = new a(this.mContext, eVar.bpU, str3);
                    aVar8.setClickable(z6);
                    spannableStringBuilder.setSpan(aVar8, 0, spannableStringBuilder.length(), 33);
                } else {
                    SpannableString valueOf46 = SpannableString.valueOf(str26);
                    valueOf46.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf46.length(), 33);
                    spannableStringBuilder.append((CharSequence) valueOf46);
                    SpannableString valueOf47 = SpannableString.valueOf(optString61);
                    valueOf47.setSpan(new ForegroundColorSpan(-7801), 0, valueOf47.length(), 33);
                    spannableStringBuilder.append((CharSequence) valueOf47);
                    SpannableString valueOf48 = SpannableString.valueOf(str27 + "福袋" + string9 + "神秘大礼");
                    valueOf48.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf48.length(), 33);
                    spannableStringBuilder.append((CharSequence) valueOf48);
                    boolean z7 = !this.bpf;
                    if (z7) {
                        com.baidu.live.im.view.b bVar41 = new com.baidu.live.im.view.b(this.mContext, "我也试试>>", false, true, "#FFFFFF", "#FFFFFF", "#000000");
                        SpannableString spannableString6 = new SpannableString(" raterate");
                        spannableString6.setSpan(bVar41, 1, spannableString6.length(), 33);
                        spannableStringBuilder.append((CharSequence) spannableString6);
                    }
                    a aVar9 = new a(this.mContext, -1, str3);
                    aVar9.setClickable(z7);
                    spannableStringBuilder.setSpan(aVar9, 0, spannableStringBuilder.length(), 33);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(bVar.Lc().userId)) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(-5864), 0, spannableStringBuilder.length(), 33);
                }
            }
        }
        return spannableStringBuilder;
    }

    public SpannableStringBuilder a(SpannableStringBuilder spannableStringBuilder, f fVar) {
        String str;
        if (fVar == null) {
            return null;
        }
        if (!TextUtils.isEmpty(fVar.bpw)) {
            SpannableString valueOf = SpannableString.valueOf(("×" + str) + "获得了");
            valueOf.setSpan(new ForegroundColorSpan(-5864), 0, valueOf.length(), 33);
            spannableStringBuilder.append((CharSequence) valueOf);
        }
        if (!fVar.boh && fVar.bpz != 0.0d && !TextUtils.isEmpty(fVar.bpA)) {
            com.baidu.live.im.view.b bVar = new com.baidu.live.im.view.b(this.mContext, fVar.bpz + "倍" + fVar.bpA, false, true, fVar.bpB, fVar.bpC, fVar.bpD, true);
            SpannableString spannableString = new SpannableString(" raterate");
            spannableString.setSpan(bVar, 1, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        if (fVar.bqa != null) {
            for (int i = 0; i < fVar.bqa.length; i++) {
                com.baidu.live.im.view.b bVar2 = new com.baidu.live.im.view.b(this.mContext, fVar.bqa[i].KG(), false, true, fVar.bqa[i].KI(), fVar.bqa[i].KJ(), fVar.bqa[i].KH());
                SpannableString spannableString2 = new SpannableString(" raterate");
                spannableString2.setSpan(bVar2, 1, spannableString2.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableString2);
            }
            return spannableStringBuilder;
        }
        return spannableStringBuilder;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00f8 A[Catch: JSONException -> 0x013d, TryCatch #0 {JSONException -> 0x013d, blocks: (B:3:0x0003, B:5:0x000b, B:6:0x0012, B:8:0x0021, B:9:0x004e, B:11:0x0057, B:12:0x008d, B:14:0x00ac, B:15:0x00c6, B:18:0x00d0, B:20:0x00e0, B:22:0x00e6, B:23:0x00f0, B:25:0x00f8, B:27:0x0103, B:29:0x010b, B:30:0x0114, B:37:0x0142, B:33:0x0137, B:32:0x012b), top: B:39:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private f D(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        boolean z = true;
        try {
            if (bVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) bVar.getObjContent();
            } else {
                jSONObject = new JSONObject(bVar.getContent());
            }
            f fVar = new f();
            JSONObject optJSONObject = jSONObject.optJSONObject("pk_info");
            if (optJSONObject != null) {
                fVar.bpz = optJSONObject.optDouble("pk_honer_buff_multiple");
                fVar.bpA = optJSONObject.optString("pk_honer_buff_text");
                fVar.bpB = optJSONObject.optString("pk_honer_buff_text_color_start");
                fVar.bpC = optJSONObject.optString("pk_honer_buff_text_color_end");
                fVar.bpD = optJSONObject.optString("pk_honer_buff_text_font_color");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("headline_info");
            if (optJSONObject2 != null) {
                fVar.bpy = optJSONObject2.optString("second_text");
                fVar.bpz = optJSONObject2.optDouble("headline_buff_multiple");
                fVar.bpA = optJSONObject2.optString("headline_buff_text");
                fVar.bpB = optJSONObject2.optString("headline_buff_text_color_start");
                fVar.bpC = optJSONObject2.optString("headline_buff_text_color_end");
                fVar.bpD = optJSONObject2.optString("headline_buff_text_font_color");
            }
            fVar.parserJson(jSONObject);
            fVar.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            fVar.bpw = jSONObject.optString("gift_count");
            if (bVar.Lm() > 0) {
                fVar.bpx = bVar.Lm() + "";
            } else {
                fVar.bpx = "";
            }
            fVar.boh = jSONObject.optInt("is_free") == 1;
            fVar.bog = bVar.Ll();
            com.baidu.live.gift.g gt = ac.gt(fVar.giftId);
            if (gt != null) {
                if (gt.Ee()) {
                    fVar.giftName = this.mContext.getString(a.h.sdk_text_gift_graffiti);
                    if (TextUtils.isEmpty(fVar.giftName)) {
                        fVar.giftName = jSONObject.optString("gift_name");
                    }
                    if (!z && TextUtils.isEmpty(fVar.aYq)) {
                        fVar.aYq = jSONObject.optString("gift_url");
                    }
                    fVar.beG = jSONObject.optString("gift_source_text");
                    fVar.bpF = jSONObject.optString("gift_source");
                    fVar.aKP = bVar.aKP;
                    return fVar;
                }
                fVar.giftName = gt.DV();
                fVar.aYq = gt.getThumbnail_url();
            }
            z = false;
            if (TextUtils.isEmpty(fVar.giftName)) {
            }
            if (!z) {
                fVar.aYq = jSONObject.optString("gift_url");
            }
            fVar.beG = jSONObject.optString("gift_source_text");
            fVar.bpF = jSONObject.optString("gift_source");
            fVar.aKP = bVar.aKP;
            return fVar;
        } catch (JSONException e2) {
            return null;
        }
    }

    /* loaded from: classes10.dex */
    private static class a extends ClickableSpan {
        private String aIY;
        private String aLm;
        private String aQA;
        private String aSq;
        private int bpP;
        private boolean bpQ;
        private String bpR;
        private String contentType;
        private Context context;
        private boolean isHost;
        private String liveId;
        private String toUserId;
        private String url;

        public a(Context context, String str, String str2) {
            this.context = context;
            this.url = str;
            this.contentType = str2;
        }

        public a(Context context, int i, String str) {
            this.context = context;
            this.bpP = i;
            this.contentType = str;
        }

        public a(Context context, boolean z, String str, String str2) {
            this.context = context;
            this.aIY = str;
            this.contentType = str2;
        }

        public a(Context context, String str, String str2, String str3) {
            this.context = context;
            this.url = str;
            this.bpR = str2;
            this.contentType = str3;
        }

        public a(Context context, String str, String str2, String str3, String str4, String str5, boolean z) {
            this.context = context;
            this.url = str;
            this.contentType = str2;
            this.liveId = str3;
            this.aLm = str4;
            this.aSq = str5;
            this.isHost = z;
        }

        public a(Context context, String str) {
            this.context = context;
            this.contentType = str;
        }

        public void setToUserId(String str) {
            this.toUserId = str;
        }

        public void hj(String str) {
            this.aQA = str;
        }

        public void setClickable(boolean z) {
            this.bpQ = z;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = this.contentType;
            char c = 65535;
            switch (str.hashCode()) {
                case -2089676386:
                    if (str.equals("live_notice_quick_chat")) {
                        c = '\t';
                        break;
                    }
                    break;
                case -1480538273:
                    if (str.equals("guard_seat")) {
                        c = 3;
                        break;
                    }
                    break;
                case -985894342:
                    if (str.equals("live_poke_back")) {
                        c = '\n';
                        break;
                    }
                    break;
                case -649059640:
                    if (str.equals("activity_common_im")) {
                        c = 2;
                        break;
                    }
                    break;
                case -421503819:
                    if (str.equals("mysterious_man_tip")) {
                        c = 11;
                        break;
                    }
                    break;
                case -244328516:
                    if (str.equals("wish_list_finish")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1595898:
                    if (str.equals("wish_list_success")) {
                        c = 4;
                        break;
                    }
                    break;
                case 39010809:
                    if (str.equals("guard_club_join")) {
                        c = 6;
                        break;
                    }
                    break;
                case 158464144:
                    if (str.equals("luckybag_win_prize")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 529916424:
                    if (str.equals("activity_notice")) {
                        c = 1;
                        break;
                    }
                    break;
                case 973563845:
                    if (str.equals("custom_im_notice_live_assistant")) {
                        c = 7;
                        break;
                    }
                    break;
                case 1090939927:
                    if (str.equals("group_guess")) {
                        c = '\f';
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
                    ci ciVar = new ci();
                    ciVar.aSq = this.aSq;
                    ciVar.liveId = this.liveId;
                    ciVar.aLm = this.aLm;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, ciVar));
                    return;
                case 1:
                case 2:
                    com.baidu.live.an.c cVar = new com.baidu.live.an.c();
                    cVar.isFullScreen = this.bpR.equals("full");
                    cVar.url = this.url;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
                    return;
                case 3:
                    if (this.bpQ) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913153));
                        return;
                    }
                    return;
                case 4:
                case 5:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913154, null));
                    return;
                case 6:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106, "im"));
                    return;
                case 7:
                    if (!TextUtils.isEmpty(this.url)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913132, this.url));
                        return;
                    }
                    return;
                case '\b':
                    ao aoVar = new ao();
                    aoVar.aLx = this.bpP;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aoVar));
                    return;
                case '\t':
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.aIY));
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "gochat_clk").setContentExt(null, null, null));
                    return;
                case '\n':
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913261, this.aIY));
                    return;
                case 11:
                    com.baidu.live.an.c cVar2 = new com.baidu.live.an.c();
                    cVar2.url = this.aIY;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar2));
                    return;
                case '\f':
                    bm bmVar = new bm();
                    bmVar.aQA = this.aQA;
                    bmVar.toUserId = this.toUserId;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913298, bmVar));
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
        } catch (OutOfMemoryError e2) {
            BdLog.e(e2);
            if (rawBitmap.getConfig() != null) {
                return null;
            }
            try {
                copy = rawBitmap.copy(Bitmap.Config.RGB_565, false);
            } catch (OutOfMemoryError e3) {
                BdLog.e(e3);
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
        } catch (OutOfMemoryError e4) {
            BdLog.e(e4);
            if (copy != null) {
                copy.recycle();
            }
            return null;
        }
    }

    /* loaded from: classes10.dex */
    private static class e {
        public int bpU;
        public String bpV;
        public String bpW;
        public int bpX;
        public c[] bpY;
        public C0184d[] bpZ;
        public String buttonText;

        private e() {
        }

        public void parserJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("prize_member");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("surprise_prize_member");
                if (optJSONArray2 != null) {
                    this.bpZ = new C0184d[optJSONArray2.length()];
                    for (int i = 0; i < optJSONArray2.length(); i++) {
                        try {
                            this.bpZ[i] = new C0184d(optJSONArray2.getJSONObject(i));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (optJSONArray != null) {
                    this.bpY = new c[optJSONArray.length()];
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        try {
                            this.bpY[i2] = new c(optJSONArray.getJSONObject(i2));
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class c {
        public String aYq;
        public int bpS;
        public int bpT;
        public int giftId;
        public String giftName;

        public c(JSONObject jSONObject) {
            this.bpS = jSONObject.optInt("prize_type");
            this.bpT = jSONObject.optInt("prize_num");
            this.giftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
            this.giftName = jSONObject.optString("gift_name");
            this.aYq = jSONObject.optString("gift_url");
        }

        public int KK() {
            return this.bpT;
        }

        public String getGiftName() {
            return this.giftName;
        }

        public String KL() {
            return this.aYq;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.im.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0184d {
        public String aYq;
        public int bpS;
        public int bpT;
        public int giftId;
        public String giftName;

        public C0184d(JSONObject jSONObject) {
            this.bpS = jSONObject.optInt("prize_type");
            this.bpT = jSONObject.optInt("prize_num");
            this.giftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
            this.giftName = jSONObject.optString("gift_name");
            this.aYq = jSONObject.optString("gift_url");
        }

        public int KK() {
            return this.bpT;
        }

        public String getGiftName() {
            return this.giftName;
        }

        public String KL() {
            return this.aYq;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class f {
        public boolean aKP;
        public String aYq;
        public String beG;
        public double bog;
        public boolean boh;
        public String bpA;
        public String bpB;
        public String bpC;
        public String bpD;
        public String bpF;
        public String bpw;
        public String bpx;
        public String bpy;
        public double bpz;
        public b[] bqa;
        public String giftId;
        public String giftName;

        private f() {
            this.aKP = false;
        }

        public void parserJson(JSONObject jSONObject) {
            JSONArray optJSONArray;
            if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("im_icon_conf")) != null) {
                this.bqa = new b[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        this.bqa[i] = new b(optJSONArray.getJSONObject(i));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class b {
        public String bpr;
        public String bps;
        public String bpt;
        public String bpu;

        public b(JSONObject jSONObject) {
            this.bpr = jSONObject.optString("text");
            this.bps = jSONObject.optString("text_color");
            this.bpt = jSONObject.optString("bg_color_start");
            this.bpu = jSONObject.optString("bg_color_end");
        }

        public String KG() {
            return this.bpr;
        }

        public String KH() {
            return this.bps;
        }

        public String KI() {
            return this.bpt;
        }

        public String KJ() {
            return this.bpu;
        }
    }
}

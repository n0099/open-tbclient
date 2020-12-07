package com.baidu.live.im.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
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
import com.baidu.live.adp.widget.CenteredImageSpan;
import com.baidu.live.adp.widget.imageview.BdImage;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.ai;
import com.baidu.live.data.bz;
import com.baidu.live.gift.ac;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.view.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d extends com.baidu.live.im.a.b {
    private String bnS;
    private String bnT;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(Context context) {
        super(context, com.baidu.live.im.a.bjQ);
    }

    @Override // com.baidu.live.im.a.b
    protected void Nx() {
        if (Ny()) {
            Nz();
        } else {
            NA();
        }
    }

    @Override // com.baidu.live.im.a.b
    protected int getColor() {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0646  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0133  */
    @Override // com.baidu.live.im.a.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected SpannableStringBuilder a(com.baidu.live.im.data.b bVar, final com.baidu.live.im.c cVar) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        String str;
        String str2;
        String str3;
        Exception exc;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        String str4;
        String str5;
        String str6;
        JSONException jSONException;
        String str7;
        JSONObject jSONObject5;
        JSONObject jSONObject6;
        String str8;
        String str9;
        String str10;
        boolean z;
        String str11;
        boolean z2;
        int i;
        boolean z3;
        String string;
        int i2;
        JSONObject jSONObject7;
        String format;
        JSONObject jSONObject8;
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        this.bnS = null;
        this.bnT = null;
        String str12 = "";
        String str13 = "";
        String str14 = "";
        JSONObject jSONObject9 = null;
        if (bVar != null) {
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject8 = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject8 = new JSONObject(bVar.getContent());
                }
                try {
                    String optString = jSONObject8.optString("content_type");
                    try {
                        if (optString.equals("start_grab_wheel")) {
                            str14 = jSONObject8.optString("ext_data");
                        } else {
                            String optString2 = jSONObject8.optString("ext");
                            if (!TextUtils.isEmpty(optString2)) {
                                str14 = new String(Base64.decode(optString2.getBytes(), 0));
                            }
                            if (TbConfig.isForceNoticeIm) {
                                str14 = optString2;
                            }
                        }
                        if (!TextUtils.isEmpty(str14)) {
                            jSONObject9 = new JSONObject(str14);
                        }
                    } catch (JSONException e2) {
                        jSONObject3 = jSONObject8;
                        jSONObject4 = null;
                        str4 = "";
                        str5 = "";
                        str6 = optString;
                        jSONException = e2;
                    } catch (Exception e3) {
                        jSONObject = jSONObject8;
                        jSONObject2 = null;
                        str = "";
                        str2 = "";
                        str3 = optString;
                        exc = e3;
                    }
                    try {
                        str12 = jSONObject8.optString("text");
                        str13 = jSONObject8.optString("level_id");
                        str7 = jSONObject8.optString("anchorName");
                        jSONObject5 = jSONObject8;
                        jSONObject6 = jSONObject9;
                        str8 = str12;
                        str9 = optString;
                        str10 = str13;
                    } catch (JSONException e4) {
                        jSONObject3 = jSONObject8;
                        jSONObject4 = jSONObject9;
                        str4 = str13;
                        str5 = str12;
                        str6 = optString;
                        jSONException = e4;
                        jSONException.printStackTrace();
                        str7 = null;
                        jSONObject5 = jSONObject3;
                        jSONObject6 = jSONObject4;
                        str8 = str5;
                        str9 = str6;
                        str10 = str4;
                        if (!TextUtils.isEmpty(str10)) {
                            bVar.NU().level_id = JavaTypesHelper.toInt(str10, 0);
                        }
                        z = false;
                        String str15 = null;
                        if (str9 == null) {
                        }
                        if (!z) {
                        }
                        return spannableStringBuilder;
                    } catch (Exception e5) {
                        jSONObject = jSONObject8;
                        jSONObject2 = jSONObject9;
                        str = str13;
                        str2 = str12;
                        str3 = optString;
                        exc = e5;
                        exc.printStackTrace();
                        str7 = null;
                        jSONObject5 = jSONObject;
                        jSONObject6 = jSONObject2;
                        str8 = str2;
                        str9 = str3;
                        str10 = str;
                        if (!TextUtils.isEmpty(str10)) {
                        }
                        z = false;
                        String str152 = null;
                        if (str9 == null) {
                        }
                        if (!z) {
                        }
                        return spannableStringBuilder;
                    }
                } catch (JSONException e6) {
                    jSONObject3 = jSONObject8;
                    jSONObject4 = null;
                    str4 = "";
                    str5 = "";
                    str6 = null;
                    jSONException = e6;
                } catch (Exception e7) {
                    jSONObject = jSONObject8;
                    jSONObject2 = null;
                    str = "";
                    str2 = "";
                    str3 = null;
                    exc = e7;
                }
            } catch (JSONException e8) {
                jSONObject3 = null;
                jSONObject4 = null;
                str4 = "";
                str5 = "";
                str6 = null;
                jSONException = e8;
            } catch (Exception e9) {
                jSONObject = null;
                jSONObject2 = null;
                str = "";
                str2 = "";
                str3 = null;
                exc = e9;
            }
            if (!TextUtils.isEmpty(str10) && JavaTypesHelper.toInt(str10, 0) > 0) {
                bVar.NU().level_id = JavaTypesHelper.toInt(str10, 0);
            }
            z = false;
            String str1522 = null;
            if (str9 == null) {
                if (!TextUtils.isEmpty(str8)) {
                    str11 = str8;
                    z2 = false;
                    i = -30312;
                } else {
                    str11 = bVar.getContent();
                    i = -30312;
                    z2 = false;
                }
            } else if (str9.equals("custom_live_notice")) {
                str11 = str8;
                i = -7479041;
                z2 = false;
            } else if (str9.equals("custom_im_notice")) {
                z = true;
                str11 = null;
                i = -30312;
                z2 = false;
            } else if (str9.equals("custom_im_notice_live_assistant")) {
                z = true;
                str11 = null;
                i = -30312;
                z2 = false;
            } else if (str9.equals("custom_network_change")) {
                str11 = str8;
                z2 = false;
                i = -30312;
            } else if (str9.equals("enter_live")) {
                String string2 = this.mContext.getString(a.h.ala_enter_live);
                a(spannableStringBuilder, bVar.NU(), cVar, false, false, false);
                str11 = string2;
                z2 = false;
                i = -1711276033;
            } else if (str9.equals("backstage_live")) {
                str11 = str8;
                i = -7479041;
                z2 = false;
            } else if (str9.equals("offline_type")) {
                str11 = str8;
                z2 = false;
                i = -30312;
            } else if (str9.equals("close_live")) {
                str11 = this.mContext.getString(a.h.ala_close_live);
                i = -30312;
                z2 = false;
            } else if (str9.equals("follow_anchor")) {
                str11 = this.mContext.getString(a.h.ala_follow_live);
                a(spannableStringBuilder, bVar.NU(), cVar, false, false);
                z2 = false;
                i = -7479041;
            } else if (str9.equals(com.baidu.tbadk.TbConfig.TMP_SHARE_DIR_NAME)) {
                str11 = this.mContext.getString(a.h.ala_share_live);
                a(spannableStringBuilder, bVar.NU(), cVar, false, false);
                if ((bVar instanceof com.baidu.live.im.a) && ((com.baidu.live.im.a) bVar).Mr().equals(bVar.NU().userId)) {
                    com.baidu.live.view.b bVar2 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_anchor);
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("  ");
                    spannableStringBuilder2.setSpan(bVar2, 0, 1, 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                }
                z2 = false;
                i = -7479041;
            } else if (str9.equals("share_tieba")) {
                i = -7479041;
                if ((bVar instanceof com.baidu.live.im.a) && ((com.baidu.live.im.a) bVar).Mr().equals(bVar.NU().userId)) {
                    com.baidu.live.view.b bVar3 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_anchor);
                    SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("  ");
                    spannableStringBuilder3.setSpan(bVar3, 0, 1, 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                }
                str11 = str8;
                z2 = false;
            } else if (str9.equals("remove_video")) {
                if (jSONObject5.optString("poke_msg").isEmpty()) {
                    str1522 = str8;
                    z3 = false;
                } else {
                    z3 = true;
                }
                str11 = str1522;
                z = z3;
                z2 = false;
                i = -30312;
            } else if (str9.equals("ueg_warn")) {
                str11 = str8;
                z2 = false;
                i = -30312;
            } else if (str9.equals("live_admin")) {
                a(spannableStringBuilder, bVar.NU(), cVar, false, false);
                z2 = false;
                i = -7479041;
                str11 = str8;
            } else if (str9.equals("live_talk_ban") || str9.equals("live_talk_remove_ban") || str9.equals("live_talk_admin_ban") || str9.equals("live_talk_admin_remove_ban")) {
                a(spannableStringBuilder, bVar.NU(), cVar, false, false);
                str11 = str8;
                z2 = false;
                i = -30312;
            } else if (str9.equals("challenge_direct_start")) {
                i = -5864;
                z2 = true;
                str11 = str8;
            } else if (str9.equals("challenge_direct_matched")) {
                i = -5864;
                z2 = true;
                str11 = str8;
            } else if (str9.equals("challenge_random_start")) {
                i = -5864;
                z2 = true;
                str11 = str8;
            } else if (str9.equals("challenge_random_matched")) {
                i = -5864;
                z2 = true;
                str11 = str8;
            } else if (str9.equals("avts")) {
                str11 = str8;
                z2 = false;
                i = -30312;
            } else if (str9.equals("allin")) {
                str11 = str8;
                z2 = false;
                i = -30312;
            } else if (str9.equals("share_rmb")) {
                str11 = this.mContext.getString(a.h.ala_share_rmb);
                a(spannableStringBuilder, bVar.NU(), cVar, false, false);
                z2 = false;
                i = -7479041;
            } else if (str9.equals("zan_rmb")) {
                if ((bVar instanceof com.baidu.live.im.a) && ((com.baidu.live.im.a) bVar).Mr().equals(bVar.NU().userId)) {
                    com.baidu.live.view.b bVar4 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_anchor);
                    SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder("  ");
                    spannableStringBuilder4.setSpan(bVar4, 0, 1, 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder4);
                }
                str11 = this.mContext.getString(a.h.ala_zan_rmb);
                a(spannableStringBuilder, bVar.NU(), cVar, false, false);
                z2 = false;
                i = -1711276033;
            } else if (str9.equals("start_grab_wheel")) {
                z = true;
                str11 = null;
                i = -30312;
                z2 = false;
            } else if (str9.equals("guard_club_join")) {
                z = true;
                str11 = null;
                i = -30312;
                z2 = false;
            } else if (str9.equals("haokan_buy_goods")) {
                z = true;
                str11 = null;
                i = -30312;
                z2 = false;
            } else if (str9.equals("send_redpacket")) {
                z = true;
                str11 = null;
                i = -30312;
                z2 = false;
            } else if (str9.equals("start_grab_redpacket")) {
                z = true;
                str11 = null;
                i = -30312;
                z2 = false;
            } else if (str9.equals("guard_seat")) {
                z = true;
                str11 = null;
                i = -30312;
                z2 = false;
            } else if (str9.equals("challenge_mvp")) {
                z = true;
                str11 = null;
                i = -30312;
                z2 = false;
            } else if (str9.equals("challenge_mvp_punish")) {
                z = true;
                str11 = null;
                i = -30312;
                z2 = false;
            } else if (str9.equals("challenge_winner_by_autofail")) {
                z = true;
                str11 = null;
                i = -30312;
                z2 = false;
            } else if (str9.equals("wish_list_success") || str9.equals("wish_list_finish")) {
                z = true;
                str11 = null;
                i = -30312;
                z2 = false;
            } else if (str9.equals("privilege_award_royal_success")) {
                z = true;
                str11 = null;
                i = -30312;
                z2 = false;
            } else if (str9.equals("activity_gift")) {
                z = true;
                str11 = null;
                i = -30312;
                z2 = false;
            } else if (str9.equals("activity_notice")) {
                z = true;
                str11 = null;
                i = -30312;
                z2 = false;
            } else if (str9.equals("activity_common_im")) {
                z = true;
                str11 = null;
                i = -30312;
                z2 = false;
            } else if (str9.equals("pk_first_blood")) {
                z = true;
                str11 = null;
                i = -30312;
                z2 = false;
            } else if (str9.equals("pk_send_props")) {
                z = true;
                str11 = null;
                i = -30312;
                z2 = false;
            } else if (str9.equals("pk_mvp_props")) {
                z = true;
                str11 = null;
                i = -30312;
                z2 = false;
            } else if (str9.equals("tying_gift")) {
                z = true;
                str11 = null;
                i = -30312;
                z2 = false;
            } else if (str9.equals("live_notice_quick_chat")) {
                z = true;
                str11 = null;
                i = -30312;
                z2 = false;
            } else if (str9.equals("live_poke_back")) {
                z = true;
                str11 = null;
                i = -30312;
                z2 = false;
            } else if (str9.equals("luckybag_win_prize")) {
                z = true;
                str11 = null;
                i = -30312;
                z2 = false;
            } else if (str9.equals("custom_gift")) {
                z = true;
                str11 = null;
                i = -30312;
                z2 = false;
            } else if (str9.equals("custom_anchor_identity_update") || str9.equals("custom_master_identity")) {
                str11 = str8;
                i = -5864;
                z2 = false;
            } else if (str9.equals("add_tags_to_anchor")) {
                String str16 = null;
                if (bVar != null && (bVar instanceof com.baidu.live.im.a) && bVar.NU() != null && TextUtils.equals(bVar.NU().userId, TbadkCoreApplication.getCurrentAccount())) {
                    str16 = this.mContext.getString(a.h.add_tag_text_yourself);
                }
                a(spannableStringBuilder, bVar.NU(), cVar, false, false, true, str16);
                str11 = str8;
                z2 = false;
                i = -1;
            } else if (!TextUtils.isEmpty(str8)) {
                str11 = str8;
                z2 = false;
                i = -30312;
            } else {
                str11 = bVar.getContent();
                i = -30312;
                z2 = false;
            }
            if (!z) {
                if (TextUtils.isEmpty(bVar.getLink())) {
                    spannableStringBuilder.append(com.baidu.live.utils.g.G(str11, i));
                    if (z2) {
                        com.baidu.live.view.b bVar5 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_pk);
                        SpannableStringBuilder spannableStringBuilder5 = new SpannableStringBuilder("  ");
                        spannableStringBuilder5.setSpan(bVar5, 0, 1, 33);
                        spannableStringBuilder.insert(0, (CharSequence) spannableStringBuilder5);
                    }
                } else {
                    SpannableString valueOf = SpannableString.valueOf(str11);
                    valueOf.setSpan(new a(this.mContext, bVar.getLink(), str9), 0, str11 != null ? str11.length() : 0, 33);
                    spannableStringBuilder.append((CharSequence) valueOf);
                }
            } else if (TextUtils.equals(str9, "custom_im_notice")) {
                SpannableString valueOf2 = SpannableString.valueOf(str8);
                valueOf2.setSpan(new ForegroundColorSpan(-1711276033), 0, str8.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf2);
                com.baidu.live.view.b bVar6 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_arrow);
                SpannableStringBuilder spannableStringBuilder6 = new SpannableStringBuilder("  ");
                spannableStringBuilder6.setSpan(bVar6, 1, 2, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder6);
                spannableStringBuilder.setSpan(new a(this.mContext, bVar.getLink(), str9), 0, spannableStringBuilder.length(), 33);
            } else if (TextUtils.equals(str9, "custom_im_notice_live_assistant")) {
                SpannableString valueOf3 = SpannableString.valueOf(str8);
                valueOf3.setSpan(new ForegroundColorSpan(-7479041), 0, str8.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf3);
                com.baidu.live.view.b bVar7 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_arrow);
                SpannableStringBuilder spannableStringBuilder7 = new SpannableStringBuilder("  ");
                spannableStringBuilder7.setSpan(bVar7, 1, 2, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder7);
                spannableStringBuilder.setSpan(new a(this.mContext, bVar.getLink(), str9), 0, spannableStringBuilder.length(), 33);
            } else if (TextUtils.equals(str9, "custom_im_notice_live_assistant")) {
                SpannableString valueOf4 = SpannableString.valueOf(str8);
                valueOf4.setSpan(new ForegroundColorSpan(-7479041), 0, str8.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf4);
                com.baidu.live.view.b bVar8 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_arrow);
                SpannableStringBuilder spannableStringBuilder8 = new SpannableStringBuilder("  ");
                spannableStringBuilder8.setSpan(bVar8, 1, 2, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder8);
                spannableStringBuilder.setSpan(new a(this.mContext, bVar.getLink(), str9), 0, spannableStringBuilder.length(), 33);
            } else if ("send_redpacket".equals(str9) || "start_grab_redpacket".equals(str9)) {
                com.baidu.live.view.b bVar9 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_redpacket);
                SpannableStringBuilder spannableStringBuilder9 = new SpannableStringBuilder("  ");
                spannableStringBuilder9.setSpan(bVar9, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder9);
                a(spannableStringBuilder, bVar.NU(), cVar, false, false);
                cj(false);
                if ("send_redpacket".equals(str9)) {
                    String str17 = "";
                    if (jSONObject6 != null) {
                        str17 = jSONObject6.optString(LogConfig.LOG_AMOUNT);
                    }
                    string = String.format(this.mContext.getString(a.h.ala_send_redpacket), str17);
                } else {
                    string = "start_grab_redpacket".equals(str9) ? this.mContext.getString(a.h.ala_start_grab_redpacket) : str11;
                }
                SpannableString valueOf5 = SpannableString.valueOf(string);
                valueOf5.setSpan(new ForegroundColorSpan(-5864), 0, valueOf5.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf5);
                if ("start_grab_redpacket".equals(str9)) {
                    com.baidu.live.view.b bVar10 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_kaiqiang);
                    SpannableStringBuilder spannableStringBuilder10 = new SpannableStringBuilder("  ");
                    spannableStringBuilder10.setSpan(bVar10, 1, 2, 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder10);
                }
                if (jSONObject6 != null) {
                    spannableStringBuilder.setSpan(new a(this.mContext, bVar.getLink(), str9, jSONObject6.optString("live_id"), jSONObject6.optString("anchor_id"), jSONObject6.optString("red_packet_id"), Nw()), 0, spannableStringBuilder.length(), 33);
                }
            } else if (jSONObject5 != null && "guard_seat".equals(str9)) {
                com.baidu.live.view.b bVar11 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_shouhu);
                SpannableStringBuilder spannableStringBuilder11 = new SpannableStringBuilder("  ");
                spannableStringBuilder11.setSpan(bVar11, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder11);
                String optString3 = jSONObject5.optString("prefix");
                String optString4 = jSONObject5.optString("nickname");
                String optString5 = jSONObject5.optString("suffix");
                StringBuilder sb = new StringBuilder(optString3);
                if (!TextUtils.isEmpty(optString4)) {
                    sb.append(" ");
                    sb.append(optString4);
                    sb.append(" ");
                }
                sb.append(optString5);
                String sb2 = sb.toString();
                SpannableString valueOf6 = SpannableString.valueOf(sb2);
                valueOf6.setSpan(new ForegroundColorSpan(-5864), 0, sb2.length(), 33);
                if (!TextUtils.isEmpty(optString4)) {
                    valueOf6.setSpan(new ForegroundColorSpan(-5462), optString3.length() + 1, optString3.length() + 1 + optString4.length(), 33);
                }
                spannableStringBuilder.append((CharSequence) valueOf6, 0, sb2.length());
                boolean z4 = jSONObject5.optInt("is_jump") == 1;
                if (z4) {
                    com.baidu.live.view.b bVar12 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_arrow);
                    SpannableStringBuilder spannableStringBuilder12 = new SpannableStringBuilder("  ");
                    spannableStringBuilder12.setSpan(bVar12, 1, 2, 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder12);
                }
                a aVar = new a(this.mContext, bVar.getLink(), str9);
                aVar.setClickable(z4);
                spannableStringBuilder.setSpan(aVar, 0, spannableStringBuilder.length(), 33);
            } else if (jSONObject5 != null && "challenge_mvp".equals(str9)) {
                String optString6 = jSONObject5.optString("prefix");
                String optString7 = jSONObject5.optString("nickname");
                String optString8 = jSONObject5.optString("suffix");
                StringBuilder sb3 = new StringBuilder(optString6);
                ForegroundColorSpan foregroundColorSpan = null;
                int i3 = 0;
                int i4 = 0;
                if (!TextUtils.isEmpty(optString7)) {
                    sb3.append(" ");
                    i3 = sb3.length();
                    sb3.append(optString7);
                    i4 = optString7.length() + i3;
                    sb3.append(" ");
                    foregroundColorSpan = new ForegroundColorSpan(-5462);
                }
                sb3.append(optString8);
                String sb4 = sb3.toString();
                SpannableString valueOf7 = SpannableString.valueOf(sb4);
                valueOf7.setSpan(new ForegroundColorSpan(-5864), 0, sb4.length(), 33);
                if (foregroundColorSpan != null) {
                    valueOf7.setSpan(foregroundColorSpan, i3, i4, 33);
                }
                spannableStringBuilder.append((CharSequence) valueOf7, 0, sb4.length());
                com.baidu.live.view.b bVar13 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_pk);
                SpannableStringBuilder spannableStringBuilder13 = new SpannableStringBuilder("  ");
                spannableStringBuilder13.setSpan(bVar13, 0, 1, 33);
                spannableStringBuilder.insert(0, (CharSequence) spannableStringBuilder13);
            } else if (jSONObject5 != null && "challenge_mvp_punish".equals(str9)) {
                int optInt = jSONObject5.optInt("punish_type");
                String optString9 = jSONObject5.optString("mvp_nickname");
                String optString10 = jSONObject5.optString("sticker_name");
                String optString11 = jSONObject5.optString("text");
                if (optInt == 1) {
                    optString11 = String.format(this.mContext.getString(a.h.txt_im_mvp_punish_choose), optString9, optString10);
                } else if (optInt == 2) {
                    optString11 = String.format(this.mContext.getString(a.h.txt_im_mvp_punish_letoff), optString9);
                } else if (optInt == 3) {
                    optString11 = String.format(this.mContext.getString(a.h.txt_im_mvp_punish_notchoose), optString9, optString10);
                } else if (optInt != 4) {
                    optString11 = str11;
                }
                if (optString11 == null) {
                    optString11 = "";
                }
                SpannableString valueOf8 = SpannableString.valueOf(optString11);
                valueOf8.setSpan(new ForegroundColorSpan(-5864), 0, optString11.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf8);
                com.baidu.live.view.b bVar14 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_pk);
                SpannableStringBuilder spannableStringBuilder14 = new SpannableStringBuilder("  ");
                spannableStringBuilder14.setSpan(bVar14, 0, 1, 33);
                spannableStringBuilder.insert(0, (CharSequence) spannableStringBuilder14);
            } else if (jSONObject5 != null && "challenge_winner_by_autofail".equals(str9)) {
                if (TextUtils.isEmpty(str8)) {
                    str8 = this.mContext.getString(a.h.ala_challenge_winner_by_autofail);
                }
                SpannableString valueOf9 = SpannableString.valueOf(str8);
                valueOf9.setSpan(new ForegroundColorSpan(-5864), 0, str8.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf9, 0, str8.length());
                com.baidu.live.view.b bVar15 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_pk);
                SpannableStringBuilder spannableStringBuilder15 = new SpannableStringBuilder("  ");
                spannableStringBuilder15.setSpan(bVar15, 0, 1, 33);
                spannableStringBuilder.insert(0, (CharSequence) spannableStringBuilder15);
            } else if ("wish_list_success".equals(str9) || "wish_list_finish".equals(str9)) {
                com.baidu.live.view.b bVar16 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_xinyuan);
                SpannableStringBuilder spannableStringBuilder16 = new SpannableStringBuilder("  ");
                spannableStringBuilder16.setSpan(bVar16, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder16);
                SpannableString valueOf10 = SpannableString.valueOf(str8);
                valueOf10.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf10.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf10);
                if (!this.bns) {
                    com.baidu.live.view.b bVar17 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_zhuli);
                    SpannableStringBuilder spannableStringBuilder17 = new SpannableStringBuilder("  ");
                    spannableStringBuilder17.setSpan(bVar17, 1, 2, 33);
                    spannableStringBuilder.insert(spannableStringBuilder.length(), (CharSequence) spannableStringBuilder17);
                }
                spannableStringBuilder.setSpan(new a(this.mContext, bVar.getLink(), str9), 0, spannableStringBuilder.length(), 33);
            } else if ("start_grab_wheel".equals(str9)) {
                com.baidu.live.view.b bVar18 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_zhuanpan);
                SpannableStringBuilder spannableStringBuilder18 = new SpannableStringBuilder("  ");
                spannableStringBuilder18.setSpan(bVar18, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder18);
                spannableStringBuilder.append(com.baidu.live.utils.g.G(this.mContext.getString(a.h.ala_lucky_tab_tips2), -7479041));
                a(spannableStringBuilder, bVar.NU(), cVar, false, false);
                cj(false);
                String str18 = "";
                String str19 = "";
                String str20 = "";
                if (jSONObject6 != null) {
                    str18 = jSONObject6.optString(LogConfig.LOG_AMOUNT);
                    str19 = jSONObject6.optString("keywords");
                    str20 = jSONObject6.optString("gift_url");
                }
                spannableStringBuilder.append(com.baidu.live.utils.g.G(String.format(this.mContext.getString(a.h.ala_lucky_tab_tips), str18, str19), -7479041));
                AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                alaLiveMarkData.mark_pic = str20;
                com.baidu.live.view.b bVar19 = new com.baidu.live.view.b(this.mContext, alaLiveMarkData, false, null);
                SpannableStringBuilder spannableStringBuilder19 = new SpannableStringBuilder("  ");
                spannableStringBuilder19.setSpan(bVar19, 1, 2, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder19);
            } else if (TextUtils.equals("guard_club_join", str9)) {
                com.baidu.live.view.b bVar20 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_zhenai);
                SpannableStringBuilder spannableStringBuilder20 = new SpannableStringBuilder("  ");
                spannableStringBuilder20.setSpan(bVar20, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder20);
                spannableStringBuilder.append(com.baidu.live.utils.g.G(this.mContext.getString(a.h.ala_guard_club_join_welcome), -7479041));
                a(spannableStringBuilder, bVar.NU(), cVar, false, false);
                cj(false);
                spannableStringBuilder.append(com.baidu.live.utils.g.G(this.mContext.getString(a.h.ala_guard_club_join), -7479041));
                if (!this.bns) {
                    com.baidu.live.view.b bVar21 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_jiaru);
                    SpannableStringBuilder spannableStringBuilder21 = new SpannableStringBuilder("  ");
                    spannableStringBuilder21.setSpan(bVar21, 1, 2, 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder21);
                }
                spannableStringBuilder.setSpan(new a(this.mContext, bVar.getLink(), str9), 0, spannableStringBuilder.length(), 33);
            } else if (jSONObject5 != null && TextUtils.equals(str9, "privilege_award_royal_success")) {
                final String optString12 = jSONObject5.optString("icon_url");
                this.bnS = optString12;
                if (!TextUtils.isEmpty(optString12)) {
                    new AlaLiveMarkData().mark_pic = optString12;
                    BdResourceLoader.getInstance().loadResource(optString12, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.im.a.d.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                        public void onLoaded(BdImage bdImage, String str21, int i5) {
                            super.onLoaded((AnonymousClass1) bdImage, str21, i5);
                            Bitmap a2 = d.this.a(bdImage);
                            if (a2 != null && TextUtils.equals(d.this.bnS, optString12)) {
                                CenteredImageSpan centeredImageSpan = new CenteredImageSpan(d.this.mContext, a2);
                                SpannableString spannableString = new SpannableString("[img] ");
                                spannableString.setSpan(centeredImageSpan, 0, spannableString.length() - 1, 33);
                                spannableStringBuilder.insert(0, (CharSequence) spannableString);
                                cVar.bkf.setText(spannableStringBuilder);
                                cVar.bkf.forceLayout();
                            }
                        }
                    }, null);
                }
                a(spannableStringBuilder, bVar.NU(), cVar, false, false);
                cj(false);
                int optInt2 = jSONObject5.optInt("royal_level");
                String str21 = "";
                if (optInt2 >= 0 && optInt2 <= 7) {
                    str21 = AlaLiveMarkData.NOBLE_LEVEL_NAMES[optInt2];
                }
                if (TextUtils.equals(bVar.NU().userId, TbadkCoreApplication.getCurrentAccount())) {
                    format = String.format(this.mContext.getString(a.h.txt_im_noble_update_mine), str21);
                } else {
                    format = String.format(this.mContext.getString(a.h.txt_im_noble_update), str21);
                }
                spannableStringBuilder.append(com.baidu.live.utils.g.G(format, -5864));
            } else if (TextUtils.equals("haokan_buy_goods", str9)) {
                com.baidu.live.view.b bVar22 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_viewer_shopping);
                SpannableStringBuilder spannableStringBuilder22 = new SpannableStringBuilder("  ");
                spannableStringBuilder22.setSpan(bVar22, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder22);
                spannableStringBuilder.append(com.baidu.live.utils.g.G(str8, -1));
            } else if (jSONObject5 != null && "activity_gift".equals(str9)) {
                JSONObject optJSONObject = jSONObject5.optJSONObject("content_data");
                a(spannableStringBuilder, bVar.NU(), cVar, false, false);
                if (optJSONObject != null) {
                    String optString13 = optJSONObject.optString("giftName");
                    String str22 = optJSONObject.optInt("giftNumber") + " ";
                    String optString14 = optJSONObject.optString("giftPic");
                    String str23 = optJSONObject.optDouble("multipleTime") + "";
                    String optString15 = optJSONObject.optString("multipleName");
                    String optString16 = optJSONObject.optString("firstText");
                    String optString17 = optJSONObject.optString("secondText");
                    String optString18 = optJSONObject.optString("span_text_color");
                    String optString19 = optJSONObject.optString("span_color_start");
                    String optString20 = optJSONObject.optString("span_color_end");
                    SpannableString valueOf11 = SpannableString.valueOf(optString16 + optString13);
                    if (!TextUtils.isEmpty(optString16)) {
                        valueOf11.setSpan(new ForegroundColorSpan(-5864), 0, valueOf11.length(), 33);
                    }
                    spannableStringBuilder.append((CharSequence) valueOf11);
                    if (!TextUtils.isEmpty(optString14)) {
                        AlaLiveMarkData alaLiveMarkData2 = new AlaLiveMarkData();
                        alaLiveMarkData2.mark_pic = optString14;
                        alaLiveMarkData2.isWidthAutoFit = true;
                        com.baidu.live.view.b bVar23 = new com.baidu.live.view.b(this.mContext, alaLiveMarkData2, false, new b.a() { // from class: com.baidu.live.im.a.d.10
                            @Override // com.baidu.live.view.b.a
                            public void d(Bitmap bitmap) {
                                cVar.bkf.forceLayout();
                            }

                            @Override // com.baidu.live.view.b.a
                            public void a(com.baidu.live.view.b bVar24, Bitmap bitmap) {
                            }
                        });
                        SpannableStringBuilder spannableStringBuilder23 = new SpannableStringBuilder(" [img]");
                        spannableStringBuilder23.setSpan(bVar23, 1, spannableStringBuilder23.length(), 33);
                        spannableStringBuilder.append((CharSequence) spannableStringBuilder23);
                    }
                    if (!TextUtils.isEmpty(str22)) {
                        SpannableString valueOf12 = SpannableString.valueOf("X" + str22);
                        valueOf12.setSpan(new ForegroundColorSpan(-5864), 0, valueOf12.length(), 33);
                        spannableStringBuilder.append((CharSequence) valueOf12);
                    }
                    if (!TextUtils.isEmpty(optString17)) {
                        SpannableString valueOf13 = SpannableString.valueOf(optString17);
                        valueOf13.setSpan(new ForegroundColorSpan(-5864), 0, valueOf13.length(), 33);
                        spannableStringBuilder.append((CharSequence) valueOf13);
                    }
                    if (!TextUtils.isEmpty(str23) && !TextUtils.isEmpty(optString15) && !TextUtils.isEmpty(optString20)) {
                        com.baidu.live.im.view.b bVar24 = new com.baidu.live.im.view.b(this.mContext, str23 + "倍" + optString15, false, true, true, optString19, optString20, optString18);
                        SpannableString spannableString = new SpannableString(" rate");
                        spannableString.setSpan(bVar24, 1, spannableString.length(), 33);
                        spannableStringBuilder.append((CharSequence) spannableString);
                    } else if (!TextUtils.isEmpty(str23) && !TextUtils.isEmpty(optString15)) {
                        com.baidu.live.im.view.b bVar25 = new com.baidu.live.im.view.b(this.mContext, str23 + "倍" + optString15, true, false, true);
                        SpannableString spannableString2 = new SpannableString(" rate");
                        spannableString2.setSpan(bVar25, 1, spannableString2.length(), 33);
                        spannableStringBuilder.append((CharSequence) spannableString2);
                    }
                }
            } else if (jSONObject5 != null && "activity_common_im".equals(str9)) {
                JSONObject optJSONObject2 = jSONObject5.optJSONObject("content_data");
                int optInt3 = optJSONObject2.optInt("is_jump");
                String optString21 = optJSONObject2.optString("left_icon");
                JSONArray optJSONArray = optJSONObject2.optJSONArray("text_array");
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("text_color_array");
                if (!TextUtils.isEmpty(optString21)) {
                    AlaLiveMarkData alaLiveMarkData3 = new AlaLiveMarkData();
                    alaLiveMarkData3.mark_pic = optString21;
                    alaLiveMarkData3.isWidthAutoFit = true;
                    com.baidu.live.view.b bVar26 = new com.baidu.live.view.b(this.mContext, alaLiveMarkData3, false, new b.a() { // from class: com.baidu.live.im.a.d.11
                        @Override // com.baidu.live.view.b.a
                        public void d(Bitmap bitmap) {
                            cVar.bkf.forceLayout();
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
                    for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                        try {
                            String trim = optJSONArray2.getString(i5).trim();
                            String string3 = optJSONArray.getString(i5);
                            int parseColor = Color.parseColor(trim);
                            SpannableString valueOf14 = SpannableString.valueOf(string3);
                            valueOf14.setSpan(new ForegroundColorSpan(parseColor), 0, valueOf14.length(), 33);
                            spannableStringBuilder.append((CharSequence) valueOf14);
                        } catch (JSONException e10) {
                            e10.printStackTrace();
                        }
                    }
                    if (optJSONObject3 != null) {
                        String optString22 = optJSONObject3.optString("title");
                        String trim2 = optJSONObject3.optString("title_color").trim();
                        String optString23 = optJSONObject3.optString("url");
                        String trim3 = optJSONObject3.optString("bg").trim();
                        String optString24 = optJSONObject3.optString("screen");
                        if (optInt3 == 1 && !TextUtils.isEmpty(optString22) && !TextUtils.isEmpty(optString23)) {
                            com.baidu.live.im.view.b bVar27 = new com.baidu.live.im.view.b(this.mContext, optString22 + " >", false, true, trim3, trim3, trim2);
                            SpannableString spannableString3 = new SpannableString(" click");
                            spannableString3.setSpan(bVar27, 1, spannableString3.length(), 33);
                            spannableStringBuilder.append((CharSequence) spannableString3);
                            a aVar2 = new a(this.mContext, optString23, optString24, str9);
                            aVar2.setClickable(true);
                            spannableStringBuilder.setSpan(aVar2, 0, spannableStringBuilder.length(), 33);
                        }
                    }
                }
            } else if (jSONObject5 != null && "activity_notice".equals(str9)) {
                jSONObject5.optInt("open");
                try {
                    jSONObject7 = new JSONObject(str8);
                } catch (JSONException e11) {
                    e11.printStackTrace();
                    jSONObject7 = null;
                }
                if (jSONObject7 != null) {
                    JSONObject optJSONObject4 = jSONObject7.optJSONObject("extra");
                    JSONObject optJSONObject5 = optJSONObject4.optJSONObject(TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
                    String optString25 = optJSONObject4.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                    String optString26 = optJSONObject4.optString("text");
                    String optString27 = optJSONObject5.optString("name");
                    String optString28 = optJSONObject5.optString("url");
                    String optString29 = optJSONObject5.optString("screen");
                    SpannableString valueOf15 = SpannableString.valueOf(" " + optString26);
                    if (!TextUtils.isEmpty(optString25)) {
                        AlaLiveMarkData alaLiveMarkData4 = new AlaLiveMarkData();
                        alaLiveMarkData4.mark_pic = optString25;
                        alaLiveMarkData4.isWidthAutoFit = true;
                        com.baidu.live.view.b bVar28 = new com.baidu.live.view.b(this.mContext, alaLiveMarkData4, false, new b.a() { // from class: com.baidu.live.im.a.d.12
                            @Override // com.baidu.live.view.b.a
                            public void d(Bitmap bitmap) {
                                cVar.bkf.forceLayout();
                            }

                            @Override // com.baidu.live.view.b.a
                            public void a(com.baidu.live.view.b bVar29, Bitmap bitmap) {
                            }
                        });
                        SpannableStringBuilder spannableStringBuilder25 = new SpannableStringBuilder("[img]");
                        spannableStringBuilder25.setSpan(bVar28, 0, spannableStringBuilder25.length(), 33);
                        spannableStringBuilder.append((CharSequence) spannableStringBuilder25);
                    }
                    valueOf15.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf15.length(), 33);
                    spannableStringBuilder.append((CharSequence) valueOf15);
                    if (!TextUtils.isEmpty(optString28)) {
                        com.baidu.live.im.view.b bVar29 = new com.baidu.live.im.view.b(this.mContext, optString27 + " >", false, true, "#FFF5F5F5", "#FFF5F5F5", "#FFA3A3A3");
                        SpannableString spannableString4 = new SpannableString("url");
                        spannableString4.setSpan(bVar29, 0, spannableString4.length(), 33);
                        spannableStringBuilder.append((CharSequence) spannableString4);
                        a aVar3 = new a(this.mContext, optString28, optString29, str9);
                        aVar3.setClickable(true);
                        spannableStringBuilder.setSpan(aVar3, 0, spannableStringBuilder.length(), 33);
                    }
                }
            } else if (jSONObject5 != null && "live_notice_quick_chat".equals(str9)) {
                SpannableString valueOf16 = SpannableString.valueOf(str8 + " ");
                valueOf16.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf16.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf16);
                com.baidu.live.view.b bVar30 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_quliaotian);
                SpannableStringBuilder spannableStringBuilder26 = new SpannableStringBuilder(" ");
                spannableStringBuilder26.setSpan(bVar30, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder26);
                if (!TextUtils.isEmpty(str7)) {
                    a aVar4 = new a(this.mContext, true, str7, str9);
                    aVar4.setClickable(true);
                    spannableStringBuilder.setSpan(aVar4, 0, spannableStringBuilder.length(), 33);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "gochat_show").setContentExt(null, null, null));
            } else if (jSONObject5 != null && "remove_video".equals(str9)) {
                if (bVar.NU() != null) {
                    String optString30 = jSONObject5.optString("poke_user_nickname", "");
                    String optString31 = jSONObject5.optString("poke_text", "");
                    String optString32 = jSONObject5.optString("charm_user_id", "");
                    if (TbadkCoreApplication.getCurrentAccount().equals(jSONObject5.optString("poke_user_id", ""))) {
                        a(spannableStringBuilder, bVar.NU(), cVar, false, false);
                        spannableStringBuilder.append(com.baidu.live.utils.g.G(optString31 + this.mContext.getString(a.h.sdk_string_you) + "  ", -9395));
                        com.baidu.live.view.b bVar31 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_huichuo);
                        SpannableStringBuilder spannableStringBuilder27 = new SpannableStringBuilder(" ");
                        spannableStringBuilder27.setSpan(bVar31, 0, 1, 33);
                        spannableStringBuilder.append((CharSequence) spannableStringBuilder27);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913267, jSONObject5.toString()));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913263, false));
                        a aVar5 = new a(this.mContext, true, jSONObject5.toString(), "live_poke_back");
                        aVar5.setClickable(true);
                        spannableStringBuilder.setSpan(aVar5, 0, spannableStringBuilder.length(), 33);
                    } else if (TbadkCoreApplication.getCurrentAccount().equals(optString32)) {
                        bVar.NU().name_show = this.mContext.getString(a.h.sdk_string_you);
                        a(spannableStringBuilder, bVar.NU(), cVar, false, false);
                        spannableStringBuilder.append(com.baidu.live.utils.g.G(optString31 + optString30, -9395));
                    } else {
                        a(spannableStringBuilder, bVar.NU(), cVar, false, false);
                        spannableStringBuilder.append(com.baidu.live.utils.g.G(optString31 + optString30, -9395));
                    }
                }
            } else if (jSONObject5 != null && "live_poke_back".equals(str9)) {
                if (bVar.NU() != null) {
                    String optString33 = jSONObject5.optString("poke_text", "");
                    boolean z5 = jSONObject5.optInt("is_gift", 1) == 1;
                    String optString34 = jSONObject5.optString("gift_name", "");
                    String optString35 = jSONObject5.optString("charm_user_id", "");
                    if (TbadkCoreApplication.getCurrentAccount().equals(jSONObject5.optString("poke_user_id", ""))) {
                        bVar.NU().name_show = this.mContext.getString(a.h.sdk_string_you);
                        a(spannableStringBuilder, bVar.NU(), cVar, false, false);
                        String str24 = optString33 + this.mContext.getString(a.h.sdk_string_host_user);
                        if (z5) {
                            str24 = str24 + this.mContext.getString(a.h.sdk_poke_send_gift) + optString34;
                        }
                        spannableStringBuilder.append(com.baidu.live.utils.g.G(str24, -9395));
                    } else if (TbadkCoreApplication.getCurrentAccount().equals(optString35)) {
                        a(spannableStringBuilder, bVar.NU(), cVar, false, false);
                        String str25 = optString33 + this.mContext.getString(a.h.sdk_string_you);
                        if (z5) {
                            str25 = str25 + this.mContext.getString(a.h.sdk_poke_send_gift) + optString34;
                        }
                        spannableStringBuilder.append(com.baidu.live.utils.g.G(str25, -9395));
                    } else {
                        a(spannableStringBuilder, bVar.NU(), cVar, false, false);
                        String str26 = optString33 + this.mContext.getString(a.h.sdk_string_host_user);
                        if (z5) {
                            str26 = str26 + this.mContext.getString(a.h.sdk_poke_send_gift) + optString34;
                        }
                        spannableStringBuilder.append(com.baidu.live.utils.g.G(str26, -9395));
                    }
                }
            } else if (jSONObject5 != null && "custom_gift".equals(str9)) {
                a(spannableStringBuilder, bVar.NU(), cVar, false, false);
                f v = v(bVar);
                String str27 = "送出的" + ((v == null || TextUtils.isEmpty(v.giftName)) ? this.mContext.getString(a.h.sdk_gift) : v.giftName);
                SpannableString valueOf17 = SpannableString.valueOf(str27);
                if (str27 != null) {
                    valueOf17.setSpan(new ForegroundColorSpan(-5864), 0, valueOf17.length(), 33);
                }
                spannableStringBuilder.append((CharSequence) valueOf17);
                if (v != null && !TextUtils.isEmpty(v.aWS)) {
                    AlaLiveMarkData alaLiveMarkData5 = new AlaLiveMarkData();
                    alaLiveMarkData5.mark_pic = v.aWS;
                    alaLiveMarkData5.isWidthAutoFit = true;
                    com.baidu.live.view.b bVar32 = new com.baidu.live.view.b(this.mContext, alaLiveMarkData5, false, new b.a() { // from class: com.baidu.live.im.a.d.13
                        @Override // com.baidu.live.view.b.a
                        public void d(Bitmap bitmap) {
                            cVar.bkf.forceLayout();
                        }

                        @Override // com.baidu.live.view.b.a
                        public void a(com.baidu.live.view.b bVar33, Bitmap bitmap) {
                        }
                    });
                    SpannableStringBuilder spannableStringBuilder28 = new SpannableStringBuilder(" [img]");
                    spannableStringBuilder28.setSpan(bVar32, 1, spannableStringBuilder28.length(), 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder28);
                }
                a(spannableStringBuilder, v);
            } else if (jSONObject5 != null && "pk_first_blood".equals(str9)) {
                JSONObject optJSONObject6 = jSONObject5.optJSONObject("first_blood_info");
                String str28 = bVar.NU().name_show;
                if (optJSONObject6 != null) {
                    String optString36 = optJSONObject6.optString("front_text");
                    String optString37 = optJSONObject6.optString("behind_text");
                    final String optString38 = optJSONObject6.optString("icon_url");
                    this.bnS = optString38;
                    if (!TextUtils.isEmpty(optString38)) {
                        new AlaLiveMarkData().mark_pic = optString38;
                        BdResourceLoader.getInstance().loadResource(optString38, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.im.a.d.14
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                            public void onLoaded(BdImage bdImage, String str29, int i6) {
                                super.onLoaded((AnonymousClass14) bdImage, str29, i6);
                                Bitmap a2 = d.this.a(bdImage);
                                if (a2 != null && TextUtils.equals(d.this.bnS, optString38)) {
                                    CenteredImageSpan centeredImageSpan = new CenteredImageSpan(d.this.mContext, a2);
                                    SpannableString spannableString5 = new SpannableString("[img] ");
                                    spannableString5.setSpan(centeredImageSpan, 0, spannableString5.length() - 1, 33);
                                    spannableStringBuilder.insert(0, (CharSequence) spannableString5);
                                    cVar.bkf.setText(spannableStringBuilder);
                                    cVar.bkf.forceLayout();
                                }
                            }
                        }, null);
                    }
                    SpannableString valueOf18 = SpannableString.valueOf(optString36 + str28 + optString37);
                    ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(-5462);
                    ForegroundColorSpan foregroundColorSpan3 = new ForegroundColorSpan(-7479041);
                    valueOf18.setSpan(new ForegroundColorSpan(-7479041), 0, optString36.length(), 33);
                    valueOf18.setSpan(foregroundColorSpan2, optString36.length(), optString36.length() + str28.length(), 33);
                    valueOf18.setSpan(foregroundColorSpan3, str28.length() + optString36.length(), valueOf18.length(), 33);
                    spannableStringBuilder.append((CharSequence) valueOf18);
                }
            } else if (str9 != null && jSONObject5 != null && "pk_send_props".equals(str9)) {
                final String optString39 = jSONObject5.optString("pk_image_url");
                String optString40 = jSONObject5.optString("props_belong_text");
                String str29 = bVar.NU().name_show;
                String optString41 = jSONObject5.optString("gift_name");
                final String optString42 = jSONObject5.optString("gift_url");
                String optString43 = jSONObject5.optString("props_text");
                this.bnS = optString39;
                this.bnT = optString42;
                if (!TextUtils.isEmpty(optString39)) {
                    new AlaLiveMarkData().mark_pic = optString39;
                    BdResourceLoader.getInstance().loadResource(optString39, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.im.a.d.15
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                        public void onLoaded(BdImage bdImage, String str30, int i6) {
                            super.onLoaded((AnonymousClass15) bdImage, str30, i6);
                            Bitmap a2 = d.this.a(bdImage);
                            if (a2 != null && TextUtils.equals(d.this.bnS, optString39)) {
                                CenteredImageSpan centeredImageSpan = new CenteredImageSpan(d.this.mContext, a2);
                                SpannableString spannableString5 = new SpannableString("[img] ");
                                spannableString5.setSpan(centeredImageSpan, 0, spannableString5.length() - 1, 33);
                                spannableStringBuilder.insert(0, (CharSequence) spannableString5);
                                cVar.bkf.setText(spannableStringBuilder);
                                cVar.bkf.forceLayout();
                            }
                        }
                    }, null);
                }
                SpannableString valueOf19 = SpannableString.valueOf(optString40 + str29);
                if (!TextUtils.isEmpty(valueOf19)) {
                    valueOf19.setSpan(new ForegroundColorSpan(-7479041), 0, optString40.length(), 33);
                    valueOf19.setSpan(new ForegroundColorSpan(-5462), optString40.length(), optString40.length() + str29.length(), 33);
                }
                spannableStringBuilder.append((CharSequence) valueOf19);
                String string4 = this.mContext.getString(a.h.ala_pk_props);
                SpannableString valueOf20 = SpannableString.valueOf(string4 + optString41);
                if (!TextUtils.isEmpty(string4)) {
                    valueOf20.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf20.length(), 33);
                }
                spannableStringBuilder.append((CharSequence) valueOf20);
                final SpannableString valueOf21 = SpannableString.valueOf("," + optString43);
                if (!TextUtils.isEmpty(valueOf21)) {
                    valueOf21.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf21.length(), 33);
                }
                spannableStringBuilder.append((CharSequence) valueOf21);
                if (!TextUtils.isEmpty(optString42)) {
                    new AlaLiveMarkData().mark_pic = optString42;
                    BdResourceLoader.getInstance().loadResource(optString42, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.im.a.d.16
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                        public void onLoaded(BdImage bdImage, String str30, int i6) {
                            super.onLoaded((AnonymousClass16) bdImage, str30, i6);
                            Bitmap a2 = d.this.a(bdImage);
                            if (a2 != null && TextUtils.equals(d.this.bnT, optString42)) {
                                CenteredImageSpan centeredImageSpan = new CenteredImageSpan(d.this.mContext, a2);
                                SpannableString spannableString5 = new SpannableString("[img] ");
                                spannableString5.setSpan(centeredImageSpan, 0, spannableString5.length() - 1, 33);
                                spannableStringBuilder.insert(spannableStringBuilder.length() - valueOf21.length(), (CharSequence) spannableString5);
                                cVar.bkf.setText(spannableStringBuilder);
                                cVar.bkf.forceLayout();
                            }
                        }
                    }, null);
                }
            } else if (jSONObject5 != null && "pk_mvp_props".equals(str9)) {
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(bVar.NU().userId)) {
                    final String optString44 = jSONObject5.optString("pk_image_url");
                    String str30 = this.mContext.getString(a.h.ala_pk_front_props) + this.mContext.getString(a.h.ala_pk_middle_props) + this.mContext.getString(a.h.ala_pk_behind_props);
                    String optString45 = jSONObject5.optString("props_name");
                    final String optString46 = jSONObject5.optString("props_image_url");
                    String optString47 = jSONObject5.optString("props_text");
                    this.bnS = optString44;
                    this.bnT = optString46;
                    if (!TextUtils.isEmpty(optString44)) {
                        new AlaLiveMarkData().mark_pic = optString44;
                        BdResourceLoader.getInstance().loadResource(optString44, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.im.a.d.17
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                            public void onLoaded(BdImage bdImage, String str31, int i6) {
                                super.onLoaded((AnonymousClass17) bdImage, str31, i6);
                                Bitmap a2 = d.this.a(bdImage);
                                if (a2 != null && TextUtils.equals(d.this.bnS, optString44)) {
                                    CenteredImageSpan centeredImageSpan = new CenteredImageSpan(d.this.mContext, a2);
                                    SpannableString spannableString5 = new SpannableString("[img] ");
                                    spannableString5.setSpan(centeredImageSpan, 0, spannableString5.length() - 1, 33);
                                    spannableStringBuilder.insert(0, (CharSequence) spannableString5);
                                    cVar.bkf.setText(spannableStringBuilder);
                                    cVar.bkf.forceLayout();
                                }
                            }
                        }, null);
                    }
                    SpannableString valueOf22 = SpannableString.valueOf(str30 + optString45);
                    if (!TextUtils.isEmpty(valueOf22)) {
                        valueOf22.setSpan(new ForegroundColorSpan(-7479041), 0, str30.length() + optString45.length(), 33);
                    }
                    spannableStringBuilder.append((CharSequence) valueOf22);
                    final SpannableString valueOf23 = SpannableString.valueOf("," + optString47);
                    if (!TextUtils.isEmpty(valueOf23)) {
                        valueOf23.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf23.length(), 33);
                    }
                    spannableStringBuilder.append((CharSequence) valueOf23);
                    if (!TextUtils.isEmpty(optString46)) {
                        new AlaLiveMarkData().mark_pic = optString46;
                        BdResourceLoader.getInstance().loadResource(optString46, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.im.a.d.2
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                            public void onLoaded(BdImage bdImage, String str31, int i6) {
                                super.onLoaded((AnonymousClass2) bdImage, str31, i6);
                                Bitmap a2 = d.this.a(bdImage);
                                if (a2 != null && TextUtils.equals(d.this.bnT, optString46)) {
                                    CenteredImageSpan centeredImageSpan = new CenteredImageSpan(d.this.mContext, a2);
                                    SpannableString spannableString5 = new SpannableString("[img] ");
                                    spannableString5.setSpan(centeredImageSpan, 0, spannableString5.length() - 1, 33);
                                    spannableStringBuilder.insert(spannableStringBuilder.length() - valueOf23.length(), (CharSequence) spannableString5);
                                    cVar.bkf.setText(spannableStringBuilder);
                                    cVar.bkf.forceLayout();
                                }
                            }
                        }, null);
                    }
                } else {
                    final String optString48 = jSONObject5.optString("pk_image_url");
                    String string5 = this.mContext.getString(a.h.ala_pk_front_props);
                    String optString49 = jSONObject5.optString("user_nickname");
                    String string6 = this.mContext.getString(a.h.ala_pk_behind_props);
                    String optString50 = jSONObject5.optString("props_name");
                    final String optString51 = jSONObject5.optString("props_image_url");
                    this.bnS = optString48;
                    this.bnT = optString51;
                    if (!TextUtils.isEmpty(optString48)) {
                        new AlaLiveMarkData().mark_pic = optString48;
                        BdResourceLoader.getInstance().loadResource(optString48, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.im.a.d.3
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                            public void onLoaded(BdImage bdImage, String str31, int i6) {
                                super.onLoaded((AnonymousClass3) bdImage, str31, i6);
                                Bitmap a2 = d.this.a(bdImage);
                                if (a2 != null && TextUtils.equals(d.this.bnS, optString48)) {
                                    CenteredImageSpan centeredImageSpan = new CenteredImageSpan(d.this.mContext, a2);
                                    SpannableString spannableString5 = new SpannableString("[img] ");
                                    spannableString5.setSpan(centeredImageSpan, 0, spannableString5.length() - 1, 33);
                                    spannableStringBuilder.insert(0, (CharSequence) spannableString5);
                                    cVar.bkf.setText(spannableStringBuilder);
                                    cVar.bkf.forceLayout();
                                }
                            }
                        }, null);
                    }
                    SpannableString valueOf24 = SpannableString.valueOf(string5 + optString49 + string6 + optString50);
                    if (!TextUtils.isEmpty(valueOf24)) {
                        valueOf24.setSpan(new ForegroundColorSpan(-7479041), 0, string5.length(), 33);
                        valueOf24.setSpan(new ForegroundColorSpan(-5462), string5.length(), string5.length() + optString49.length(), 33);
                        valueOf24.setSpan(new ForegroundColorSpan(-7479041), string5.length() + optString49.length(), string5.length() + optString49.length() + string6.length() + optString50.length(), 33);
                    }
                    spannableStringBuilder.append((CharSequence) valueOf24);
                    if (!TextUtils.isEmpty(optString51)) {
                        new AlaLiveMarkData().mark_pic = optString51;
                        BdResourceLoader.getInstance().loadResource(optString51, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.im.a.d.4
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                            public void onLoaded(BdImage bdImage, String str31, int i6) {
                                super.onLoaded((AnonymousClass4) bdImage, str31, i6);
                                Bitmap a2 = d.this.a(bdImage);
                                if (a2 != null && TextUtils.equals(d.this.bnT, optString51)) {
                                    CenteredImageSpan centeredImageSpan = new CenteredImageSpan(d.this.mContext, a2);
                                    SpannableString spannableString5 = new SpannableString("[img] ");
                                    spannableString5.setSpan(centeredImageSpan, 0, spannableString5.length() - 1, 33);
                                    spannableStringBuilder.insert(spannableStringBuilder.length(), (CharSequence) spannableString5);
                                    cVar.bkf.setText(spannableStringBuilder);
                                    cVar.bkf.forceLayout();
                                }
                            }
                        }, null);
                    }
                }
            } else if (jSONObject5 != null && str9.equals("tying_gift")) {
                jSONObject5.optString("pay_username");
                String optString52 = jSONObject5.optString("tying_gift_name");
                int optInt4 = jSONObject5.optInt("tying_status");
                JSONArray optJSONArray3 = jSONObject5.optJSONArray("gift_member");
                a(spannableStringBuilder, bVar.NU(), cVar, false, false);
                if (optJSONArray3 != null) {
                    int i6 = 0;
                    for (int i7 = 0; i7 < optJSONArray3.length(); i7++) {
                        String optString53 = optJSONArray3.optJSONObject(i7).optString(LogConfig.VALUE_IM_GIFT);
                        if (optString53 != null && optString53.equals("1")) {
                            i6++;
                        }
                    }
                    if (optInt4 == 0) {
                        String string7 = this.mContext.getString(a.h.ala_middle_context);
                        SpannableString valueOf25 = SpannableString.valueOf(string7);
                        if (!TextUtils.isEmpty(valueOf25)) {
                            valueOf25.setSpan(new ForegroundColorSpan(-5864), 0, string7.length(), 33);
                        }
                        spannableStringBuilder.append((CharSequence) valueOf25);
                        SpannableString valueOf26 = SpannableString.valueOf(" " + optString52 + " ");
                        if (!TextUtils.isEmpty(valueOf26)) {
                            valueOf26.setSpan(new ForegroundColorSpan(-5864), 0, valueOf26.length(), 33);
                        }
                        spannableStringBuilder.append((CharSequence) valueOf26);
                        SpannableString valueOf27 = SpannableString.valueOf(this.mContext.getString(a.h.ala_tying_gift));
                        if (!TextUtils.isEmpty(valueOf27)) {
                            valueOf27.setSpan(new ForegroundColorSpan(-5864), 0, valueOf27.length(), 33);
                        }
                        spannableStringBuilder.append((CharSequence) valueOf27);
                        SpannableString valueOf28 = SpannableString.valueOf(i6 + "/" + optJSONArray3.length());
                        if (!TextUtils.isEmpty(valueOf28)) {
                            valueOf28.setSpan(new ForegroundColorSpan(-5864), 0, valueOf28.length(), 33);
                        }
                        spannableStringBuilder.append((CharSequence) valueOf28);
                    } else {
                        String string8 = this.mContext.getString(a.h.ala_tying_gift_middle);
                        SpannableString valueOf29 = SpannableString.valueOf(string8);
                        if (!TextUtils.isEmpty(valueOf29)) {
                            valueOf29.setSpan(new ForegroundColorSpan(-5864), 0, string8.length(), 33);
                        }
                        spannableStringBuilder.append((CharSequence) valueOf29);
                        SpannableString valueOf30 = SpannableString.valueOf(" " + optString52 + " ");
                        if (!TextUtils.isEmpty(valueOf30)) {
                            valueOf30.setSpan(new ForegroundColorSpan(-5864), 0, valueOf30.length(), 33);
                        }
                        spannableStringBuilder.append((CharSequence) valueOf30);
                        SpannableString valueOf31 = SpannableString.valueOf(this.mContext.getString(a.h.ala_tying_gift_behind));
                        if (!TextUtils.isEmpty(valueOf31)) {
                            valueOf31.setSpan(new ForegroundColorSpan(-5864), 0, valueOf31.length(), 33);
                        }
                        spannableStringBuilder.append((CharSequence) valueOf31);
                    }
                }
            } else if (jSONObject5 != null && str9.equals("luckybag_win_prize")) {
                String optString54 = jSONObject5.optString("user_name");
                String optString55 = jSONObject5.optString("user_nickname");
                if (optString55 == null || optString55.isEmpty()) {
                    optString55 = optString54;
                }
                String str31 = " " + this.mContext.getString(a.h.ala_pk_front_props);
                String str32 = " " + this.mContext.getString(a.h.ala_luckybag_send);
                String string9 = this.mContext.getString(a.h.ala_luckybag_open);
                JSONObject optJSONObject7 = jSONObject5.optJSONObject("ext_data");
                if (optJSONObject7 != null && optJSONObject7.length() != 0) {
                    e eVar = new e();
                    eVar.bof = optJSONObject7.optInt("lucky_bag_id");
                    eVar.bog = optJSONObject7.optString("lucky_bag_name");
                    eVar.boi = optJSONObject7.optInt("prize_total_value");
                    eVar.boh = optJSONObject7.optString("lucky_bag_img");
                    eVar.buttonText = optJSONObject7.optString("button_text");
                    if (!TextUtils.isEmpty(eVar.boh)) {
                        AlaLiveMarkData alaLiveMarkData6 = new AlaLiveMarkData();
                        alaLiveMarkData6.mark_pic = eVar.boh;
                        alaLiveMarkData6.isWidthAutoFit = true;
                        com.baidu.live.view.b bVar33 = new com.baidu.live.view.b(this.mContext, alaLiveMarkData6, false, new b.a() { // from class: com.baidu.live.im.a.d.5
                            @Override // com.baidu.live.view.b.a
                            public void d(Bitmap bitmap) {
                                cVar.bkf.forceLayout();
                            }

                            @Override // com.baidu.live.view.b.a
                            public void a(com.baidu.live.view.b bVar34, Bitmap bitmap) {
                            }
                        });
                        SpannableStringBuilder spannableStringBuilder29 = new SpannableStringBuilder("[img]");
                        spannableStringBuilder29.setSpan(bVar33, 0, spannableStringBuilder29.length(), 33);
                        spannableStringBuilder.append((CharSequence) spannableStringBuilder29);
                    }
                    SpannableString valueOf32 = SpannableString.valueOf(str31 + optString55 + str32 + eVar.bog + string9 + " ");
                    if (!TextUtils.isEmpty(valueOf32)) {
                        valueOf32.setSpan(new ForegroundColorSpan(-7479041), 0, str31.length(), 33);
                        valueOf32.setSpan(new ForegroundColorSpan(-5462), str31.length(), str31.length() + optString55.length(), 33);
                        valueOf32.setSpan(new ForegroundColorSpan(-7479041), optString55.length() + str31.length(), valueOf32.length(), 33);
                    }
                    spannableStringBuilder.append((CharSequence) valueOf32);
                    eVar.parserJson(optJSONObject7);
                    if (eVar.bok == null || eVar.bok.length == 0) {
                        i2 = 0;
                    } else {
                        int length = 0 + eVar.bok.length;
                        SpannableString valueOf33 = SpannableString.valueOf(this.mContext.getString(a.h.ala_luckybag_open_surprise) + " ");
                        valueOf33.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf33.length(), 33);
                        spannableStringBuilder.append((CharSequence) valueOf33);
                        for (int i8 = 0; i8 < eVar.bok.length; i8++) {
                            SpannableString valueOf34 = SpannableString.valueOf(eVar.bok[i8].getGiftName());
                            if (!TextUtils.isEmpty(valueOf34)) {
                                valueOf34.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf34.length(), 33);
                            }
                            spannableStringBuilder.append((CharSequence) valueOf34);
                            if (!TextUtils.isEmpty(eVar.bok[i8].NG())) {
                                AlaLiveMarkData alaLiveMarkData7 = new AlaLiveMarkData();
                                alaLiveMarkData7.mark_pic = eVar.bok[i8].NG();
                                alaLiveMarkData7.isWidthAutoFit = true;
                                com.baidu.live.view.b bVar34 = new com.baidu.live.view.b(this.mContext, alaLiveMarkData7, false, new b.a() { // from class: com.baidu.live.im.a.d.6
                                    @Override // com.baidu.live.view.b.a
                                    public void d(Bitmap bitmap) {
                                        cVar.bkf.forceLayout();
                                    }

                                    @Override // com.baidu.live.view.b.a
                                    public void a(com.baidu.live.view.b bVar35, Bitmap bitmap) {
                                    }
                                });
                                SpannableStringBuilder spannableStringBuilder30 = new SpannableStringBuilder("[img]");
                                spannableStringBuilder30.setSpan(bVar34, 0, spannableStringBuilder30.length(), 33);
                                spannableStringBuilder.append((CharSequence) spannableStringBuilder30);
                            }
                            SpannableString valueOf35 = SpannableString.valueOf("x" + eVar.bok[i8].NF() + "，");
                            if (!TextUtils.isEmpty(valueOf35)) {
                                valueOf35.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf35.length(), 33);
                            }
                            spannableStringBuilder.append((CharSequence) valueOf35);
                        }
                        i2 = length;
                    }
                    if (eVar.boj != null && eVar.boj.length != 0) {
                        if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(bVar.NU().userId)) {
                            for (int i9 = 0; i9 < eVar.boj.length; i9++) {
                                SpannableString valueOf36 = SpannableString.valueOf(eVar.boj[i9].getGiftName());
                                valueOf36.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf36.length(), 33);
                                spannableStringBuilder.append((CharSequence) valueOf36);
                                if (!TextUtils.isEmpty(eVar.boj[i9].NG())) {
                                    AlaLiveMarkData alaLiveMarkData8 = new AlaLiveMarkData();
                                    alaLiveMarkData8.mark_pic = eVar.boj[i9].NG();
                                    alaLiveMarkData8.isWidthAutoFit = true;
                                    com.baidu.live.view.b bVar35 = new com.baidu.live.view.b(this.mContext, alaLiveMarkData8, false, new b.a() { // from class: com.baidu.live.im.a.d.7
                                        @Override // com.baidu.live.view.b.a
                                        public void d(Bitmap bitmap) {
                                            cVar.bkf.forceLayout();
                                        }

                                        @Override // com.baidu.live.view.b.a
                                        public void a(com.baidu.live.view.b bVar36, Bitmap bitmap) {
                                        }
                                    });
                                    SpannableStringBuilder spannableStringBuilder31 = new SpannableStringBuilder("[img]");
                                    spannableStringBuilder31.setSpan(bVar35, 0, spannableStringBuilder31.length(), 33);
                                    spannableStringBuilder.append((CharSequence) spannableStringBuilder31);
                                }
                                SpannableString valueOf37 = SpannableString.valueOf("x" + eVar.boj[i9].NF() + "，");
                                if (!TextUtils.isEmpty(valueOf37)) {
                                    valueOf37.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf37.length(), 33);
                                }
                                spannableStringBuilder.append((CharSequence) valueOf37);
                            }
                        } else if (i2 < 3) {
                            if (eVar.boj.length <= 3 - i2) {
                                for (int i10 = 0; i10 < eVar.boj.length; i10++) {
                                    SpannableString valueOf38 = SpannableString.valueOf(eVar.boj[i10].getGiftName());
                                    valueOf38.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf38.length(), 33);
                                    spannableStringBuilder.append((CharSequence) valueOf38);
                                    if (!TextUtils.isEmpty(eVar.boj[i10].NG())) {
                                        AlaLiveMarkData alaLiveMarkData9 = new AlaLiveMarkData();
                                        alaLiveMarkData9.mark_pic = eVar.boj[i10].NG();
                                        alaLiveMarkData9.isWidthAutoFit = true;
                                        com.baidu.live.view.b bVar36 = new com.baidu.live.view.b(this.mContext, alaLiveMarkData9, false, new b.a() { // from class: com.baidu.live.im.a.d.8
                                            @Override // com.baidu.live.view.b.a
                                            public void d(Bitmap bitmap) {
                                                cVar.bkf.forceLayout();
                                            }

                                            @Override // com.baidu.live.view.b.a
                                            public void a(com.baidu.live.view.b bVar37, Bitmap bitmap) {
                                            }
                                        });
                                        SpannableStringBuilder spannableStringBuilder32 = new SpannableStringBuilder("[img]");
                                        spannableStringBuilder32.setSpan(bVar36, 0, spannableStringBuilder32.length(), 33);
                                        spannableStringBuilder.append((CharSequence) spannableStringBuilder32);
                                    }
                                    SpannableString valueOf39 = SpannableString.valueOf("x" + eVar.boj[i10].NF() + "，");
                                    if (!TextUtils.isEmpty(valueOf39)) {
                                        valueOf39.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf39.length(), 33);
                                    }
                                    spannableStringBuilder.append((CharSequence) valueOf39);
                                }
                            } else {
                                for (int i11 = 0; i11 < 3 - i2; i11++) {
                                    SpannableString valueOf40 = SpannableString.valueOf(eVar.boj[i11].getGiftName());
                                    valueOf40.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf40.length(), 33);
                                    spannableStringBuilder.append((CharSequence) valueOf40);
                                    if (!TextUtils.isEmpty(eVar.boj[i11].NG())) {
                                        AlaLiveMarkData alaLiveMarkData10 = new AlaLiveMarkData();
                                        alaLiveMarkData10.mark_pic = eVar.boj[i11].NG();
                                        alaLiveMarkData10.isWidthAutoFit = true;
                                        com.baidu.live.view.b bVar37 = new com.baidu.live.view.b(this.mContext, alaLiveMarkData10, false, new b.a() { // from class: com.baidu.live.im.a.d.9
                                            @Override // com.baidu.live.view.b.a
                                            public void d(Bitmap bitmap) {
                                                cVar.bkf.forceLayout();
                                            }

                                            @Override // com.baidu.live.view.b.a
                                            public void a(com.baidu.live.view.b bVar38, Bitmap bitmap) {
                                            }
                                        });
                                        SpannableStringBuilder spannableStringBuilder33 = new SpannableStringBuilder("[img]");
                                        spannableStringBuilder33.setSpan(bVar37, 0, spannableStringBuilder33.length(), 33);
                                        spannableStringBuilder.append((CharSequence) spannableStringBuilder33);
                                    }
                                    SpannableString valueOf41 = SpannableString.valueOf("x" + eVar.boj[i11].NF() + "，");
                                    if (!TextUtils.isEmpty(valueOf41)) {
                                        valueOf41.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf41.length(), 33);
                                    }
                                    spannableStringBuilder.append((CharSequence) valueOf41);
                                }
                                SpannableString valueOf42 = SpannableString.valueOf(StringHelper.STRING_MORE);
                                valueOf42.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf42.length(), 33);
                                spannableStringBuilder.append((CharSequence) valueOf42);
                            }
                        }
                    }
                    SpannableString valueOf43 = SpannableString.valueOf(this.mContext.getString(a.h.ala_luckybag_total_prize) + eVar.boi + "T豆");
                    valueOf43.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf43.length(), 33);
                    spannableStringBuilder.append((CharSequence) valueOf43);
                    boolean z6 = !this.bns;
                    if (!TextUtils.isEmpty(eVar.buttonText) && z6) {
                        com.baidu.live.im.view.b bVar38 = new com.baidu.live.im.view.b(this.mContext, eVar.buttonText, false, true, "#FFFFFF", "#FFFFFF", "#000000");
                        SpannableString spannableString5 = new SpannableString(" raterate");
                        spannableString5.setSpan(bVar38, 1, spannableString5.length(), 33);
                        spannableStringBuilder.append((CharSequence) spannableString5);
                    }
                    a aVar6 = new a(this.mContext, eVar.bof, str9);
                    aVar6.setClickable(z6);
                    spannableStringBuilder.setSpan(aVar6, 0, spannableStringBuilder.length(), 33);
                } else {
                    SpannableString valueOf44 = SpannableString.valueOf(str31);
                    valueOf44.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf44.length(), 33);
                    spannableStringBuilder.append((CharSequence) valueOf44);
                    SpannableString valueOf45 = SpannableString.valueOf(optString55);
                    valueOf45.setSpan(new ForegroundColorSpan(-5462), 0, valueOf45.length(), 33);
                    spannableStringBuilder.append((CharSequence) valueOf45);
                    SpannableString valueOf46 = SpannableString.valueOf(str32 + "福袋" + string9 + "神秘大礼");
                    valueOf46.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf46.length(), 33);
                    spannableStringBuilder.append((CharSequence) valueOf46);
                    boolean z7 = !this.bns;
                    if (z7) {
                        com.baidu.live.im.view.b bVar39 = new com.baidu.live.im.view.b(this.mContext, "我也试试>>", false, true, "#FFFFFF", "#FFFFFF", "#000000");
                        SpannableString spannableString6 = new SpannableString(" raterate");
                        spannableString6.setSpan(bVar39, 1, spannableString6.length(), 33);
                        spannableStringBuilder.append((CharSequence) spannableString6);
                    }
                    a aVar7 = new a(this.mContext, -1, str9);
                    aVar7.setClickable(z7);
                    spannableStringBuilder.setSpan(aVar7, 0, spannableStringBuilder.length(), 33);
                }
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(bVar.NU().userId)) {
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
        if (!TextUtils.isEmpty(fVar.bnI)) {
            SpannableString valueOf = SpannableString.valueOf(("×" + str) + "获得了");
            valueOf.setSpan(new ForegroundColorSpan(-5864), 0, valueOf.length(), 33);
            spannableStringBuilder.append((CharSequence) valueOf);
        }
        if (!fVar.bmx && fVar.bnL != 0.0d && !TextUtils.isEmpty(fVar.bnM)) {
            com.baidu.live.im.view.b bVar = new com.baidu.live.im.view.b(this.mContext, fVar.bnL + "倍" + fVar.bnM, false, true, fVar.bnN, fVar.bnO, fVar.bnP, true);
            SpannableString spannableString = new SpannableString(" raterate");
            spannableString.setSpan(bVar, 1, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        if (fVar.bol != null) {
            for (int i = 0; i < fVar.bol.length; i++) {
                com.baidu.live.im.view.b bVar2 = new com.baidu.live.im.view.b(this.mContext, fVar.bol[i].NB(), false, true, fVar.bol[i].ND(), fVar.bol[i].NE(), fVar.bol[i].NC());
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
    private f v(com.baidu.live.im.data.b bVar) {
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
                fVar.bnL = optJSONObject.optDouble("pk_honer_buff_multiple");
                fVar.bnM = optJSONObject.optString("pk_honer_buff_text");
                fVar.bnN = optJSONObject.optString("pk_honer_buff_text_color_start");
                fVar.bnO = optJSONObject.optString("pk_honer_buff_text_color_end");
                fVar.bnP = optJSONObject.optString("pk_honer_buff_text_font_color");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("headline_info");
            if (optJSONObject2 != null) {
                fVar.bnK = optJSONObject2.optString("second_text");
                fVar.bnL = optJSONObject2.optDouble("headline_buff_multiple");
                fVar.bnM = optJSONObject2.optString("headline_buff_text");
                fVar.bnN = optJSONObject2.optString("headline_buff_text_color_start");
                fVar.bnO = optJSONObject2.optString("headline_buff_text_color_end");
                fVar.bnP = optJSONObject2.optString("headline_buff_text_font_color");
            }
            fVar.parserJson(jSONObject);
            fVar.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            fVar.bnI = jSONObject.optString("gift_count");
            if (bVar.Oe() > 0) {
                fVar.bnJ = bVar.Oe() + "";
            } else {
                fVar.bnJ = "";
            }
            fVar.bmx = jSONObject.optInt("is_free") == 1;
            fVar.bmw = bVar.Od();
            com.baidu.live.gift.g hr = ac.hr(fVar.giftId);
            if (hr != null) {
                if (hr.Hf()) {
                    fVar.giftName = this.mContext.getString(a.h.sdk_text_gift_graffiti);
                    if (TextUtils.isEmpty(fVar.giftName)) {
                        fVar.giftName = jSONObject.optString("gift_name");
                    }
                    if (!z && TextUtils.isEmpty(fVar.aWS)) {
                        fVar.aWS = jSONObject.optString("gift_url");
                    }
                    fVar.bdf = jSONObject.optString("gift_source_text");
                    fVar.bnR = jSONObject.optString("gift_source");
                    fVar.aLe = bVar.aLe;
                    return fVar;
                }
                fVar.giftName = hr.GY();
                fVar.aWS = hr.getThumbnail_url();
            }
            z = false;
            if (TextUtils.isEmpty(fVar.giftName)) {
            }
            if (!z) {
                fVar.aWS = jSONObject.optString("gift_url");
            }
            fVar.bdf = jSONObject.optString("gift_source_text");
            fVar.bnR = jSONObject.optString("gift_source");
            fVar.aLe = bVar.aLe;
            return fVar;
        } catch (JSONException e2) {
            return null;
        }
    }

    /* loaded from: classes4.dex */
    private static class a extends ClickableSpan {
        private String aJr;
        private String aRN;
        private String aRO;
        private int boa;
        private boolean bob;
        private String boc;
        private String contentType;
        private Context context;
        private boolean isHost;
        private String liveId;
        private String url;

        public a(Context context, String str, String str2) {
            this.context = context;
            this.url = str;
            this.contentType = str2;
        }

        public a(Context context, int i, String str) {
            this.context = context;
            this.boa = i;
            this.contentType = str;
        }

        public a(Context context, boolean z, String str, String str2) {
            this.context = context;
            this.aJr = str;
            this.contentType = str2;
        }

        public a(Context context, String str, String str2, String str3) {
            this.context = context;
            this.url = str;
            this.boc = str2;
            this.contentType = str3;
        }

        public a(Context context, String str, String str2, String str3, String str4, String str5, boolean z) {
            this.context = context;
            this.url = str;
            this.contentType = str2;
            this.liveId = str3;
            this.aRO = str4;
            this.aRN = str5;
            this.isHost = z;
        }

        public void setClickable(boolean z) {
            this.bob = z;
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
                case 1290650531:
                    if (str.equals("start_grab_redpacket")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    bz bzVar = new bz();
                    bzVar.aRN = this.aRN;
                    bzVar.liveId = this.liveId;
                    bzVar.aRO = this.aRO;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, bzVar));
                    return;
                case 1:
                case 2:
                    com.baidu.live.ao.c cVar = new com.baidu.live.ao.c();
                    cVar.isFullScreen = this.boc.equals("full");
                    cVar.url = this.url;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
                    return;
                case 3:
                    if (this.bob) {
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
                    ai aiVar = new ai();
                    aiVar.aLB = this.boa;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aiVar));
                    return;
                case '\t':
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.aJr));
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "gochat_clk").setContentExt(null, null, null));
                    return;
                case '\n':
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913261, this.aJr));
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

    /* loaded from: classes4.dex */
    private static class e {
        public int bof;
        public String bog;
        public String boh;
        public int boi;
        public c[] boj;
        public C0192d[] bok;
        public String buttonText;

        private e() {
        }

        public void parserJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("prize_member");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("surprise_prize_member");
                if (optJSONArray2 != null) {
                    this.bok = new C0192d[optJSONArray2.length()];
                    for (int i = 0; i < optJSONArray2.length(); i++) {
                        try {
                            this.bok[i] = new C0192d(optJSONArray2.getJSONObject(i));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (optJSONArray != null) {
                    this.boj = new c[optJSONArray.length()];
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        try {
                            this.boj[i2] = new c(optJSONArray.getJSONObject(i2));
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c {
        public String aWS;
        public int bod;
        public int boe;
        public int giftId;
        public String giftName;

        public c(JSONObject jSONObject) {
            this.bod = jSONObject.optInt("prize_type");
            this.boe = jSONObject.optInt("prize_num");
            this.giftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
            this.giftName = jSONObject.optString("gift_name");
            this.aWS = jSONObject.optString("gift_url");
        }

        public int NF() {
            return this.boe;
        }

        public String getGiftName() {
            return this.giftName;
        }

        public String NG() {
            return this.aWS;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.im.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0192d {
        public String aWS;
        public int bod;
        public int boe;
        public int giftId;
        public String giftName;

        public C0192d(JSONObject jSONObject) {
            this.bod = jSONObject.optInt("prize_type");
            this.boe = jSONObject.optInt("prize_num");
            this.giftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
            this.giftName = jSONObject.optString("gift_name");
            this.aWS = jSONObject.optString("gift_url");
        }

        public int NF() {
            return this.boe;
        }

        public String getGiftName() {
            return this.giftName;
        }

        public String NG() {
            return this.aWS;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class f {
        public boolean aLe;
        public String aWS;
        public String bdf;
        public double bmw;
        public boolean bmx;
        public String bnI;
        public String bnJ;
        public String bnK;
        public double bnL;
        public String bnM;
        public String bnN;
        public String bnO;
        public String bnP;
        public String bnR;
        public b[] bol;
        public String giftId;
        public String giftName;

        private f() {
            this.aLe = false;
        }

        public void parserJson(JSONObject jSONObject) {
            JSONArray optJSONArray;
            if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("im_icon_conf")) != null) {
                this.bol = new b[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        this.bol[i] = new b(optJSONArray.getJSONObject(i));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b {
        public String bnE;
        public String bnF;
        public String bnG;
        public String bnH;

        public b(JSONObject jSONObject) {
            this.bnE = jSONObject.optString("text");
            this.bnF = jSONObject.optString("text_color");
            this.bnG = jSONObject.optString("bg_color_start");
            this.bnH = jSONObject.optString("bg_color_end");
        }

        public String NB() {
            return this.bnE;
        }

        public String NC() {
            return this.bnF;
        }

        public String ND() {
            return this.bnG;
        }

        public String NE() {
            return this.bnH;
        }
    }
}

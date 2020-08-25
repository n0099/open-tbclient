package com.baidu.live.im.a;

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
import com.baidu.live.adp.widget.CenteredImageSpan;
import com.baidu.live.adp.widget.imageview.BdImage;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.bk;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d extends b {
    private String bbU;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(Context context) {
        super(context, com.baidu.live.im.a.aYt);
    }

    @Override // com.baidu.live.im.a.b
    protected void Jy() {
        if (Jz()) {
            JA();
        } else {
            JB();
        }
    }

    @Override // com.baidu.live.im.a.b
    protected int getColor() {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:185:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0117  */
    @Override // com.baidu.live.im.a.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected SpannableStringBuilder a(com.baidu.live.im.data.a aVar, final com.baidu.live.im.c cVar) {
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
        boolean z;
        boolean z2;
        int i;
        String string;
        String format;
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        this.bbU = null;
        String str5 = null;
        String str6 = "";
        if (aVar != null) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                try {
                    str5 = jSONObject.optString("content_type");
                    if (str5.equals("start_grab_wheel")) {
                        str6 = jSONObject.optString("ext_data");
                    } else {
                        String optString = jSONObject.optString("ext");
                        if (!TextUtils.isEmpty(optString)) {
                            str6 = new String(Base64.decode(optString.getBytes(), 0));
                        }
                        if (TbConfig.isForceNoticeIm) {
                            str6 = optString;
                        }
                    }
                    if (TextUtils.isEmpty(str6)) {
                        jSONObject2 = null;
                    } else {
                        jSONObject2 = new JSONObject(str6);
                    }
                    try {
                        str = jSONObject.optString("text");
                        try {
                            jSONObject3 = jSONObject;
                            jSONObject4 = jSONObject2;
                            str2 = str;
                            str3 = str5;
                            str4 = jSONObject.optString("level_id");
                        } catch (JSONException e3) {
                            e2 = e3;
                            e2.printStackTrace();
                            jSONObject3 = jSONObject;
                            jSONObject4 = jSONObject2;
                            str2 = str;
                            str3 = str5;
                            str4 = "";
                            if (!TextUtils.isEmpty(str4)) {
                                aVar.JK().level_id = JavaTypesHelper.toInt(str4, 0);
                            }
                            String str7 = null;
                            if (str3 == null) {
                            }
                            if (!z) {
                            }
                            return spannableStringBuilder;
                        } catch (Exception e4) {
                            e = e4;
                            e.printStackTrace();
                            jSONObject3 = jSONObject;
                            jSONObject4 = jSONObject2;
                            str2 = str;
                            str3 = str5;
                            str4 = "";
                            if (!TextUtils.isEmpty(str4)) {
                            }
                            String str72 = null;
                            if (str3 == null) {
                            }
                            if (!z) {
                            }
                            return spannableStringBuilder;
                        }
                    } catch (JSONException e5) {
                        str = "";
                        e2 = e5;
                    } catch (Exception e6) {
                        str = "";
                        e = e6;
                    }
                } catch (JSONException e7) {
                    jSONObject2 = null;
                    str = "";
                    e2 = e7;
                } catch (Exception e8) {
                    jSONObject2 = null;
                    str = "";
                    e = e8;
                }
            } catch (JSONException e9) {
                jSONObject = null;
                jSONObject2 = null;
                str = "";
                e2 = e9;
            } catch (Exception e10) {
                jSONObject = null;
                jSONObject2 = null;
                str = "";
                e = e10;
            }
            if (!TextUtils.isEmpty(str4) && JavaTypesHelper.toInt(str4, 0) > 0) {
                aVar.JK().level_id = JavaTypesHelper.toInt(str4, 0);
            }
            String str722 = null;
            if (str3 == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str722 = str2;
                    z = false;
                    z2 = false;
                    i = -30312;
                } else {
                    str722 = aVar.getContent();
                    z = false;
                    z2 = false;
                    i = -30312;
                }
            } else if (str3.equals("custom_live_notice")) {
                str722 = str2;
                z2 = false;
                i = -7479041;
                z = false;
            } else if (str3.equals("custom_im_notice")) {
                z = true;
                z2 = false;
                i = -30312;
            } else if (str3.equals("custom_im_notice_live_assistant")) {
                z = true;
                z2 = false;
                i = -30312;
            } else if (str3.equals("custom_network_change")) {
                str722 = str2;
                z = false;
                z2 = false;
                i = -30312;
            } else if (str3.equals("enter_live")) {
                String string2 = this.mContext.getString(a.i.ala_enter_live);
                a(spannableStringBuilder, aVar.JK(), cVar, false, false, false);
                str722 = string2;
                z = false;
                z2 = false;
                i = -1711276033;
            } else if (str3.equals("backstage_live")) {
                str722 = str2;
                z2 = false;
                i = -7479041;
                z = false;
            } else if (str3.equals("offline_type")) {
                str722 = str2;
                z = false;
                z2 = false;
                i = -30312;
            } else if (str3.equals("close_live")) {
                str722 = this.mContext.getString(a.i.ala_close_live);
                z = false;
                z2 = false;
                i = -30312;
            } else if (str3.equals("follow_anchor")) {
                str722 = this.mContext.getString(a.i.ala_follow_live);
                a(spannableStringBuilder, aVar.JK(), cVar, false, false);
                z = false;
                z2 = false;
                i = -7479041;
            } else if (str3.equals(com.baidu.tbadk.TbConfig.TMP_SHARE_DIR_NAME)) {
                str722 = this.mContext.getString(a.i.ala_share_live);
                a(spannableStringBuilder, aVar.JK(), cVar, false, false);
                z = false;
                z2 = false;
                i = -7479041;
            } else if (str3.equals("share_tieba")) {
                str722 = str2;
                z2 = false;
                i = -7479041;
                z = false;
            } else if (str3.equals("remove_video")) {
                str722 = str2;
                z = false;
                z2 = false;
                i = -30312;
            } else if (str3.equals("ueg_warn")) {
                str722 = str2;
                z = false;
                z2 = false;
                i = -30312;
            } else if (str3.equals("live_admin")) {
                a(spannableStringBuilder, aVar.JK(), cVar, false, false);
                z = false;
                z2 = false;
                i = -7479041;
                str722 = str2;
            } else if (str3.equals("live_talk_ban") || str3.equals("live_talk_remove_ban") || str3.equals("live_talk_admin_ban") || str3.equals("live_talk_admin_remove_ban")) {
                a(spannableStringBuilder, aVar.JK(), cVar, false, false);
                str722 = str2;
                z = false;
                z2 = false;
                i = -30312;
            } else if (str3.equals("challenge_direct_start")) {
                str722 = str2;
                i = -5864;
                z2 = true;
                z = false;
            } else if (str3.equals("challenge_direct_matched")) {
                str722 = str2;
                i = -5864;
                z2 = true;
                z = false;
            } else if (str3.equals("challenge_random_start")) {
                str722 = str2;
                i = -5864;
                z2 = true;
                z = false;
            } else if (str3.equals("challenge_random_matched")) {
                str722 = str2;
                i = -5864;
                z2 = true;
                z = false;
            } else if (str3.equals("avts")) {
                str722 = str2;
                z = false;
                z2 = false;
                i = -30312;
            } else if (str3.equals("allin")) {
                str722 = str2;
                z = false;
                z2 = false;
                i = -30312;
            } else if (str3.equals("share_rmb")) {
                str722 = this.mContext.getString(a.i.ala_share_rmb);
                a(spannableStringBuilder, aVar.JK(), cVar, false, false);
                z = false;
                z2 = false;
                i = -7479041;
            } else if (str3.equals("zan_rmb")) {
                str722 = this.mContext.getString(a.i.ala_zan_rmb);
                a(spannableStringBuilder, aVar.JK(), cVar, false, false);
                z = false;
                z2 = false;
                i = -1711276033;
            } else if (str3.equals("start_grab_wheel")) {
                z = true;
                z2 = false;
                i = -30312;
            } else if (str3.equals("guard_club_join")) {
                z = true;
                z2 = false;
                i = -30312;
            } else if (str3.equals("haokan_buy_goods")) {
                z = true;
                z2 = false;
                i = -30312;
            } else if (str3.equals("send_redpacket")) {
                z = true;
                z2 = false;
                i = -30312;
            } else if (str3.equals("start_grab_redpacket")) {
                z = true;
                z2 = false;
                i = -30312;
            } else if (str3.equals("guard_seat")) {
                z = true;
                z2 = false;
                i = -30312;
            } else if (str3.equals("challenge_mvp")) {
                z = true;
                z2 = false;
                i = -30312;
            } else if (str3.equals("challenge_mvp_punish")) {
                z = true;
                z2 = false;
                i = -30312;
            } else if (str3.equals("challenge_winner_by_autofail")) {
                z = true;
                z2 = false;
                i = -30312;
            } else if (str3.equals("wish_list_success") || str3.equals("wish_list_finish")) {
                z = true;
                z2 = false;
                i = -30312;
            } else if (str3.equals("privilege_award_royal_success")) {
                z = true;
                z2 = false;
                i = -30312;
            } else if (str3.equals("custom_anchor_identity_update") || str3.equals("custom_master_identity")) {
                str722 = str2;
                z2 = false;
                i = -5864;
                z = false;
            } else if (str3.equals("add_tags_to_anchor")) {
                String str8 = null;
                if (aVar != null && (aVar instanceof com.baidu.live.im.a) && aVar.JK() != null && TextUtils.equals(aVar.JK().userId, TbadkCoreApplication.getCurrentAccount())) {
                    str8 = this.mContext.getString(a.i.add_tag_text_yourself);
                }
                a(spannableStringBuilder, aVar.JK(), cVar, false, false, true, str8);
                str722 = str2;
                z = false;
                z2 = false;
                i = -1;
            } else if (!TextUtils.isEmpty(str2)) {
                str722 = str2;
                z = false;
                z2 = false;
                i = -30312;
            } else {
                str722 = aVar.getContent();
                z = false;
                z2 = false;
                i = -30312;
            }
            if (!z) {
                if (TextUtils.isEmpty(aVar.getLink())) {
                    spannableStringBuilder.append(com.baidu.live.utils.f.E(str722, i));
                    if (z2) {
                        com.baidu.live.view.c cVar2 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_pk);
                        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("  ");
                        spannableStringBuilder2.setSpan(cVar2, 0, 1, 33);
                        spannableStringBuilder.insert(0, (CharSequence) spannableStringBuilder2);
                    }
                } else {
                    SpannableString valueOf = SpannableString.valueOf(str722);
                    valueOf.setSpan(new a(this.mContext, aVar.getLink(), str3), 0, str722 != null ? str722.length() : 0, 33);
                    spannableStringBuilder.append((CharSequence) valueOf);
                }
            } else if (TextUtils.equals(str3, "custom_im_notice")) {
                SpannableString valueOf2 = SpannableString.valueOf(str2);
                valueOf2.setSpan(new ForegroundColorSpan(-1711276033), 0, str2.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf2);
                com.baidu.live.view.c cVar3 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_arrow);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("  ");
                spannableStringBuilder3.setSpan(cVar3, 1, 2, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                spannableStringBuilder.setSpan(new a(this.mContext, aVar.getLink(), str3), 0, spannableStringBuilder.length(), 33);
            } else if (TextUtils.equals(str3, "custom_im_notice_live_assistant")) {
                SpannableString valueOf3 = SpannableString.valueOf(str2);
                valueOf3.setSpan(new ForegroundColorSpan(-7479041), 0, str2.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf3);
                com.baidu.live.view.c cVar4 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_arrow);
                SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder("  ");
                spannableStringBuilder4.setSpan(cVar4, 1, 2, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder4);
                spannableStringBuilder.setSpan(new a(this.mContext, aVar.getLink(), str3), 0, spannableStringBuilder.length(), 33);
            } else if (TextUtils.equals(str3, "custom_im_notice_live_assistant")) {
                SpannableString valueOf4 = SpannableString.valueOf(str2);
                valueOf4.setSpan(new ForegroundColorSpan(-7479041), 0, str2.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf4);
                com.baidu.live.view.c cVar5 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_arrow);
                SpannableStringBuilder spannableStringBuilder5 = new SpannableStringBuilder("  ");
                spannableStringBuilder5.setSpan(cVar5, 1, 2, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder5);
                spannableStringBuilder.setSpan(new a(this.mContext, aVar.getLink(), str3), 0, spannableStringBuilder.length(), 33);
            } else if ("send_redpacket".equals(str3) || "start_grab_redpacket".equals(str3)) {
                com.baidu.live.view.c cVar6 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_redpacket);
                SpannableStringBuilder spannableStringBuilder6 = new SpannableStringBuilder("  ");
                spannableStringBuilder6.setSpan(cVar6, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder6);
                a(spannableStringBuilder, aVar.JK(), cVar, false, false);
                bQ(false);
                if ("send_redpacket".equals(str3)) {
                    String str9 = "";
                    if (jSONObject4 != null) {
                        str9 = jSONObject4.optString(LogConfig.LOG_AMOUNT);
                    }
                    string = String.format(this.mContext.getString(a.i.ala_send_redpacket), str9);
                } else {
                    string = "start_grab_redpacket".equals(str3) ? this.mContext.getString(a.i.ala_start_grab_redpacket) : str722;
                }
                SpannableString valueOf5 = SpannableString.valueOf(string);
                valueOf5.setSpan(new ForegroundColorSpan(-5864), 0, valueOf5.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf5);
                if ("start_grab_redpacket".equals(str3)) {
                    com.baidu.live.view.c cVar7 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_kaiqiang);
                    SpannableStringBuilder spannableStringBuilder7 = new SpannableStringBuilder("  ");
                    spannableStringBuilder7.setSpan(cVar7, 1, 2, 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder7);
                }
                if (jSONObject4 != null) {
                    spannableStringBuilder.setSpan(new a(this.mContext, aVar.getLink(), str3, jSONObject4.optString("live_id"), jSONObject4.optString("anchor_id"), jSONObject4.optString("red_packet_id"), Jx()), 0, spannableStringBuilder.length(), 33);
                }
            } else if (jSONObject3 != null && "guard_seat".equals(str3)) {
                com.baidu.live.view.c cVar8 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_shouhu);
                SpannableStringBuilder spannableStringBuilder8 = new SpannableStringBuilder("  ");
                spannableStringBuilder8.setSpan(cVar8, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder8);
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
                SpannableString valueOf6 = SpannableString.valueOf(sb2);
                valueOf6.setSpan(new ForegroundColorSpan(-5864), 0, sb2.length(), 33);
                if (!TextUtils.isEmpty(optString3)) {
                    valueOf6.setSpan(new ForegroundColorSpan(-5462), optString2.length() + 1, optString2.length() + 1 + optString3.length(), 33);
                }
                spannableStringBuilder.append((CharSequence) valueOf6, 0, sb2.length());
                boolean z3 = jSONObject3.optInt("is_jump") == 1;
                if (z3) {
                    com.baidu.live.view.c cVar9 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_arrow);
                    SpannableStringBuilder spannableStringBuilder9 = new SpannableStringBuilder("  ");
                    spannableStringBuilder9.setSpan(cVar9, 1, 2, 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder9);
                }
                a aVar2 = new a(this.mContext, aVar.getLink(), str3);
                aVar2.setClickable(z3);
                spannableStringBuilder.setSpan(aVar2, 0, spannableStringBuilder.length(), 33);
            } else if (jSONObject3 != null && "challenge_mvp".equals(str3)) {
                String optString5 = jSONObject3.optString("prefix");
                String optString6 = jSONObject3.optString("nickname");
                String optString7 = jSONObject3.optString("suffix");
                StringBuilder sb3 = new StringBuilder(optString5);
                ForegroundColorSpan foregroundColorSpan = null;
                int i2 = 0;
                int i3 = 0;
                if (!TextUtils.isEmpty(optString6)) {
                    sb3.append(" ");
                    i2 = sb3.length();
                    sb3.append(optString6);
                    i3 = optString6.length() + i2;
                    sb3.append(" ");
                    foregroundColorSpan = new ForegroundColorSpan(-5462);
                }
                sb3.append(optString7);
                String sb4 = sb3.toString();
                SpannableString valueOf7 = SpannableString.valueOf(sb4);
                valueOf7.setSpan(new ForegroundColorSpan(-5864), 0, sb4.length(), 33);
                if (foregroundColorSpan != null) {
                    valueOf7.setSpan(foregroundColorSpan, i2, i3, 33);
                }
                spannableStringBuilder.append((CharSequence) valueOf7, 0, sb4.length());
                com.baidu.live.view.c cVar10 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_pk);
                SpannableStringBuilder spannableStringBuilder10 = new SpannableStringBuilder("  ");
                spannableStringBuilder10.setSpan(cVar10, 0, 1, 33);
                spannableStringBuilder.insert(0, (CharSequence) spannableStringBuilder10);
            } else if (jSONObject3 != null && "challenge_mvp_punish".equals(str3)) {
                int optInt = jSONObject3.optInt("punish_type");
                String optString8 = jSONObject3.optString("mvp_nickname");
                String optString9 = jSONObject3.optString("sticker_name");
                String optString10 = jSONObject3.optString("text");
                if (optInt == 1) {
                    optString10 = String.format(this.mContext.getString(a.i.txt_im_mvp_punish_choose), optString8, optString9);
                } else if (optInt == 2) {
                    optString10 = String.format(this.mContext.getString(a.i.txt_im_mvp_punish_letoff), optString8);
                } else if (optInt == 3) {
                    optString10 = String.format(this.mContext.getString(a.i.txt_im_mvp_punish_notchoose), optString8, optString9);
                } else if (optInt != 4) {
                    optString10 = str722;
                }
                if (optString10 == null) {
                    optString10 = "";
                }
                SpannableString valueOf8 = SpannableString.valueOf(optString10);
                valueOf8.setSpan(new ForegroundColorSpan(-5864), 0, optString10.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf8);
                com.baidu.live.view.c cVar11 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_pk);
                SpannableStringBuilder spannableStringBuilder11 = new SpannableStringBuilder("  ");
                spannableStringBuilder11.setSpan(cVar11, 0, 1, 33);
                spannableStringBuilder.insert(0, (CharSequence) spannableStringBuilder11);
            } else if (jSONObject3 != null && "challenge_winner_by_autofail".equals(str3)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = this.mContext.getString(a.i.ala_challenge_winner_by_autofail);
                }
                SpannableString valueOf9 = SpannableString.valueOf(str2);
                valueOf9.setSpan(new ForegroundColorSpan(-5864), 0, str2.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf9, 0, str2.length());
                com.baidu.live.view.c cVar12 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_pk);
                SpannableStringBuilder spannableStringBuilder12 = new SpannableStringBuilder("  ");
                spannableStringBuilder12.setSpan(cVar12, 0, 1, 33);
                spannableStringBuilder.insert(0, (CharSequence) spannableStringBuilder12);
            } else if ("wish_list_success".equals(str3) || "wish_list_finish".equals(str3)) {
                com.baidu.live.view.c cVar13 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_xinyuan);
                SpannableStringBuilder spannableStringBuilder13 = new SpannableStringBuilder("  ");
                spannableStringBuilder13.setSpan(cVar13, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder13);
                SpannableString valueOf10 = SpannableString.valueOf(str2);
                valueOf10.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf10.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf10);
                if (!this.bbH) {
                    com.baidu.live.view.c cVar14 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_zhuli);
                    SpannableStringBuilder spannableStringBuilder14 = new SpannableStringBuilder("  ");
                    spannableStringBuilder14.setSpan(cVar14, 1, 2, 33);
                    spannableStringBuilder.insert(spannableStringBuilder.length(), (CharSequence) spannableStringBuilder14);
                }
                spannableStringBuilder.setSpan(new a(this.mContext, aVar.getLink(), str3), 0, spannableStringBuilder.length(), 33);
            } else if ("start_grab_wheel".equals(str3)) {
                com.baidu.live.view.c cVar15 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_zhuanpan);
                SpannableStringBuilder spannableStringBuilder15 = new SpannableStringBuilder("  ");
                spannableStringBuilder15.setSpan(cVar15, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder15);
                spannableStringBuilder.append(com.baidu.live.utils.f.E(this.mContext.getString(a.i.ala_lucky_tab_tips2), -7479041));
                a(spannableStringBuilder, aVar.JK(), cVar, false, false);
                bQ(false);
                String str10 = "";
                String str11 = "";
                String str12 = "";
                if (jSONObject4 != null) {
                    str10 = jSONObject4.optString(LogConfig.LOG_AMOUNT);
                    str11 = jSONObject4.optString("keywords");
                    str12 = jSONObject4.optString("gift_url");
                }
                spannableStringBuilder.append(com.baidu.live.utils.f.E(String.format(this.mContext.getString(a.i.ala_lucky_tab_tips), str10, str11), -7479041));
                AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                alaLiveMarkData.mark_pic = str12;
                com.baidu.live.view.c cVar16 = new com.baidu.live.view.c(this.mContext, alaLiveMarkData, false, null);
                SpannableStringBuilder spannableStringBuilder16 = new SpannableStringBuilder("  ");
                spannableStringBuilder16.setSpan(cVar16, 1, 2, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder16);
            } else if (TextUtils.equals("guard_club_join", str3)) {
                com.baidu.live.view.c cVar17 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_zhenai);
                SpannableStringBuilder spannableStringBuilder17 = new SpannableStringBuilder("  ");
                spannableStringBuilder17.setSpan(cVar17, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder17);
                spannableStringBuilder.append(com.baidu.live.utils.f.E(this.mContext.getString(a.i.ala_guard_club_join_welcome), -7479041));
                a(spannableStringBuilder, aVar.JK(), cVar, false, false);
                bQ(false);
                spannableStringBuilder.append(com.baidu.live.utils.f.E(this.mContext.getString(a.i.ala_guard_club_join), -7479041));
                if (!this.bbH) {
                    com.baidu.live.view.c cVar18 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_jiaru);
                    SpannableStringBuilder spannableStringBuilder18 = new SpannableStringBuilder("  ");
                    spannableStringBuilder18.setSpan(cVar18, 1, 2, 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder18);
                }
                spannableStringBuilder.setSpan(new a(this.mContext, aVar.getLink(), str3), 0, spannableStringBuilder.length(), 33);
            } else if (jSONObject3 != null && TextUtils.equals(str3, "privilege_award_royal_success")) {
                final String optString11 = jSONObject3.optString("icon_url");
                this.bbU = optString11;
                if (!TextUtils.isEmpty(optString11)) {
                    new AlaLiveMarkData().mark_pic = optString11;
                    BdResourceLoader.getInstance().loadResource(optString11, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.im.a.d.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                        public void onLoaded(BdImage bdImage, String str13, int i4) {
                            super.onLoaded((AnonymousClass1) bdImage, str13, i4);
                            Bitmap a2 = d.this.a(bdImage);
                            if (a2 != null && TextUtils.equals(d.this.bbU, optString11)) {
                                CenteredImageSpan centeredImageSpan = new CenteredImageSpan(d.this.mContext, a2);
                                SpannableString spannableString = new SpannableString("[img] ");
                                spannableString.setSpan(centeredImageSpan, 0, spannableString.length() - 1, 33);
                                spannableStringBuilder.insert(0, (CharSequence) spannableString);
                                cVar.aYI.setText(spannableStringBuilder);
                                cVar.aYI.forceLayout();
                            }
                        }
                    }, null);
                }
                a(spannableStringBuilder, aVar.JK(), cVar, false, false);
                bQ(false);
                int optInt2 = jSONObject3.optInt("royal_level");
                String str13 = "";
                if (optInt2 >= 0 && optInt2 <= 7) {
                    str13 = AlaLiveMarkData.NOBLE_LEVEL_NAMES[optInt2];
                }
                if (TextUtils.equals(aVar.JK().userId, TbadkCoreApplication.getCurrentAccount())) {
                    format = String.format(this.mContext.getString(a.i.txt_im_noble_update_mine), str13);
                } else {
                    format = String.format(this.mContext.getString(a.i.txt_im_noble_update), str13);
                }
                spannableStringBuilder.append(com.baidu.live.utils.f.E(format, -5864));
            } else if (TextUtils.equals("haokan_buy_goods", str3)) {
                com.baidu.live.view.c cVar19 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_viewer_shopping);
                SpannableStringBuilder spannableStringBuilder19 = new SpannableStringBuilder("  ");
                spannableStringBuilder19.setSpan(cVar19, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder19);
                spannableStringBuilder.append(com.baidu.live.utils.f.E(str2, -1));
            }
        }
        return spannableStringBuilder;
    }

    /* loaded from: classes7.dex */
    private static class a extends ClickableSpan {
        private String aKg;
        private String aKh;
        private boolean bbY;
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

        public a(Context context, String str, String str2, String str3, String str4, String str5, boolean z) {
            this.context = context;
            this.url = str;
            this.contentType = str2;
            this.liveId = str3;
            this.aKh = str4;
            this.aKg = str5;
            this.isHost = z;
        }

        public void setClickable(boolean z) {
            this.bbY = z;
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
                    bk bkVar = new bk();
                    bkVar.aKg = this.aKg;
                    bkVar.liveId = this.liveId;
                    bkVar.aKh = this.aKh;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, bkVar));
                    return;
                case 1:
                    if (this.bbY) {
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
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds32);
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

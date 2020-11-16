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
import com.baidu.live.data.bx;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.live.view.b;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d extends b {
    private String bjt;
    private String bju;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(Context context) {
        super(context, com.baidu.live.im.a.bfA);
    }

    @Override // com.baidu.live.im.a.b
    protected void Ls() {
        if (Lt()) {
            Lu();
        } else {
            Lv();
        }
    }

    @Override // com.baidu.live.im.a.b
    protected int getColor() {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x059e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x011c  */
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
        JSONObject jSONObject5;
        String format;
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        this.bjt = null;
        this.bju = null;
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
                    } catch (JSONException e3) {
                        str = "";
                        e2 = e3;
                    } catch (Exception e4) {
                        str = "";
                        e = e4;
                    }
                    try {
                        jSONObject3 = jSONObject;
                        jSONObject4 = jSONObject2;
                        str2 = str;
                        str3 = str5;
                        str4 = jSONObject.optString("level_id");
                    } catch (JSONException e5) {
                        e2 = e5;
                        e2.printStackTrace();
                        jSONObject3 = jSONObject;
                        jSONObject4 = jSONObject2;
                        str2 = str;
                        str3 = str5;
                        str4 = "";
                        if (!TextUtils.isEmpty(str4)) {
                            aVar.LF().level_id = JavaTypesHelper.toInt(str4, 0);
                        }
                        String str7 = null;
                        if (str3 == null) {
                        }
                        if (!z) {
                        }
                        return spannableStringBuilder;
                    } catch (Exception e6) {
                        e = e6;
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
                aVar.LF().level_id = JavaTypesHelper.toInt(str4, 0);
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
                String string2 = this.mContext.getString(a.h.ala_enter_live);
                a(spannableStringBuilder, aVar.LF(), cVar, false, false, false);
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
                str722 = this.mContext.getString(a.h.ala_close_live);
                z = false;
                z2 = false;
                i = -30312;
            } else if (str3.equals("follow_anchor")) {
                str722 = this.mContext.getString(a.h.ala_follow_live);
                a(spannableStringBuilder, aVar.LF(), cVar, false, false);
                z = false;
                z2 = false;
                i = -7479041;
            } else if (str3.equals(com.baidu.tbadk.TbConfig.TMP_SHARE_DIR_NAME)) {
                str722 = this.mContext.getString(a.h.ala_share_live);
                a(spannableStringBuilder, aVar.LF(), cVar, false, false);
                if ((aVar instanceof com.baidu.live.im.a) && ((com.baidu.live.im.a) aVar).Kp().equals(aVar.LF().userId)) {
                    com.baidu.live.view.b bVar = new com.baidu.live.view.b(this.mContext, a.e.icon_im_anchor);
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("  ");
                    spannableStringBuilder2.setSpan(bVar, 0, 1, 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                }
                z = false;
                z2 = false;
                i = -7479041;
            } else if (str3.equals("share_tieba")) {
                if ((aVar instanceof com.baidu.live.im.a) && ((com.baidu.live.im.a) aVar).Kp().equals(aVar.LF().userId)) {
                    com.baidu.live.view.b bVar2 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_anchor);
                    SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("  ");
                    spannableStringBuilder3.setSpan(bVar2, 0, 1, 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                }
                str722 = str2;
                z = false;
                i = -7479041;
                z2 = false;
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
                a(spannableStringBuilder, aVar.LF(), cVar, false, false);
                z = false;
                z2 = false;
                i = -7479041;
                str722 = str2;
            } else if (str3.equals("live_talk_ban") || str3.equals("live_talk_remove_ban") || str3.equals("live_talk_admin_ban") || str3.equals("live_talk_admin_remove_ban")) {
                a(spannableStringBuilder, aVar.LF(), cVar, false, false);
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
                str722 = this.mContext.getString(a.h.ala_share_rmb);
                a(spannableStringBuilder, aVar.LF(), cVar, false, false);
                z = false;
                z2 = false;
                i = -7479041;
            } else if (str3.equals("zan_rmb")) {
                if ((aVar instanceof com.baidu.live.im.a) && ((com.baidu.live.im.a) aVar).Kp().equals(aVar.LF().userId)) {
                    com.baidu.live.view.b bVar3 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_anchor);
                    SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder("  ");
                    spannableStringBuilder4.setSpan(bVar3, 0, 1, 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder4);
                }
                str722 = this.mContext.getString(a.h.ala_zan_rmb);
                a(spannableStringBuilder, aVar.LF(), cVar, false, false);
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
            } else if (str3.equals("activity_gift")) {
                z = true;
                z2 = false;
                i = -30312;
            } else if (str3.equals("activity_notice")) {
                z = true;
                z2 = false;
                i = -30312;
            } else if (str3.equals("activity_common_im")) {
                z = true;
                z2 = false;
                i = -30312;
            } else if (str3.equals("pk_first_blood")) {
                z = true;
                z2 = false;
                i = -30312;
            } else if (str3.equals("pk_send_props")) {
                z = true;
                z2 = false;
                i = -30312;
            } else if (str3.equals("pk_mvp_props")) {
                z = true;
                z2 = false;
                i = -30312;
            } else if (str3.equals("tying_gift")) {
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
                if (aVar != null && (aVar instanceof com.baidu.live.im.a) && aVar.LF() != null && TextUtils.equals(aVar.LF().userId, TbadkCoreApplication.getCurrentAccount())) {
                    str8 = this.mContext.getString(a.h.add_tag_text_yourself);
                }
                a(spannableStringBuilder, aVar.LF(), cVar, false, false, true, str8);
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
                    spannableStringBuilder.append(com.baidu.live.utils.g.F(str722, i));
                    if (z2) {
                        com.baidu.live.view.b bVar4 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_pk);
                        SpannableStringBuilder spannableStringBuilder5 = new SpannableStringBuilder("  ");
                        spannableStringBuilder5.setSpan(bVar4, 0, 1, 33);
                        spannableStringBuilder.insert(0, (CharSequence) spannableStringBuilder5);
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
                com.baidu.live.view.b bVar5 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_arrow);
                SpannableStringBuilder spannableStringBuilder6 = new SpannableStringBuilder("  ");
                spannableStringBuilder6.setSpan(bVar5, 1, 2, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder6);
                spannableStringBuilder.setSpan(new a(this.mContext, aVar.getLink(), str3), 0, spannableStringBuilder.length(), 33);
            } else if (TextUtils.equals(str3, "custom_im_notice_live_assistant")) {
                SpannableString valueOf3 = SpannableString.valueOf(str2);
                valueOf3.setSpan(new ForegroundColorSpan(-7479041), 0, str2.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf3);
                com.baidu.live.view.b bVar6 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_arrow);
                SpannableStringBuilder spannableStringBuilder7 = new SpannableStringBuilder("  ");
                spannableStringBuilder7.setSpan(bVar6, 1, 2, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder7);
                spannableStringBuilder.setSpan(new a(this.mContext, aVar.getLink(), str3), 0, spannableStringBuilder.length(), 33);
            } else if (TextUtils.equals(str3, "custom_im_notice_live_assistant")) {
                SpannableString valueOf4 = SpannableString.valueOf(str2);
                valueOf4.setSpan(new ForegroundColorSpan(-7479041), 0, str2.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf4);
                com.baidu.live.view.b bVar7 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_arrow);
                SpannableStringBuilder spannableStringBuilder8 = new SpannableStringBuilder("  ");
                spannableStringBuilder8.setSpan(bVar7, 1, 2, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder8);
                spannableStringBuilder.setSpan(new a(this.mContext, aVar.getLink(), str3), 0, spannableStringBuilder.length(), 33);
            } else if ("send_redpacket".equals(str3) || "start_grab_redpacket".equals(str3)) {
                com.baidu.live.view.b bVar8 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_redpacket);
                SpannableStringBuilder spannableStringBuilder9 = new SpannableStringBuilder("  ");
                spannableStringBuilder9.setSpan(bVar8, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder9);
                a(spannableStringBuilder, aVar.LF(), cVar, false, false);
                ca(false);
                if ("send_redpacket".equals(str3)) {
                    String str9 = "";
                    if (jSONObject4 != null) {
                        str9 = jSONObject4.optString(LogConfig.LOG_AMOUNT);
                    }
                    string = String.format(this.mContext.getString(a.h.ala_send_redpacket), str9);
                } else {
                    string = "start_grab_redpacket".equals(str3) ? this.mContext.getString(a.h.ala_start_grab_redpacket) : str722;
                }
                SpannableString valueOf5 = SpannableString.valueOf(string);
                valueOf5.setSpan(new ForegroundColorSpan(-5864), 0, valueOf5.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf5);
                if ("start_grab_redpacket".equals(str3)) {
                    com.baidu.live.view.b bVar9 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_kaiqiang);
                    SpannableStringBuilder spannableStringBuilder10 = new SpannableStringBuilder("  ");
                    spannableStringBuilder10.setSpan(bVar9, 1, 2, 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder10);
                }
                if (jSONObject4 != null) {
                    spannableStringBuilder.setSpan(new a(this.mContext, aVar.getLink(), str3, jSONObject4.optString("live_id"), jSONObject4.optString("anchor_id"), jSONObject4.optString("red_packet_id"), Lr()), 0, spannableStringBuilder.length(), 33);
                }
            } else if (jSONObject3 != null && "guard_seat".equals(str3)) {
                com.baidu.live.view.b bVar10 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_shouhu);
                SpannableStringBuilder spannableStringBuilder11 = new SpannableStringBuilder("  ");
                spannableStringBuilder11.setSpan(bVar10, 0, 1, 33);
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
                SpannableString valueOf6 = SpannableString.valueOf(sb2);
                valueOf6.setSpan(new ForegroundColorSpan(-5864), 0, sb2.length(), 33);
                if (!TextUtils.isEmpty(optString3)) {
                    valueOf6.setSpan(new ForegroundColorSpan(-5462), optString2.length() + 1, optString2.length() + 1 + optString3.length(), 33);
                }
                spannableStringBuilder.append((CharSequence) valueOf6, 0, sb2.length());
                boolean z3 = jSONObject3.optInt("is_jump") == 1;
                if (z3) {
                    com.baidu.live.view.b bVar11 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_arrow);
                    SpannableStringBuilder spannableStringBuilder12 = new SpannableStringBuilder("  ");
                    spannableStringBuilder12.setSpan(bVar11, 1, 2, 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder12);
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
                com.baidu.live.view.b bVar12 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_pk);
                SpannableStringBuilder spannableStringBuilder13 = new SpannableStringBuilder("  ");
                spannableStringBuilder13.setSpan(bVar12, 0, 1, 33);
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
                    optString10 = str722;
                }
                if (optString10 == null) {
                    optString10 = "";
                }
                SpannableString valueOf8 = SpannableString.valueOf(optString10);
                valueOf8.setSpan(new ForegroundColorSpan(-5864), 0, optString10.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf8);
                com.baidu.live.view.b bVar13 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_pk);
                SpannableStringBuilder spannableStringBuilder14 = new SpannableStringBuilder("  ");
                spannableStringBuilder14.setSpan(bVar13, 0, 1, 33);
                spannableStringBuilder.insert(0, (CharSequence) spannableStringBuilder14);
            } else if (jSONObject3 != null && "challenge_winner_by_autofail".equals(str3)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = this.mContext.getString(a.h.ala_challenge_winner_by_autofail);
                }
                SpannableString valueOf9 = SpannableString.valueOf(str2);
                valueOf9.setSpan(new ForegroundColorSpan(-5864), 0, str2.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf9, 0, str2.length());
                com.baidu.live.view.b bVar14 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_pk);
                SpannableStringBuilder spannableStringBuilder15 = new SpannableStringBuilder("  ");
                spannableStringBuilder15.setSpan(bVar14, 0, 1, 33);
                spannableStringBuilder.insert(0, (CharSequence) spannableStringBuilder15);
            } else if ("wish_list_success".equals(str3) || "wish_list_finish".equals(str3)) {
                com.baidu.live.view.b bVar15 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_xinyuan);
                SpannableStringBuilder spannableStringBuilder16 = new SpannableStringBuilder("  ");
                spannableStringBuilder16.setSpan(bVar15, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder16);
                SpannableString valueOf10 = SpannableString.valueOf(str2);
                valueOf10.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf10.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf10);
                if (!this.bja) {
                    com.baidu.live.view.b bVar16 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_zhuli);
                    SpannableStringBuilder spannableStringBuilder17 = new SpannableStringBuilder("  ");
                    spannableStringBuilder17.setSpan(bVar16, 1, 2, 33);
                    spannableStringBuilder.insert(spannableStringBuilder.length(), (CharSequence) spannableStringBuilder17);
                }
                spannableStringBuilder.setSpan(new a(this.mContext, aVar.getLink(), str3), 0, spannableStringBuilder.length(), 33);
            } else if ("start_grab_wheel".equals(str3)) {
                com.baidu.live.view.b bVar17 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_zhuanpan);
                SpannableStringBuilder spannableStringBuilder18 = new SpannableStringBuilder("  ");
                spannableStringBuilder18.setSpan(bVar17, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder18);
                spannableStringBuilder.append(com.baidu.live.utils.g.F(this.mContext.getString(a.h.ala_lucky_tab_tips2), -7479041));
                a(spannableStringBuilder, aVar.LF(), cVar, false, false);
                ca(false);
                String str10 = "";
                String str11 = "";
                String str12 = "";
                if (jSONObject4 != null) {
                    str10 = jSONObject4.optString(LogConfig.LOG_AMOUNT);
                    str11 = jSONObject4.optString("keywords");
                    str12 = jSONObject4.optString("gift_url");
                }
                spannableStringBuilder.append(com.baidu.live.utils.g.F(String.format(this.mContext.getString(a.h.ala_lucky_tab_tips), str10, str11), -7479041));
                AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                alaLiveMarkData.mark_pic = str12;
                com.baidu.live.view.b bVar18 = new com.baidu.live.view.b(this.mContext, alaLiveMarkData, false, null);
                SpannableStringBuilder spannableStringBuilder19 = new SpannableStringBuilder("  ");
                spannableStringBuilder19.setSpan(bVar18, 1, 2, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder19);
            } else if (TextUtils.equals("guard_club_join", str3)) {
                com.baidu.live.view.b bVar19 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_zhenai);
                SpannableStringBuilder spannableStringBuilder20 = new SpannableStringBuilder("  ");
                spannableStringBuilder20.setSpan(bVar19, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder20);
                spannableStringBuilder.append(com.baidu.live.utils.g.F(this.mContext.getString(a.h.ala_guard_club_join_welcome), -7479041));
                a(spannableStringBuilder, aVar.LF(), cVar, false, false);
                ca(false);
                spannableStringBuilder.append(com.baidu.live.utils.g.F(this.mContext.getString(a.h.ala_guard_club_join), -7479041));
                if (!this.bja) {
                    com.baidu.live.view.b bVar20 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_jiaru);
                    SpannableStringBuilder spannableStringBuilder21 = new SpannableStringBuilder("  ");
                    spannableStringBuilder21.setSpan(bVar20, 1, 2, 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder21);
                }
                spannableStringBuilder.setSpan(new a(this.mContext, aVar.getLink(), str3), 0, spannableStringBuilder.length(), 33);
            } else if (jSONObject3 != null && TextUtils.equals(str3, "privilege_award_royal_success")) {
                final String optString11 = jSONObject3.optString("icon_url");
                this.bjt = optString11;
                if (!TextUtils.isEmpty(optString11)) {
                    new AlaLiveMarkData().mark_pic = optString11;
                    BdResourceLoader.getInstance().loadResource(optString11, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.im.a.d.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                        public void onLoaded(BdImage bdImage, String str13, int i4) {
                            super.onLoaded((AnonymousClass1) bdImage, str13, i4);
                            Bitmap a2 = d.this.a(bdImage);
                            if (a2 != null && TextUtils.equals(d.this.bjt, optString11)) {
                                CenteredImageSpan centeredImageSpan = new CenteredImageSpan(d.this.mContext, a2);
                                SpannableString spannableString = new SpannableString("[img] ");
                                spannableString.setSpan(centeredImageSpan, 0, spannableString.length() - 1, 33);
                                spannableStringBuilder.insert(0, (CharSequence) spannableString);
                                cVar.bfP.setText(spannableStringBuilder);
                                cVar.bfP.forceLayout();
                            }
                        }
                    }, null);
                }
                a(spannableStringBuilder, aVar.LF(), cVar, false, false);
                ca(false);
                int optInt2 = jSONObject3.optInt("royal_level");
                String str13 = "";
                if (optInt2 >= 0 && optInt2 <= 7) {
                    str13 = AlaLiveMarkData.NOBLE_LEVEL_NAMES[optInt2];
                }
                if (TextUtils.equals(aVar.LF().userId, TbadkCoreApplication.getCurrentAccount())) {
                    format = String.format(this.mContext.getString(a.h.txt_im_noble_update_mine), str13);
                } else {
                    format = String.format(this.mContext.getString(a.h.txt_im_noble_update), str13);
                }
                spannableStringBuilder.append(com.baidu.live.utils.g.F(format, -5864));
            } else if (TextUtils.equals("haokan_buy_goods", str3)) {
                com.baidu.live.view.b bVar21 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_viewer_shopping);
                SpannableStringBuilder spannableStringBuilder22 = new SpannableStringBuilder("  ");
                spannableStringBuilder22.setSpan(bVar21, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder22);
                spannableStringBuilder.append(com.baidu.live.utils.g.F(str2, -1));
            } else if (jSONObject3 != null && "activity_gift".equals(str3)) {
                JSONObject optJSONObject = jSONObject3.optJSONObject("content_data");
                a(spannableStringBuilder, aVar.LF(), cVar, false, false);
                if (optJSONObject != null) {
                    String optString12 = optJSONObject.optString("giftName");
                    String str14 = optJSONObject.optInt("giftNumber") + " ";
                    String optString13 = optJSONObject.optString("giftPic");
                    String str15 = optJSONObject.optDouble("multipleTime") + "";
                    String optString14 = optJSONObject.optString("multipleName");
                    String optString15 = optJSONObject.optString("firstText");
                    String optString16 = optJSONObject.optString("secondText");
                    String optString17 = optJSONObject.optString("span_text_color");
                    String optString18 = optJSONObject.optString("span_color_start");
                    String optString19 = optJSONObject.optString("span_color_end");
                    SpannableString valueOf11 = SpannableString.valueOf(optString15 + optString12);
                    if (!TextUtils.isEmpty(optString15)) {
                        valueOf11.setSpan(new ForegroundColorSpan(-5864), 0, valueOf11.length(), 33);
                    }
                    spannableStringBuilder.append((CharSequence) valueOf11);
                    if (!TextUtils.isEmpty(optString13)) {
                        AlaLiveMarkData alaLiveMarkData2 = new AlaLiveMarkData();
                        alaLiveMarkData2.mark_pic = optString13;
                        alaLiveMarkData2.isWidthAutoFit = true;
                        com.baidu.live.view.b bVar22 = new com.baidu.live.view.b(this.mContext, alaLiveMarkData2, false, new b.a() { // from class: com.baidu.live.im.a.d.4
                            @Override // com.baidu.live.view.b.a
                            public void d(Bitmap bitmap) {
                                cVar.bfP.forceLayout();
                            }

                            @Override // com.baidu.live.view.b.a
                            public void a(com.baidu.live.view.b bVar23, Bitmap bitmap) {
                            }
                        });
                        SpannableStringBuilder spannableStringBuilder23 = new SpannableStringBuilder(" [img]");
                        spannableStringBuilder23.setSpan(bVar22, 1, spannableStringBuilder23.length(), 33);
                        spannableStringBuilder.append((CharSequence) spannableStringBuilder23);
                    }
                    if (!TextUtils.isEmpty(str14)) {
                        SpannableString valueOf12 = SpannableString.valueOf("X" + str14);
                        valueOf12.setSpan(new ForegroundColorSpan(-5864), 0, valueOf12.length(), 33);
                        spannableStringBuilder.append((CharSequence) valueOf12);
                    }
                    if (!TextUtils.isEmpty(optString16)) {
                        SpannableString valueOf13 = SpannableString.valueOf(optString16);
                        valueOf13.setSpan(new ForegroundColorSpan(-5864), 0, valueOf13.length(), 33);
                        spannableStringBuilder.append((CharSequence) valueOf13);
                    }
                    if (!TextUtils.isEmpty(str15) && !TextUtils.isEmpty(optString14) && !TextUtils.isEmpty(optString19)) {
                        com.baidu.live.im.view.a aVar3 = new com.baidu.live.im.view.a(this.mContext, str15 + "倍" + optString14, false, true, true, optString18, optString19, optString17);
                        SpannableString spannableString = new SpannableString(" rate");
                        spannableString.setSpan(aVar3, 1, spannableString.length(), 33);
                        spannableStringBuilder.append((CharSequence) spannableString);
                    } else if (!TextUtils.isEmpty(str15) && !TextUtils.isEmpty(optString14)) {
                        com.baidu.live.im.view.a aVar4 = new com.baidu.live.im.view.a(this.mContext, str15 + "倍" + optString14, true, false, true);
                        SpannableString spannableString2 = new SpannableString(" rate");
                        spannableString2.setSpan(aVar4, 1, spannableString2.length(), 33);
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
                    com.baidu.live.view.b bVar23 = new com.baidu.live.view.b(this.mContext, alaLiveMarkData3, false, new b.a() { // from class: com.baidu.live.im.a.d.5
                        @Override // com.baidu.live.view.b.a
                        public void d(Bitmap bitmap) {
                            cVar.bfP.forceLayout();
                        }

                        @Override // com.baidu.live.view.b.a
                        public void a(com.baidu.live.view.b bVar24, Bitmap bitmap) {
                        }
                    });
                    SpannableStringBuilder spannableStringBuilder24 = new SpannableStringBuilder(" [img]");
                    spannableStringBuilder24.setSpan(bVar23, 1, spannableStringBuilder24.length(), 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder24);
                }
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("jump_item");
                if (optJSONArray2 != null && optJSONArray != null) {
                    for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                        try {
                            String trim = optJSONArray2.getString(i4).trim();
                            String string3 = optJSONArray.getString(i4);
                            int parseColor = Color.parseColor(trim);
                            SpannableString valueOf14 = SpannableString.valueOf(string3);
                            valueOf14.setSpan(new ForegroundColorSpan(parseColor), 0, valueOf14.length(), 33);
                            spannableStringBuilder.append((CharSequence) valueOf14);
                        } catch (JSONException e11) {
                            e11.printStackTrace();
                        }
                    }
                    if (optJSONObject3 != null) {
                        String optString21 = optJSONObject3.optString("title");
                        String trim2 = optJSONObject3.optString("title_color").trim();
                        String optString22 = optJSONObject3.optString("url");
                        String trim3 = optJSONObject3.optString("bg").trim();
                        String optString23 = optJSONObject3.optString("screen");
                        if (optInt3 == 1 && !TextUtils.isEmpty(optString21) && !TextUtils.isEmpty(optString22)) {
                            com.baidu.live.im.view.a aVar5 = new com.baidu.live.im.view.a(this.mContext, optString21 + " >", false, true, trim3, trim3, trim2);
                            SpannableString spannableString3 = new SpannableString(" click");
                            spannableString3.setSpan(aVar5, 1, spannableString3.length(), 33);
                            spannableStringBuilder.append((CharSequence) spannableString3);
                            a aVar6 = new a(this.mContext, optString22, optString23, str3);
                            aVar6.setClickable(true);
                            spannableStringBuilder.setSpan(aVar6, 0, spannableStringBuilder.length(), 33);
                        }
                    }
                }
            } else if (jSONObject3 != null && "activity_notice".equals(str3)) {
                jSONObject3.optInt("open");
                try {
                    jSONObject5 = new JSONObject(str2);
                } catch (JSONException e12) {
                    e12.printStackTrace();
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
                    SpannableString valueOf15 = SpannableString.valueOf(" " + optString25);
                    if (!TextUtils.isEmpty(optString24)) {
                        AlaLiveMarkData alaLiveMarkData4 = new AlaLiveMarkData();
                        alaLiveMarkData4.mark_pic = optString24;
                        alaLiveMarkData4.isWidthAutoFit = true;
                        com.baidu.live.view.b bVar24 = new com.baidu.live.view.b(this.mContext, alaLiveMarkData4, false, new b.a() { // from class: com.baidu.live.im.a.d.6
                            @Override // com.baidu.live.view.b.a
                            public void d(Bitmap bitmap) {
                                cVar.bfP.forceLayout();
                            }

                            @Override // com.baidu.live.view.b.a
                            public void a(com.baidu.live.view.b bVar25, Bitmap bitmap) {
                            }
                        });
                        SpannableStringBuilder spannableStringBuilder25 = new SpannableStringBuilder("[img]");
                        spannableStringBuilder25.setSpan(bVar24, 0, spannableStringBuilder25.length(), 33);
                        spannableStringBuilder.append((CharSequence) spannableStringBuilder25);
                    }
                    valueOf15.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf15.length(), 33);
                    spannableStringBuilder.append((CharSequence) valueOf15);
                    if (!TextUtils.isEmpty(optString27)) {
                        com.baidu.live.im.view.a aVar7 = new com.baidu.live.im.view.a(this.mContext, optString26 + " >", false, true, "#FFF5F5F5", "#FFF5F5F5", "#FFA3A3A3");
                        SpannableString spannableString4 = new SpannableString("url");
                        spannableString4.setSpan(aVar7, 0, spannableString4.length(), 33);
                        spannableStringBuilder.append((CharSequence) spannableString4);
                        a aVar8 = new a(this.mContext, optString27, optString28, str3);
                        aVar8.setClickable(true);
                        spannableStringBuilder.setSpan(aVar8, 0, spannableStringBuilder.length(), 33);
                    }
                }
            } else if (jSONObject3 != null && "pk_first_blood".equals(str3)) {
                JSONObject optJSONObject6 = jSONObject3.optJSONObject("first_blood_info");
                String str16 = aVar.LF().name_show;
                if (optJSONObject6 != null) {
                    String optString29 = optJSONObject6.optString("front_text");
                    String optString30 = optJSONObject6.optString("behind_text");
                    final String optString31 = optJSONObject6.optString("icon_url");
                    this.bjt = optString31;
                    if (!TextUtils.isEmpty(optString31)) {
                        new AlaLiveMarkData().mark_pic = optString31;
                        BdResourceLoader.getInstance().loadResource(optString31, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.im.a.d.7
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                            public void onLoaded(BdImage bdImage, String str17, int i5) {
                                super.onLoaded((AnonymousClass7) bdImage, str17, i5);
                                Bitmap a2 = d.this.a(bdImage);
                                if (a2 != null && TextUtils.equals(d.this.bjt, optString31)) {
                                    CenteredImageSpan centeredImageSpan = new CenteredImageSpan(d.this.mContext, a2);
                                    SpannableString spannableString5 = new SpannableString("[img] ");
                                    spannableString5.setSpan(centeredImageSpan, 0, spannableString5.length() - 1, 33);
                                    spannableStringBuilder.insert(0, (CharSequence) spannableString5);
                                    cVar.bfP.setText(spannableStringBuilder);
                                    cVar.bfP.forceLayout();
                                }
                            }
                        }, null);
                    }
                    SpannableString valueOf16 = SpannableString.valueOf(optString29 + str16 + optString30);
                    ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(-5462);
                    ForegroundColorSpan foregroundColorSpan3 = new ForegroundColorSpan(-7479041);
                    valueOf16.setSpan(new ForegroundColorSpan(-7479041), 0, optString29.length(), 33);
                    valueOf16.setSpan(foregroundColorSpan2, optString29.length(), optString29.length() + str16.length(), 33);
                    valueOf16.setSpan(foregroundColorSpan3, str16.length() + optString29.length(), valueOf16.length(), 33);
                    spannableStringBuilder.append((CharSequence) valueOf16);
                }
            } else if (str3 != null && jSONObject3 != null && "pk_send_props".equals(str3)) {
                final String optString32 = jSONObject3.optString("pk_image_url");
                String optString33 = jSONObject3.optString("props_belong_text");
                String str17 = aVar.LF().name_show;
                String optString34 = jSONObject3.optString("gift_name");
                final String optString35 = jSONObject3.optString("gift_url");
                String optString36 = jSONObject3.optString("props_text");
                this.bjt = optString32;
                this.bju = optString35;
                if (!TextUtils.isEmpty(optString32)) {
                    new AlaLiveMarkData().mark_pic = optString32;
                    BdResourceLoader.getInstance().loadResource(optString32, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.im.a.d.8
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                        public void onLoaded(BdImage bdImage, String str18, int i5) {
                            super.onLoaded((AnonymousClass8) bdImage, str18, i5);
                            Bitmap a2 = d.this.a(bdImage);
                            if (a2 != null && TextUtils.equals(d.this.bjt, optString32)) {
                                CenteredImageSpan centeredImageSpan = new CenteredImageSpan(d.this.mContext, a2);
                                SpannableString spannableString5 = new SpannableString("[img] ");
                                spannableString5.setSpan(centeredImageSpan, 0, spannableString5.length() - 1, 33);
                                spannableStringBuilder.insert(0, (CharSequence) spannableString5);
                                cVar.bfP.setText(spannableStringBuilder);
                                cVar.bfP.forceLayout();
                            }
                        }
                    }, null);
                }
                SpannableString valueOf17 = SpannableString.valueOf(optString33 + str17);
                if (!TextUtils.isEmpty(valueOf17)) {
                    valueOf17.setSpan(new ForegroundColorSpan(-7479041), 0, optString33.length(), 33);
                    valueOf17.setSpan(new ForegroundColorSpan(-5462), optString33.length(), optString33.length() + str17.length(), 33);
                }
                spannableStringBuilder.append((CharSequence) valueOf17);
                String string4 = this.mContext.getString(a.h.ala_pk_props);
                SpannableString valueOf18 = SpannableString.valueOf(string4 + optString34);
                if (!TextUtils.isEmpty(string4)) {
                    valueOf18.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf18.length(), 33);
                }
                spannableStringBuilder.append((CharSequence) valueOf18);
                final SpannableString valueOf19 = SpannableString.valueOf(Constants.ACCEPT_TIME_SEPARATOR_SP + optString36);
                if (!TextUtils.isEmpty(valueOf19)) {
                    valueOf19.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf19.length(), 33);
                }
                spannableStringBuilder.append((CharSequence) valueOf19);
                if (!TextUtils.isEmpty(optString35)) {
                    new AlaLiveMarkData().mark_pic = optString35;
                    BdResourceLoader.getInstance().loadResource(optString35, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.im.a.d.9
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                        public void onLoaded(BdImage bdImage, String str18, int i5) {
                            super.onLoaded((AnonymousClass9) bdImage, str18, i5);
                            Bitmap a2 = d.this.a(bdImage);
                            if (a2 != null && TextUtils.equals(d.this.bju, optString35)) {
                                CenteredImageSpan centeredImageSpan = new CenteredImageSpan(d.this.mContext, a2);
                                SpannableString spannableString5 = new SpannableString("[img] ");
                                spannableString5.setSpan(centeredImageSpan, 0, spannableString5.length() - 1, 33);
                                spannableStringBuilder.insert(spannableStringBuilder.length() - valueOf19.length(), (CharSequence) spannableString5);
                                cVar.bfP.setText(spannableStringBuilder);
                                cVar.bfP.forceLayout();
                            }
                        }
                    }, null);
                }
            } else if (jSONObject3 != null && "pk_mvp_props".equals(str3)) {
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.LF().userId)) {
                    final String optString37 = jSONObject3.optString("pk_image_url");
                    String str18 = this.mContext.getString(a.h.ala_pk_front_props) + this.mContext.getString(a.h.ala_pk_middle_props) + this.mContext.getString(a.h.ala_pk_behind_props);
                    String optString38 = jSONObject3.optString("props_name");
                    final String optString39 = jSONObject3.optString("props_image_url");
                    String optString40 = jSONObject3.optString("props_text");
                    this.bjt = optString37;
                    this.bju = optString39;
                    if (!TextUtils.isEmpty(optString37)) {
                        new AlaLiveMarkData().mark_pic = optString37;
                        BdResourceLoader.getInstance().loadResource(optString37, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.im.a.d.10
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                            public void onLoaded(BdImage bdImage, String str19, int i5) {
                                super.onLoaded((AnonymousClass10) bdImage, str19, i5);
                                Bitmap a2 = d.this.a(bdImage);
                                if (a2 != null && TextUtils.equals(d.this.bjt, optString37)) {
                                    CenteredImageSpan centeredImageSpan = new CenteredImageSpan(d.this.mContext, a2);
                                    SpannableString spannableString5 = new SpannableString("[img] ");
                                    spannableString5.setSpan(centeredImageSpan, 0, spannableString5.length() - 1, 33);
                                    spannableStringBuilder.insert(0, (CharSequence) spannableString5);
                                    cVar.bfP.setText(spannableStringBuilder);
                                    cVar.bfP.forceLayout();
                                }
                            }
                        }, null);
                    }
                    SpannableString valueOf20 = SpannableString.valueOf(str18 + optString38);
                    if (!TextUtils.isEmpty(valueOf20)) {
                        valueOf20.setSpan(new ForegroundColorSpan(-7479041), 0, str18.length() + optString38.length(), 33);
                    }
                    spannableStringBuilder.append((CharSequence) valueOf20);
                    final SpannableString valueOf21 = SpannableString.valueOf(Constants.ACCEPT_TIME_SEPARATOR_SP + optString40);
                    if (!TextUtils.isEmpty(valueOf21)) {
                        valueOf21.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf21.length(), 33);
                    }
                    spannableStringBuilder.append((CharSequence) valueOf21);
                    if (!TextUtils.isEmpty(optString39)) {
                        new AlaLiveMarkData().mark_pic = optString39;
                        BdResourceLoader.getInstance().loadResource(optString39, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.im.a.d.11
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                            public void onLoaded(BdImage bdImage, String str19, int i5) {
                                super.onLoaded((AnonymousClass11) bdImage, str19, i5);
                                Bitmap a2 = d.this.a(bdImage);
                                if (a2 != null && TextUtils.equals(d.this.bju, optString39)) {
                                    CenteredImageSpan centeredImageSpan = new CenteredImageSpan(d.this.mContext, a2);
                                    SpannableString spannableString5 = new SpannableString("[img] ");
                                    spannableString5.setSpan(centeredImageSpan, 0, spannableString5.length() - 1, 33);
                                    spannableStringBuilder.insert(spannableStringBuilder.length() - valueOf21.length(), (CharSequence) spannableString5);
                                    cVar.bfP.setText(spannableStringBuilder);
                                    cVar.bfP.forceLayout();
                                }
                            }
                        }, null);
                    }
                } else if (TbadkCoreApplication.getCurrentAccount() != null && !TbadkCoreApplication.getCurrentAccount().equals(aVar.LF().userId)) {
                    final String optString41 = jSONObject3.optString("pk_image_url");
                    String string5 = this.mContext.getString(a.h.ala_pk_front_props);
                    String optString42 = jSONObject3.optString("user_nickname");
                    String string6 = this.mContext.getString(a.h.ala_pk_behind_props);
                    String optString43 = jSONObject3.optString("props_name");
                    final String optString44 = jSONObject3.optString("props_image_url");
                    this.bjt = optString41;
                    this.bju = optString44;
                    if (!TextUtils.isEmpty(optString41)) {
                        new AlaLiveMarkData().mark_pic = optString41;
                        BdResourceLoader.getInstance().loadResource(optString41, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.im.a.d.2
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                            public void onLoaded(BdImage bdImage, String str19, int i5) {
                                super.onLoaded((AnonymousClass2) bdImage, str19, i5);
                                Bitmap a2 = d.this.a(bdImage);
                                if (a2 != null && TextUtils.equals(d.this.bjt, optString41)) {
                                    CenteredImageSpan centeredImageSpan = new CenteredImageSpan(d.this.mContext, a2);
                                    SpannableString spannableString5 = new SpannableString("[img] ");
                                    spannableString5.setSpan(centeredImageSpan, 0, spannableString5.length() - 1, 33);
                                    spannableStringBuilder.insert(0, (CharSequence) spannableString5);
                                    cVar.bfP.setText(spannableStringBuilder);
                                    cVar.bfP.forceLayout();
                                }
                            }
                        }, null);
                    }
                    SpannableString valueOf22 = SpannableString.valueOf(string5 + optString42 + string6 + optString43);
                    if (!TextUtils.isEmpty(valueOf22)) {
                        valueOf22.setSpan(new ForegroundColorSpan(-7479041), 0, string5.length(), 33);
                        valueOf22.setSpan(new ForegroundColorSpan(-5462), string5.length(), string5.length() + optString42.length(), 33);
                        valueOf22.setSpan(new ForegroundColorSpan(-7479041), string5.length() + optString42.length(), string5.length() + optString42.length() + string6.length() + optString43.length(), 33);
                    }
                    spannableStringBuilder.append((CharSequence) valueOf22);
                    if (!TextUtils.isEmpty(optString44)) {
                        new AlaLiveMarkData().mark_pic = optString44;
                        BdResourceLoader.getInstance().loadResource(optString44, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.im.a.d.3
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                            public void onLoaded(BdImage bdImage, String str19, int i5) {
                                super.onLoaded((AnonymousClass3) bdImage, str19, i5);
                                Bitmap a2 = d.this.a(bdImage);
                                if (a2 != null && TextUtils.equals(d.this.bju, optString44)) {
                                    CenteredImageSpan centeredImageSpan = new CenteredImageSpan(d.this.mContext, a2);
                                    SpannableString spannableString5 = new SpannableString("[img] ");
                                    spannableString5.setSpan(centeredImageSpan, 0, spannableString5.length() - 1, 33);
                                    spannableStringBuilder.insert(spannableStringBuilder.length(), (CharSequence) spannableString5);
                                    cVar.bfP.setText(spannableStringBuilder);
                                    cVar.bfP.forceLayout();
                                }
                            }
                        }, null);
                    }
                }
            } else if (jSONObject3 != null && str3.equals("tying_gift")) {
                jSONObject3.optString("pay_username");
                String optString45 = jSONObject3.optString("tying_gift_name");
                int optInt4 = jSONObject3.optInt("tying_status");
                JSONArray optJSONArray3 = jSONObject3.optJSONArray("gift_member");
                a(spannableStringBuilder, aVar.LF(), cVar, false, false);
                if (optJSONArray3 != null) {
                    int i5 = 0;
                    for (int i6 = 0; i6 < optJSONArray3.length(); i6++) {
                        String optString46 = optJSONArray3.optJSONObject(i6).optString(LogConfig.VALUE_IM_GIFT);
                        if (optString46 != null && optString46.equals("1")) {
                            i5++;
                        }
                    }
                    if (optInt4 == 0) {
                        String string7 = this.mContext.getString(a.h.ala_middle_context);
                        SpannableString valueOf23 = SpannableString.valueOf(string7);
                        if (!TextUtils.isEmpty(valueOf23)) {
                            valueOf23.setSpan(new ForegroundColorSpan(-5864), 0, string7.length(), 33);
                        }
                        spannableStringBuilder.append((CharSequence) valueOf23);
                        SpannableString valueOf24 = SpannableString.valueOf(" " + optString45 + " ");
                        if (!TextUtils.isEmpty(valueOf24)) {
                            valueOf24.setSpan(new ForegroundColorSpan(-5864), 0, valueOf24.length(), 33);
                        }
                        spannableStringBuilder.append((CharSequence) valueOf24);
                        SpannableString valueOf25 = SpannableString.valueOf(this.mContext.getString(a.h.ala_tying_gift));
                        if (!TextUtils.isEmpty(valueOf25)) {
                            valueOf25.setSpan(new ForegroundColorSpan(-5864), 0, valueOf25.length(), 33);
                        }
                        spannableStringBuilder.append((CharSequence) valueOf25);
                        SpannableString valueOf26 = SpannableString.valueOf(i5 + "/" + optJSONArray3.length());
                        if (!TextUtils.isEmpty(valueOf26)) {
                            valueOf26.setSpan(new ForegroundColorSpan(-5864), 0, valueOf26.length(), 33);
                        }
                        spannableStringBuilder.append((CharSequence) valueOf26);
                    } else {
                        String string8 = this.mContext.getString(a.h.ala_tying_gift_middle);
                        SpannableString valueOf27 = SpannableString.valueOf(string8);
                        if (!TextUtils.isEmpty(valueOf27)) {
                            valueOf27.setSpan(new ForegroundColorSpan(-5864), 0, string8.length(), 33);
                        }
                        spannableStringBuilder.append((CharSequence) valueOf27);
                        SpannableString valueOf28 = SpannableString.valueOf(" " + optString45 + " ");
                        if (!TextUtils.isEmpty(valueOf28)) {
                            valueOf28.setSpan(new ForegroundColorSpan(-5864), 0, valueOf28.length(), 33);
                        }
                        spannableStringBuilder.append((CharSequence) valueOf28);
                        SpannableString valueOf29 = SpannableString.valueOf(this.mContext.getString(a.h.ala_tying_gift_behind));
                        if (!TextUtils.isEmpty(valueOf29)) {
                            valueOf29.setSpan(new ForegroundColorSpan(-5864), 0, valueOf29.length(), 33);
                        }
                        spannableStringBuilder.append((CharSequence) valueOf29);
                    }
                }
            }
        }
        return spannableStringBuilder;
    }

    /* loaded from: classes4.dex */
    private static class a extends ClickableSpan {
        private String aFW;
        private String aOL;
        private String aOM;
        private boolean bjB;
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

        public a(Context context, String str, String str2, String str3) {
            this.context = context;
            this.url = str;
            this.aFW = str2;
            this.contentType = str3;
        }

        public a(Context context, String str, String str2, String str3, String str4, String str5, boolean z) {
            this.context = context;
            this.url = str;
            this.contentType = str2;
            this.liveId = str3;
            this.aOM = str4;
            this.aOL = str5;
            this.isHost = z;
        }

        public void setClickable(boolean z) {
            this.bjB = z;
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
                        c = 3;
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
                    bx bxVar = new bx();
                    bxVar.aOL = this.aOL;
                    bxVar.liveId = this.liveId;
                    bxVar.aOM = this.aOM;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, bxVar));
                    return;
                case 1:
                case 2:
                    com.baidu.live.data.b bVar = new com.baidu.live.data.b();
                    bVar.aFW = this.aFW;
                    bVar.url = this.url;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913227, bVar));
                    return;
                case 3:
                    if (this.bjB) {
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

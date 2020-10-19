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
import com.baidu.live.data.br;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.live.view.c;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d extends b {
    private String bip;
    private String biq;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(Context context) {
        super(context, com.baidu.live.im.a.beC);
    }

    @Override // com.baidu.live.im.a.b
    protected void Lh() {
        if (Li()) {
            Lj();
        } else {
            Lk();
        }
    }

    @Override // com.baidu.live.im.a.b
    protected int getColor() {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0518  */
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
        this.bip = null;
        this.biq = null;
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
                                aVar.Lt().level_id = JavaTypesHelper.toInt(str4, 0);
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
                aVar.Lt().level_id = JavaTypesHelper.toInt(str4, 0);
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
                a(spannableStringBuilder, aVar.Lt(), cVar, false, false, false);
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
                a(spannableStringBuilder, aVar.Lt(), cVar, false, false);
                z = false;
                z2 = false;
                i = -7479041;
            } else if (str3.equals(com.baidu.tbadk.TbConfig.TMP_SHARE_DIR_NAME)) {
                str722 = this.mContext.getString(a.i.ala_share_live);
                a(spannableStringBuilder, aVar.Lt(), cVar, false, false);
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
                a(spannableStringBuilder, aVar.Lt(), cVar, false, false);
                z = false;
                z2 = false;
                i = -7479041;
                str722 = str2;
            } else if (str3.equals("live_talk_ban") || str3.equals("live_talk_remove_ban") || str3.equals("live_talk_admin_ban") || str3.equals("live_talk_admin_remove_ban")) {
                a(spannableStringBuilder, aVar.Lt(), cVar, false, false);
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
                a(spannableStringBuilder, aVar.Lt(), cVar, false, false);
                z = false;
                z2 = false;
                i = -7479041;
            } else if (str3.equals("zan_rmb")) {
                if ((aVar instanceof com.baidu.live.im.a) && ((com.baidu.live.im.a) aVar).Ke().equals(aVar.Lt().userId)) {
                    com.baidu.live.view.c cVar2 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_anchor);
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("  ");
                    spannableStringBuilder2.setSpan(cVar2, 0, 1, 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                }
                str722 = this.mContext.getString(a.i.ala_zan_rmb);
                a(spannableStringBuilder, aVar.Lt(), cVar, false, false);
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
            } else if (str3.equals("custom_anchor_identity_update") || str3.equals("custom_master_identity")) {
                str722 = str2;
                z2 = false;
                i = -5864;
                z = false;
            } else if (str3.equals("add_tags_to_anchor")) {
                String str8 = null;
                if (aVar != null && (aVar instanceof com.baidu.live.im.a) && aVar.Lt() != null && TextUtils.equals(aVar.Lt().userId, TbadkCoreApplication.getCurrentAccount())) {
                    str8 = this.mContext.getString(a.i.add_tag_text_yourself);
                }
                a(spannableStringBuilder, aVar.Lt(), cVar, false, false, true, str8);
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
                    spannableStringBuilder.append(com.baidu.live.utils.g.E(str722, i));
                    if (z2) {
                        com.baidu.live.view.c cVar3 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_pk);
                        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("  ");
                        spannableStringBuilder3.setSpan(cVar3, 0, 1, 33);
                        spannableStringBuilder.insert(0, (CharSequence) spannableStringBuilder3);
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
                com.baidu.live.view.c cVar4 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_arrow);
                SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder("  ");
                spannableStringBuilder4.setSpan(cVar4, 1, 2, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder4);
                spannableStringBuilder.setSpan(new a(this.mContext, aVar.getLink(), str3), 0, spannableStringBuilder.length(), 33);
            } else if (TextUtils.equals(str3, "custom_im_notice_live_assistant")) {
                SpannableString valueOf3 = SpannableString.valueOf(str2);
                valueOf3.setSpan(new ForegroundColorSpan(-7479041), 0, str2.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf3);
                com.baidu.live.view.c cVar5 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_arrow);
                SpannableStringBuilder spannableStringBuilder5 = new SpannableStringBuilder("  ");
                spannableStringBuilder5.setSpan(cVar5, 1, 2, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder5);
                spannableStringBuilder.setSpan(new a(this.mContext, aVar.getLink(), str3), 0, spannableStringBuilder.length(), 33);
            } else if (TextUtils.equals(str3, "custom_im_notice_live_assistant")) {
                SpannableString valueOf4 = SpannableString.valueOf(str2);
                valueOf4.setSpan(new ForegroundColorSpan(-7479041), 0, str2.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf4);
                com.baidu.live.view.c cVar6 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_arrow);
                SpannableStringBuilder spannableStringBuilder6 = new SpannableStringBuilder("  ");
                spannableStringBuilder6.setSpan(cVar6, 1, 2, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder6);
                spannableStringBuilder.setSpan(new a(this.mContext, aVar.getLink(), str3), 0, spannableStringBuilder.length(), 33);
            } else if ("send_redpacket".equals(str3) || "start_grab_redpacket".equals(str3)) {
                com.baidu.live.view.c cVar7 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_redpacket);
                SpannableStringBuilder spannableStringBuilder7 = new SpannableStringBuilder("  ");
                spannableStringBuilder7.setSpan(cVar7, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder7);
                a(spannableStringBuilder, aVar.Lt(), cVar, false, false);
                bV(false);
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
                    com.baidu.live.view.c cVar8 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_kaiqiang);
                    SpannableStringBuilder spannableStringBuilder8 = new SpannableStringBuilder("  ");
                    spannableStringBuilder8.setSpan(cVar8, 1, 2, 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder8);
                }
                if (jSONObject4 != null) {
                    spannableStringBuilder.setSpan(new a(this.mContext, aVar.getLink(), str3, jSONObject4.optString("live_id"), jSONObject4.optString("anchor_id"), jSONObject4.optString("red_packet_id"), Lg()), 0, spannableStringBuilder.length(), 33);
                }
            } else if (jSONObject3 != null && "guard_seat".equals(str3)) {
                com.baidu.live.view.c cVar9 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_shouhu);
                SpannableStringBuilder spannableStringBuilder9 = new SpannableStringBuilder("  ");
                spannableStringBuilder9.setSpan(cVar9, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder9);
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
                    com.baidu.live.view.c cVar10 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_arrow);
                    SpannableStringBuilder spannableStringBuilder10 = new SpannableStringBuilder("  ");
                    spannableStringBuilder10.setSpan(cVar10, 1, 2, 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder10);
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
                com.baidu.live.view.c cVar11 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_pk);
                SpannableStringBuilder spannableStringBuilder11 = new SpannableStringBuilder("  ");
                spannableStringBuilder11.setSpan(cVar11, 0, 1, 33);
                spannableStringBuilder.insert(0, (CharSequence) spannableStringBuilder11);
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
                com.baidu.live.view.c cVar12 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_pk);
                SpannableStringBuilder spannableStringBuilder12 = new SpannableStringBuilder("  ");
                spannableStringBuilder12.setSpan(cVar12, 0, 1, 33);
                spannableStringBuilder.insert(0, (CharSequence) spannableStringBuilder12);
            } else if (jSONObject3 != null && "challenge_winner_by_autofail".equals(str3)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = this.mContext.getString(a.i.ala_challenge_winner_by_autofail);
                }
                SpannableString valueOf9 = SpannableString.valueOf(str2);
                valueOf9.setSpan(new ForegroundColorSpan(-5864), 0, str2.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf9, 0, str2.length());
                com.baidu.live.view.c cVar13 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_pk);
                SpannableStringBuilder spannableStringBuilder13 = new SpannableStringBuilder("  ");
                spannableStringBuilder13.setSpan(cVar13, 0, 1, 33);
                spannableStringBuilder.insert(0, (CharSequence) spannableStringBuilder13);
            } else if ("wish_list_success".equals(str3) || "wish_list_finish".equals(str3)) {
                com.baidu.live.view.c cVar14 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_xinyuan);
                SpannableStringBuilder spannableStringBuilder14 = new SpannableStringBuilder("  ");
                spannableStringBuilder14.setSpan(cVar14, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder14);
                SpannableString valueOf10 = SpannableString.valueOf(str2);
                valueOf10.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf10.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf10);
                if (!this.bhU) {
                    com.baidu.live.view.c cVar15 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_zhuli);
                    SpannableStringBuilder spannableStringBuilder15 = new SpannableStringBuilder("  ");
                    spannableStringBuilder15.setSpan(cVar15, 1, 2, 33);
                    spannableStringBuilder.insert(spannableStringBuilder.length(), (CharSequence) spannableStringBuilder15);
                }
                spannableStringBuilder.setSpan(new a(this.mContext, aVar.getLink(), str3), 0, spannableStringBuilder.length(), 33);
            } else if ("start_grab_wheel".equals(str3)) {
                com.baidu.live.view.c cVar16 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_zhuanpan);
                SpannableStringBuilder spannableStringBuilder16 = new SpannableStringBuilder("  ");
                spannableStringBuilder16.setSpan(cVar16, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder16);
                spannableStringBuilder.append(com.baidu.live.utils.g.E(this.mContext.getString(a.i.ala_lucky_tab_tips2), -7479041));
                a(spannableStringBuilder, aVar.Lt(), cVar, false, false);
                bV(false);
                String str10 = "";
                String str11 = "";
                String str12 = "";
                if (jSONObject4 != null) {
                    str10 = jSONObject4.optString(LogConfig.LOG_AMOUNT);
                    str11 = jSONObject4.optString("keywords");
                    str12 = jSONObject4.optString("gift_url");
                }
                spannableStringBuilder.append(com.baidu.live.utils.g.E(String.format(this.mContext.getString(a.i.ala_lucky_tab_tips), str10, str11), -7479041));
                AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                alaLiveMarkData.mark_pic = str12;
                com.baidu.live.view.c cVar17 = new com.baidu.live.view.c(this.mContext, alaLiveMarkData, false, null);
                SpannableStringBuilder spannableStringBuilder17 = new SpannableStringBuilder("  ");
                spannableStringBuilder17.setSpan(cVar17, 1, 2, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder17);
            } else if (TextUtils.equals("guard_club_join", str3)) {
                com.baidu.live.view.c cVar18 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_zhenai);
                SpannableStringBuilder spannableStringBuilder18 = new SpannableStringBuilder("  ");
                spannableStringBuilder18.setSpan(cVar18, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder18);
                spannableStringBuilder.append(com.baidu.live.utils.g.E(this.mContext.getString(a.i.ala_guard_club_join_welcome), -7479041));
                a(spannableStringBuilder, aVar.Lt(), cVar, false, false);
                bV(false);
                spannableStringBuilder.append(com.baidu.live.utils.g.E(this.mContext.getString(a.i.ala_guard_club_join), -7479041));
                if (!this.bhU) {
                    com.baidu.live.view.c cVar19 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_jiaru);
                    SpannableStringBuilder spannableStringBuilder19 = new SpannableStringBuilder("  ");
                    spannableStringBuilder19.setSpan(cVar19, 1, 2, 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder19);
                }
                spannableStringBuilder.setSpan(new a(this.mContext, aVar.getLink(), str3), 0, spannableStringBuilder.length(), 33);
            } else if (jSONObject3 != null && TextUtils.equals(str3, "privilege_award_royal_success")) {
                final String optString11 = jSONObject3.optString("icon_url");
                this.bip = optString11;
                if (!TextUtils.isEmpty(optString11)) {
                    new AlaLiveMarkData().mark_pic = optString11;
                    BdResourceLoader.getInstance().loadResource(optString11, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.im.a.d.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                        public void onLoaded(BdImage bdImage, String str13, int i4) {
                            super.onLoaded((AnonymousClass1) bdImage, str13, i4);
                            Bitmap a2 = d.this.a(bdImage);
                            if (a2 != null && TextUtils.equals(d.this.bip, optString11)) {
                                CenteredImageSpan centeredImageSpan = new CenteredImageSpan(d.this.mContext, a2);
                                SpannableString spannableString = new SpannableString("[img] ");
                                spannableString.setSpan(centeredImageSpan, 0, spannableString.length() - 1, 33);
                                spannableStringBuilder.insert(0, (CharSequence) spannableString);
                                cVar.beR.setText(spannableStringBuilder);
                                cVar.beR.forceLayout();
                            }
                        }
                    }, null);
                }
                a(spannableStringBuilder, aVar.Lt(), cVar, false, false);
                bV(false);
                int optInt2 = jSONObject3.optInt("royal_level");
                String str13 = "";
                if (optInt2 >= 0 && optInt2 <= 7) {
                    str13 = AlaLiveMarkData.NOBLE_LEVEL_NAMES[optInt2];
                }
                if (TextUtils.equals(aVar.Lt().userId, TbadkCoreApplication.getCurrentAccount())) {
                    format = String.format(this.mContext.getString(a.i.txt_im_noble_update_mine), str13);
                } else {
                    format = String.format(this.mContext.getString(a.i.txt_im_noble_update), str13);
                }
                spannableStringBuilder.append(com.baidu.live.utils.g.E(format, -5864));
            } else if (TextUtils.equals("haokan_buy_goods", str3)) {
                com.baidu.live.view.c cVar20 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_viewer_shopping);
                SpannableStringBuilder spannableStringBuilder20 = new SpannableStringBuilder("  ");
                spannableStringBuilder20.setSpan(cVar20, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder20);
                spannableStringBuilder.append(com.baidu.live.utils.g.E(str2, -1));
            } else if (jSONObject3 != null && "activity_gift".equals(str3)) {
                JSONObject optJSONObject = jSONObject3.optJSONObject("content_data");
                a(spannableStringBuilder, aVar.Lt(), cVar, false, false);
                if (optJSONObject != null) {
                    String optString12 = optJSONObject.optString("giftName");
                    String str14 = optJSONObject.optInt("giftNumber") + " ";
                    String optString13 = optJSONObject.optString("giftPic");
                    String str15 = optJSONObject.optDouble("multipleTime") + "";
                    String optString14 = optJSONObject.optString("multipleName");
                    String format2 = String.format(this.mContext.getString(a.i.ala_activity_gift), optString12);
                    String string3 = this.mContext.getString(a.i.ala_activity_contribute);
                    SpannableString valueOf11 = SpannableString.valueOf(format2);
                    if (!TextUtils.isEmpty(format2)) {
                        valueOf11.setSpan(new ForegroundColorSpan(-5864), 0, valueOf11.length(), 33);
                    }
                    spannableStringBuilder.append((CharSequence) valueOf11);
                    if (!TextUtils.isEmpty(optString13)) {
                        AlaLiveMarkData alaLiveMarkData2 = new AlaLiveMarkData();
                        alaLiveMarkData2.mark_pic = optString13;
                        alaLiveMarkData2.isWidthAutoFit = true;
                        com.baidu.live.view.c cVar21 = new com.baidu.live.view.c(this.mContext, alaLiveMarkData2, false, new c.a() { // from class: com.baidu.live.im.a.d.4
                            @Override // com.baidu.live.view.c.a
                            public void d(Bitmap bitmap) {
                                cVar.beR.forceLayout();
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(com.baidu.live.view.c cVar22, Bitmap bitmap) {
                            }
                        });
                        SpannableStringBuilder spannableStringBuilder21 = new SpannableStringBuilder(" [img]");
                        spannableStringBuilder21.setSpan(cVar21, 1, spannableStringBuilder21.length(), 33);
                        spannableStringBuilder.append((CharSequence) spannableStringBuilder21);
                    }
                    if (!TextUtils.isEmpty(str14)) {
                        SpannableString valueOf12 = SpannableString.valueOf("X" + str14 + string3);
                        valueOf12.setSpan(new ForegroundColorSpan(-5864), 0, valueOf12.length(), 33);
                        spannableStringBuilder.append((CharSequence) valueOf12);
                    }
                    if (!TextUtils.isEmpty(str15) && !TextUtils.isEmpty(optString14)) {
                        com.baidu.live.im.view.a aVar3 = new com.baidu.live.im.view.a(this.mContext, str15 + "倍" + optString14, true, false, true);
                        SpannableString spannableString = new SpannableString(" rate");
                        spannableString.setSpan(aVar3, 1, spannableString.length(), 33);
                        spannableStringBuilder.append((CharSequence) spannableString);
                    }
                }
            } else if (jSONObject3 != null && "activity_common_im".equals(str3)) {
                JSONObject optJSONObject2 = jSONObject3.optJSONObject("content_data");
                int optInt3 = optJSONObject2.optInt("is_jump");
                String optString15 = optJSONObject2.optString("left_icon");
                JSONArray optJSONArray = optJSONObject2.optJSONArray("text_array");
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("text_color_array");
                if (!TextUtils.isEmpty(optString15)) {
                    AlaLiveMarkData alaLiveMarkData3 = new AlaLiveMarkData();
                    alaLiveMarkData3.mark_pic = optString15;
                    alaLiveMarkData3.isWidthAutoFit = true;
                    com.baidu.live.view.c cVar22 = new com.baidu.live.view.c(this.mContext, alaLiveMarkData3, false, new c.a() { // from class: com.baidu.live.im.a.d.5
                        @Override // com.baidu.live.view.c.a
                        public void d(Bitmap bitmap) {
                            cVar.beR.forceLayout();
                        }

                        @Override // com.baidu.live.view.c.a
                        public void a(com.baidu.live.view.c cVar23, Bitmap bitmap) {
                        }
                    });
                    SpannableStringBuilder spannableStringBuilder22 = new SpannableStringBuilder(" [img]");
                    spannableStringBuilder22.setSpan(cVar22, 1, spannableStringBuilder22.length(), 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder22);
                }
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("jump_item");
                if (optJSONArray2 != null && optJSONArray != null) {
                    for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                        try {
                            String trim = optJSONArray2.getString(i4).trim();
                            String string4 = optJSONArray.getString(i4);
                            int parseColor = Color.parseColor(trim);
                            SpannableString valueOf13 = SpannableString.valueOf(string4);
                            valueOf13.setSpan(new ForegroundColorSpan(parseColor), 0, valueOf13.length(), 33);
                            spannableStringBuilder.append((CharSequence) valueOf13);
                        } catch (JSONException e11) {
                            e11.printStackTrace();
                        }
                    }
                    if (optJSONObject3 != null) {
                        String optString16 = optJSONObject3.optString("title");
                        String trim2 = optJSONObject3.optString("title_color").trim();
                        String optString17 = optJSONObject3.optString("url");
                        String trim3 = optJSONObject3.optString("bg").trim();
                        String optString18 = optJSONObject3.optString("screen");
                        if (optInt3 == 1 && !TextUtils.isEmpty(optString16) && !TextUtils.isEmpty(optString17)) {
                            com.baidu.live.im.view.a aVar4 = new com.baidu.live.im.view.a(this.mContext, optString16 + " >", false, true, trim3, trim3, trim2);
                            SpannableString spannableString2 = new SpannableString(" click");
                            spannableString2.setSpan(aVar4, 1, spannableString2.length(), 33);
                            spannableStringBuilder.append((CharSequence) spannableString2);
                            a aVar5 = new a(this.mContext, optString17, optString18, str3);
                            aVar5.setClickable(true);
                            spannableStringBuilder.setSpan(aVar5, 0, spannableStringBuilder.length(), 33);
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
                    String optString19 = optJSONObject4.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                    String optString20 = optJSONObject4.optString("text");
                    String optString21 = optJSONObject5.optString("name");
                    String optString22 = optJSONObject5.optString("url");
                    String optString23 = optJSONObject5.optString("screen");
                    SpannableString valueOf14 = SpannableString.valueOf(" " + optString20);
                    if (!TextUtils.isEmpty(optString19)) {
                        AlaLiveMarkData alaLiveMarkData4 = new AlaLiveMarkData();
                        alaLiveMarkData4.mark_pic = optString19;
                        alaLiveMarkData4.isWidthAutoFit = true;
                        com.baidu.live.view.c cVar23 = new com.baidu.live.view.c(this.mContext, alaLiveMarkData4, false, new c.a() { // from class: com.baidu.live.im.a.d.6
                            @Override // com.baidu.live.view.c.a
                            public void d(Bitmap bitmap) {
                                cVar.beR.forceLayout();
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(com.baidu.live.view.c cVar24, Bitmap bitmap) {
                            }
                        });
                        SpannableStringBuilder spannableStringBuilder23 = new SpannableStringBuilder("[img]");
                        spannableStringBuilder23.setSpan(cVar23, 0, spannableStringBuilder23.length(), 33);
                        spannableStringBuilder.append((CharSequence) spannableStringBuilder23);
                    }
                    valueOf14.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf14.length(), 33);
                    spannableStringBuilder.append((CharSequence) valueOf14);
                    if (!TextUtils.isEmpty(optString22)) {
                        com.baidu.live.im.view.a aVar6 = new com.baidu.live.im.view.a(this.mContext, optString21 + " >", false, true, "#FFF5F5F5", "#FFF5F5F5", "#FFA3A3A3");
                        SpannableString spannableString3 = new SpannableString("url");
                        spannableString3.setSpan(aVar6, 0, spannableString3.length(), 33);
                        spannableStringBuilder.append((CharSequence) spannableString3);
                        a aVar7 = new a(this.mContext, optString22, optString23, str3);
                        aVar7.setClickable(true);
                        spannableStringBuilder.setSpan(aVar7, 0, spannableStringBuilder.length(), 33);
                    }
                }
            } else if (jSONObject3 != null && "pk_first_blood".equals(str3)) {
                JSONObject optJSONObject6 = jSONObject3.optJSONObject("first_blood_info");
                String str16 = aVar.Lt().name_show;
                if (optJSONObject6 != null) {
                    String optString24 = optJSONObject6.optString("front_text");
                    String optString25 = optJSONObject6.optString("behind_text");
                    final String optString26 = optJSONObject6.optString("icon_url");
                    this.bip = optString26;
                    if (!TextUtils.isEmpty(optString26)) {
                        new AlaLiveMarkData().mark_pic = optString26;
                        BdResourceLoader.getInstance().loadResource(optString26, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.im.a.d.7
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                            public void onLoaded(BdImage bdImage, String str17, int i5) {
                                super.onLoaded((AnonymousClass7) bdImage, str17, i5);
                                Bitmap a2 = d.this.a(bdImage);
                                if (a2 != null && TextUtils.equals(d.this.bip, optString26)) {
                                    CenteredImageSpan centeredImageSpan = new CenteredImageSpan(d.this.mContext, a2);
                                    SpannableString spannableString4 = new SpannableString("[img] ");
                                    spannableString4.setSpan(centeredImageSpan, 0, spannableString4.length() - 1, 33);
                                    spannableStringBuilder.insert(0, (CharSequence) spannableString4);
                                    cVar.beR.setText(spannableStringBuilder);
                                    cVar.beR.forceLayout();
                                }
                            }
                        }, null);
                    }
                    SpannableString valueOf15 = SpannableString.valueOf(optString24 + str16 + optString25);
                    ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(-5462);
                    ForegroundColorSpan foregroundColorSpan3 = new ForegroundColorSpan(-7479041);
                    valueOf15.setSpan(new ForegroundColorSpan(-7479041), 0, optString24.length(), 33);
                    valueOf15.setSpan(foregroundColorSpan2, optString24.length(), optString24.length() + str16.length(), 33);
                    valueOf15.setSpan(foregroundColorSpan3, str16.length() + optString24.length(), valueOf15.length(), 33);
                    spannableStringBuilder.append((CharSequence) valueOf15);
                }
            } else if (str3 != null && jSONObject3 != null && "pk_send_props".equals(str3)) {
                final String optString27 = jSONObject3.optString("pk_image_url");
                String optString28 = jSONObject3.optString("props_belong_text");
                String str17 = aVar.Lt().name_show;
                String optString29 = jSONObject3.optString("gift_name");
                final String optString30 = jSONObject3.optString("gift_url");
                String optString31 = jSONObject3.optString("props_text");
                this.bip = optString27;
                this.biq = optString30;
                if (!TextUtils.isEmpty(optString27)) {
                    new AlaLiveMarkData().mark_pic = optString27;
                    BdResourceLoader.getInstance().loadResource(optString27, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.im.a.d.8
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                        public void onLoaded(BdImage bdImage, String str18, int i5) {
                            super.onLoaded((AnonymousClass8) bdImage, str18, i5);
                            Bitmap a2 = d.this.a(bdImage);
                            if (a2 != null && TextUtils.equals(d.this.bip, optString27)) {
                                CenteredImageSpan centeredImageSpan = new CenteredImageSpan(d.this.mContext, a2);
                                SpannableString spannableString4 = new SpannableString("[img] ");
                                spannableString4.setSpan(centeredImageSpan, 0, spannableString4.length() - 1, 33);
                                spannableStringBuilder.insert(0, (CharSequence) spannableString4);
                                cVar.beR.setText(spannableStringBuilder);
                                cVar.beR.forceLayout();
                            }
                        }
                    }, null);
                }
                SpannableString valueOf16 = SpannableString.valueOf(optString28 + str17);
                if (!TextUtils.isEmpty(valueOf16)) {
                    valueOf16.setSpan(new ForegroundColorSpan(-7479041), 0, optString28.length(), 33);
                    valueOf16.setSpan(new ForegroundColorSpan(-5462), optString28.length(), optString28.length() + str17.length(), 33);
                }
                spannableStringBuilder.append((CharSequence) valueOf16);
                String string5 = this.mContext.getString(a.i.ala_pk_props);
                SpannableString valueOf17 = SpannableString.valueOf(string5 + optString29);
                if (!TextUtils.isEmpty(string5)) {
                    valueOf17.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf17.length(), 33);
                }
                spannableStringBuilder.append((CharSequence) valueOf17);
                final SpannableString valueOf18 = SpannableString.valueOf(Constants.ACCEPT_TIME_SEPARATOR_SP + optString31);
                if (!TextUtils.isEmpty(valueOf18)) {
                    valueOf18.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf18.length(), 33);
                }
                spannableStringBuilder.append((CharSequence) valueOf18);
                if (!TextUtils.isEmpty(optString30)) {
                    new AlaLiveMarkData().mark_pic = optString30;
                    BdResourceLoader.getInstance().loadResource(optString30, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.im.a.d.9
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                        public void onLoaded(BdImage bdImage, String str18, int i5) {
                            super.onLoaded((AnonymousClass9) bdImage, str18, i5);
                            Bitmap a2 = d.this.a(bdImage);
                            if (a2 != null && TextUtils.equals(d.this.biq, optString30)) {
                                CenteredImageSpan centeredImageSpan = new CenteredImageSpan(d.this.mContext, a2);
                                SpannableString spannableString4 = new SpannableString("[img] ");
                                spannableString4.setSpan(centeredImageSpan, 0, spannableString4.length() - 1, 33);
                                spannableStringBuilder.insert(spannableStringBuilder.length() - valueOf18.length(), (CharSequence) spannableString4);
                                cVar.beR.setText(spannableStringBuilder);
                                cVar.beR.forceLayout();
                            }
                        }
                    }, null);
                }
            } else if (jSONObject3 != null && "pk_mvp_props".equals(str3)) {
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.Lt().userId)) {
                    final String optString32 = jSONObject3.optString("pk_image_url");
                    String str18 = this.mContext.getString(a.i.ala_pk_front_props) + this.mContext.getString(a.i.ala_pk_middle_props) + this.mContext.getString(a.i.ala_pk_behind_props);
                    String optString33 = jSONObject3.optString("props_name");
                    final String optString34 = jSONObject3.optString("props_image_url");
                    String optString35 = jSONObject3.optString("props_text");
                    this.bip = optString32;
                    this.biq = optString34;
                    if (!TextUtils.isEmpty(optString32)) {
                        new AlaLiveMarkData().mark_pic = optString32;
                        BdResourceLoader.getInstance().loadResource(optString32, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.im.a.d.10
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                            public void onLoaded(BdImage bdImage, String str19, int i5) {
                                super.onLoaded((AnonymousClass10) bdImage, str19, i5);
                                Bitmap a2 = d.this.a(bdImage);
                                if (a2 != null && TextUtils.equals(d.this.bip, optString32)) {
                                    CenteredImageSpan centeredImageSpan = new CenteredImageSpan(d.this.mContext, a2);
                                    SpannableString spannableString4 = new SpannableString("[img] ");
                                    spannableString4.setSpan(centeredImageSpan, 0, spannableString4.length() - 1, 33);
                                    spannableStringBuilder.insert(0, (CharSequence) spannableString4);
                                    cVar.beR.setText(spannableStringBuilder);
                                    cVar.beR.forceLayout();
                                }
                            }
                        }, null);
                    }
                    SpannableString valueOf19 = SpannableString.valueOf(str18 + optString33);
                    if (!TextUtils.isEmpty(valueOf19)) {
                        valueOf19.setSpan(new ForegroundColorSpan(-7479041), 0, str18.length() + optString33.length(), 33);
                    }
                    spannableStringBuilder.append((CharSequence) valueOf19);
                    final SpannableString valueOf20 = SpannableString.valueOf(Constants.ACCEPT_TIME_SEPARATOR_SP + optString35);
                    if (!TextUtils.isEmpty(valueOf20)) {
                        valueOf20.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf20.length(), 33);
                    }
                    spannableStringBuilder.append((CharSequence) valueOf20);
                    if (!TextUtils.isEmpty(optString34)) {
                        new AlaLiveMarkData().mark_pic = optString34;
                        BdResourceLoader.getInstance().loadResource(optString34, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.im.a.d.11
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                            public void onLoaded(BdImage bdImage, String str19, int i5) {
                                super.onLoaded((AnonymousClass11) bdImage, str19, i5);
                                Bitmap a2 = d.this.a(bdImage);
                                if (a2 != null && TextUtils.equals(d.this.biq, optString34)) {
                                    CenteredImageSpan centeredImageSpan = new CenteredImageSpan(d.this.mContext, a2);
                                    SpannableString spannableString4 = new SpannableString("[img] ");
                                    spannableString4.setSpan(centeredImageSpan, 0, spannableString4.length() - 1, 33);
                                    spannableStringBuilder.insert(spannableStringBuilder.length() - valueOf20.length(), (CharSequence) spannableString4);
                                    cVar.beR.setText(spannableStringBuilder);
                                    cVar.beR.forceLayout();
                                }
                            }
                        }, null);
                    }
                } else if (TbadkCoreApplication.getCurrentAccount() != null && !TbadkCoreApplication.getCurrentAccount().equals(aVar.Lt().userId)) {
                    final String optString36 = jSONObject3.optString("pk_image_url");
                    String string6 = this.mContext.getString(a.i.ala_pk_front_props);
                    String optString37 = jSONObject3.optString("user_nickname");
                    String string7 = this.mContext.getString(a.i.ala_pk_behind_props);
                    String optString38 = jSONObject3.optString("props_name");
                    final String optString39 = jSONObject3.optString("props_image_url");
                    this.bip = optString36;
                    this.biq = optString39;
                    if (!TextUtils.isEmpty(optString36)) {
                        new AlaLiveMarkData().mark_pic = optString36;
                        BdResourceLoader.getInstance().loadResource(optString36, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.im.a.d.2
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                            public void onLoaded(BdImage bdImage, String str19, int i5) {
                                super.onLoaded((AnonymousClass2) bdImage, str19, i5);
                                Bitmap a2 = d.this.a(bdImage);
                                if (a2 != null && TextUtils.equals(d.this.bip, optString36)) {
                                    CenteredImageSpan centeredImageSpan = new CenteredImageSpan(d.this.mContext, a2);
                                    SpannableString spannableString4 = new SpannableString("[img] ");
                                    spannableString4.setSpan(centeredImageSpan, 0, spannableString4.length() - 1, 33);
                                    spannableStringBuilder.insert(0, (CharSequence) spannableString4);
                                    cVar.beR.setText(spannableStringBuilder);
                                    cVar.beR.forceLayout();
                                }
                            }
                        }, null);
                    }
                    SpannableString valueOf21 = SpannableString.valueOf(string6 + optString37 + string7 + optString38);
                    if (!TextUtils.isEmpty(valueOf21)) {
                        valueOf21.setSpan(new ForegroundColorSpan(-7479041), 0, string6.length(), 33);
                        valueOf21.setSpan(new ForegroundColorSpan(-5462), string6.length(), string6.length() + optString37.length(), 33);
                        valueOf21.setSpan(new ForegroundColorSpan(-7479041), string6.length() + optString37.length(), string6.length() + optString37.length() + string7.length() + optString38.length(), 33);
                    }
                    spannableStringBuilder.append((CharSequence) valueOf21);
                    if (!TextUtils.isEmpty(optString39)) {
                        new AlaLiveMarkData().mark_pic = optString39;
                        BdResourceLoader.getInstance().loadResource(optString39, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.im.a.d.3
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                            public void onLoaded(BdImage bdImage, String str19, int i5) {
                                super.onLoaded((AnonymousClass3) bdImage, str19, i5);
                                Bitmap a2 = d.this.a(bdImage);
                                if (a2 != null && TextUtils.equals(d.this.biq, optString39)) {
                                    CenteredImageSpan centeredImageSpan = new CenteredImageSpan(d.this.mContext, a2);
                                    SpannableString spannableString4 = new SpannableString("[img] ");
                                    spannableString4.setSpan(centeredImageSpan, 0, spannableString4.length() - 1, 33);
                                    spannableStringBuilder.insert(spannableStringBuilder.length(), (CharSequence) spannableString4);
                                    cVar.beR.setText(spannableStringBuilder);
                                    cVar.beR.forceLayout();
                                }
                            }
                        }, null);
                    }
                }
            }
        }
        return spannableStringBuilder;
    }

    /* loaded from: classes4.dex */
    private static class a extends ClickableSpan {
        private String aGJ;
        private String aOQ;
        private String aOR;
        private boolean bix;
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
            this.aGJ = str2;
            this.contentType = str3;
        }

        public a(Context context, String str, String str2, String str3, String str4, String str5, boolean z) {
            this.context = context;
            this.url = str;
            this.contentType = str2;
            this.liveId = str3;
            this.aOR = str4;
            this.aOQ = str5;
            this.isHost = z;
        }

        public void setClickable(boolean z) {
            this.bix = z;
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
                    br brVar = new br();
                    brVar.aOQ = this.aOQ;
                    brVar.liveId = this.liveId;
                    brVar.aOR = this.aOR;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, brVar));
                    return;
                case 1:
                case 2:
                    com.baidu.live.data.b bVar = new com.baidu.live.data.b();
                    bVar.aGJ = this.aGJ;
                    bVar.url = this.url;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913227, bVar));
                    return;
                case 3:
                    if (this.bix) {
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

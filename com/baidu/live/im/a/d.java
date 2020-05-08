package com.baidu.live.im.a;

import android.content.Context;
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
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.ax;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.u.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends b {
    /* JADX INFO: Access modifiers changed from: protected */
    public d(Context context) {
        super(context, com.baidu.live.im.a.aJx);
    }

    @Override // com.baidu.live.im.a.b
    protected void BE() {
        if (BF()) {
            BG();
        } else {
            BH();
        }
    }

    @Override // com.baidu.live.im.a.b
    protected int getColor() {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:164:0x040a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0112  */
    @Override // com.baidu.live.im.a.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected SpannableStringBuilder a(com.baidu.live.im.data.a aVar, com.baidu.live.im.c cVar) {
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
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
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
                                aVar.Ce().level_id = JavaTypesHelper.toInt(str4, 0);
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
                aVar.Ce().level_id = JavaTypesHelper.toInt(str4, 0);
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
                a(spannableStringBuilder, aVar.Ce(), cVar, false, false, false);
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
                a(spannableStringBuilder, aVar.Ce(), cVar, false, false);
                z = false;
                z2 = false;
                i = -7479041;
            } else if (str3.equals(com.baidu.tbadk.TbConfig.TMP_SHARE_DIR_NAME)) {
                str722 = this.mContext.getString(a.i.ala_share_live);
                a(spannableStringBuilder, aVar.Ce(), cVar, false, false);
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
                a(spannableStringBuilder, aVar.Ce(), cVar, false, false);
                z = false;
                z2 = false;
                i = -7479041;
                str722 = str2;
            } else if (str3.equals("live_talk_ban") || str3.equals("live_talk_remove_ban") || str3.equals("live_talk_admin_ban") || str3.equals("live_talk_admin_remove_ban")) {
                a(spannableStringBuilder, aVar.Ce(), cVar, false, false);
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
                a(spannableStringBuilder, aVar.Ce(), cVar, false, false);
                z = false;
                z2 = false;
                i = -7479041;
            } else if (str3.equals("zan_rmb")) {
                str722 = this.mContext.getString(a.i.ala_zan_rmb);
                a(spannableStringBuilder, aVar.Ce(), cVar, false, false);
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
            } else if (str3.equals("wish_list_success") || str3.equals("wish_list_finish")) {
                z = true;
                z2 = false;
                i = -30312;
            } else if (str3.equals("custom_anchor_identity_update") || str3.equals("custom_master_identity")) {
                str722 = str2;
                z2 = false;
                i = -5864;
                z = false;
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
                    spannableStringBuilder.append(com.baidu.live.utils.f.z(str722, i));
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
            } else if ("send_redpacket".equals(str3) || "start_grab_redpacket".equals(str3)) {
                com.baidu.live.view.c cVar5 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_redpacket);
                SpannableStringBuilder spannableStringBuilder5 = new SpannableStringBuilder("  ");
                spannableStringBuilder5.setSpan(cVar5, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder5);
                a(spannableStringBuilder, aVar.Ce(), cVar, false, false);
                by(false);
                if ("send_redpacket".equals(str3)) {
                    String str8 = "";
                    if (jSONObject4 != null) {
                        str8 = jSONObject4.optString(LogConfig.LOG_AMOUNT);
                    }
                    string = String.format(this.mContext.getString(a.i.ala_send_redpacket), str8);
                } else {
                    string = "start_grab_redpacket".equals(str3) ? this.mContext.getString(a.i.ala_start_grab_redpacket) : str722;
                }
                SpannableString valueOf4 = SpannableString.valueOf(string);
                valueOf4.setSpan(new ForegroundColorSpan(-5864), 0, valueOf4.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf4);
                if ("start_grab_redpacket".equals(str3)) {
                    com.baidu.live.view.c cVar6 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_kaiqiang);
                    SpannableStringBuilder spannableStringBuilder6 = new SpannableStringBuilder("  ");
                    spannableStringBuilder6.setSpan(cVar6, 1, 2, 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder6);
                }
                if (jSONObject4 != null) {
                    spannableStringBuilder.setSpan(new a(this.mContext, aVar.getLink(), str3, jSONObject4.optString("live_id"), jSONObject4.optString("anchor_id"), jSONObject4.optString("red_packet_id"), BD()), 0, spannableStringBuilder.length(), 33);
                }
            } else if (jSONObject3 != null && "guard_seat".equals(str3)) {
                com.baidu.live.view.c cVar7 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_shouhu);
                SpannableStringBuilder spannableStringBuilder7 = new SpannableStringBuilder("  ");
                spannableStringBuilder7.setSpan(cVar7, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder7);
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
                SpannableString valueOf5 = SpannableString.valueOf(sb2);
                valueOf5.setSpan(new ForegroundColorSpan(-5864), 0, sb2.length(), 33);
                if (!TextUtils.isEmpty(optString3)) {
                    valueOf5.setSpan(new ForegroundColorSpan(-5462), optString2.length() + 1, optString2.length() + 1 + optString3.length(), 33);
                }
                spannableStringBuilder.append((CharSequence) valueOf5, 0, sb2.length());
                boolean z3 = jSONObject3.optInt("is_jump") == 1;
                if (z3) {
                    com.baidu.live.view.c cVar8 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_arrow);
                    SpannableStringBuilder spannableStringBuilder8 = new SpannableStringBuilder("  ");
                    spannableStringBuilder8.setSpan(cVar8, 1, 2, 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder8);
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
                SpannableString valueOf6 = SpannableString.valueOf(sb4);
                valueOf6.setSpan(new ForegroundColorSpan(-5864), 0, sb4.length(), 33);
                if (foregroundColorSpan != null) {
                    valueOf6.setSpan(foregroundColorSpan, i2, i3, 33);
                }
                spannableStringBuilder.append((CharSequence) valueOf6, 0, sb4.length());
                com.baidu.live.view.c cVar9 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_pk);
                SpannableStringBuilder spannableStringBuilder9 = new SpannableStringBuilder("  ");
                spannableStringBuilder9.setSpan(cVar9, 0, 1, 33);
                spannableStringBuilder.insert(0, (CharSequence) spannableStringBuilder9);
            } else if ("wish_list_success".equals(str3) || "wish_list_finish".equals(str3)) {
                com.baidu.live.view.c cVar10 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_xinyuan);
                SpannableStringBuilder spannableStringBuilder10 = new SpannableStringBuilder("  ");
                spannableStringBuilder10.setSpan(cVar10, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder10);
                SpannableString valueOf7 = SpannableString.valueOf(str2);
                valueOf7.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf7.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf7);
                if (!this.aMw) {
                    com.baidu.live.view.c cVar11 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_zhuli);
                    SpannableStringBuilder spannableStringBuilder11 = new SpannableStringBuilder("  ");
                    spannableStringBuilder11.setSpan(cVar11, 1, 2, 33);
                    spannableStringBuilder.insert(spannableStringBuilder.length(), (CharSequence) spannableStringBuilder11);
                }
                spannableStringBuilder.setSpan(new a(this.mContext, aVar.getLink(), str3), 0, spannableStringBuilder.length(), 33);
            } else if ("start_grab_wheel".equals(str3)) {
                com.baidu.live.view.c cVar12 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_zhuanpan);
                SpannableStringBuilder spannableStringBuilder12 = new SpannableStringBuilder("  ");
                spannableStringBuilder12.setSpan(cVar12, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder12);
                spannableStringBuilder.append(com.baidu.live.utils.f.z(this.mContext.getString(a.i.ala_lucky_tab_tips2), -7479041));
                a(spannableStringBuilder, aVar.Ce(), cVar, false, false);
                by(false);
                String str9 = "";
                String str10 = "";
                String str11 = "";
                if (jSONObject4 != null) {
                    str9 = jSONObject4.optString(LogConfig.LOG_AMOUNT);
                    str10 = jSONObject4.optString("keywords");
                    str11 = jSONObject4.optString("gift_url");
                }
                spannableStringBuilder.append(com.baidu.live.utils.f.z(String.format(this.mContext.getString(a.i.ala_lucky_tab_tips), str9, str10), -7479041));
                AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                alaLiveMarkData.mark_pic = str11;
                com.baidu.live.view.c cVar13 = new com.baidu.live.view.c(this.mContext, alaLiveMarkData, false, null);
                SpannableStringBuilder spannableStringBuilder13 = new SpannableStringBuilder("  ");
                spannableStringBuilder13.setSpan(cVar13, 1, 2, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder13);
            } else if (TextUtils.equals("guard_club_join", str3)) {
                com.baidu.live.view.c cVar14 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_zhenai);
                SpannableStringBuilder spannableStringBuilder14 = new SpannableStringBuilder("  ");
                spannableStringBuilder14.setSpan(cVar14, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder14);
                spannableStringBuilder.append(com.baidu.live.utils.f.z(this.mContext.getString(a.i.ala_guard_club_join_welcome), -7479041));
                a(spannableStringBuilder, aVar.Ce(), cVar, false, false);
                by(false);
                spannableStringBuilder.append(com.baidu.live.utils.f.z(this.mContext.getString(a.i.ala_guard_club_join), -7479041));
                if (!this.aMw) {
                    com.baidu.live.view.c cVar15 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_jiaru);
                    SpannableStringBuilder spannableStringBuilder15 = new SpannableStringBuilder("  ");
                    spannableStringBuilder15.setSpan(cVar15, 1, 2, 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder15);
                }
                spannableStringBuilder.setSpan(new a(this.mContext, aVar.getLink(), str3), 0, spannableStringBuilder.length(), 33);
            } else if (TextUtils.equals("haokan_buy_goods", str3)) {
                com.baidu.live.view.c cVar16 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_viewer_shopping);
                SpannableStringBuilder spannableStringBuilder16 = new SpannableStringBuilder("  ");
                spannableStringBuilder16.setSpan(cVar16, 0, 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder16);
                spannableStringBuilder.append(com.baidu.live.utils.f.z(str2, -1));
            }
        }
        return spannableStringBuilder;
    }

    /* loaded from: classes3.dex */
    private static class a extends ClickableSpan {
        private boolean aMK;
        private String awi;
        private String awj;
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
            this.awj = str4;
            this.awi = str5;
            this.isHost = z;
        }

        public void setClickable(boolean z) {
            this.aMK = z;
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
                    ax axVar = new ax();
                    axVar.awi = this.awi;
                    axVar.liveId = this.liveId;
                    axVar.awj = this.awj;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, axVar));
                    return;
                case 1:
                    if (this.aMK) {
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
}

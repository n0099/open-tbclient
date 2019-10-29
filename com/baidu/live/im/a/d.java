package com.baidu.live.im.a;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.live.adp.base.IScrollableHelper;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.tbadk.TbConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d extends b {
    /* JADX INFO: Access modifiers changed from: protected */
    public d(Context context) {
        super(context, com.baidu.live.im.a.aeK);
    }

    @Override // com.baidu.live.im.a.b
    protected void sZ() {
        if (ta()) {
            tb();
        } else {
            tc();
        }
    }

    @Override // com.baidu.live.im.a.b
    protected int getColor() {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0256  */
    @Override // com.baidu.live.im.a.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected SpannableStringBuilder a(com.baidu.live.im.data.a aVar, com.baidu.live.im.c cVar) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        int i;
        JSONObject jSONObject;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String str6 = "";
        int color = TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_im_official_color);
        try {
            if (aVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) aVar.getObjContent();
            } else {
                jSONObject = new JSONObject(aVar.getContent());
            }
            String optString = jSONObject.optString("content_type");
            try {
                str6 = jSONObject.optString("text");
                str4 = jSONObject.optString("level_id");
                str3 = str6;
                str5 = optString;
            } catch (JSONException e) {
                str = str6;
                str2 = optString;
                str3 = str;
                str4 = "";
                str5 = str2;
                if (!TextUtils.isEmpty(str4)) {
                    aVar.te().level_id = JavaTypesHelper.toInt(str4, 0);
                }
                if (str5 != null) {
                }
                if (!TextUtils.isEmpty(aVar.getLink())) {
                }
                return spannableStringBuilder;
            }
        } catch (JSONException e2) {
            str = "";
            str2 = null;
        }
        if (!TextUtils.isEmpty(str4) && JavaTypesHelper.toInt(str4, 0) > 0) {
            aVar.te().level_id = JavaTypesHelper.toInt(str4, 0);
        }
        if (str5 != null) {
            str3 = aVar.getContent();
        } else if (str5.equals("enter_live")) {
            i = ta() ? -1647769 : TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_cont_d);
            String string = TextUtils.isEmpty(null) ? this.mContext.getString(a.i.ala_enter_live) : null;
            a(spannableStringBuilder, aVar.te(), cVar, false, false, false);
            str3 = string;
            color = i;
        } else if (!str5.equals("backstage_live") && !str5.equals("offline_type")) {
            if (str5.equals("close_live")) {
                str3 = this.mContext.getString(a.i.ala_close_live);
            } else if (str5.equals("follow_anchor")) {
                i = ta() ? -1647769 : color;
                str3 = this.mContext.getString(a.i.ala_follow_live);
                a(spannableStringBuilder, aVar.te(), cVar, false, false);
                color = i;
            } else if (str5.equals(TbConfig.TMP_SHARE_DIR_NAME)) {
                i = ta() ? -1647769 : color;
                str3 = this.mContext.getString(a.i.ala_share_live);
                a(spannableStringBuilder, aVar.te(), cVar, false, false);
                color = i;
            } else if (!str5.equals("share_tieba") && !str5.equals("remove_video") && !str5.equals("ueg_warn")) {
                if (str5.equals("live_admin")) {
                    a(spannableStringBuilder, aVar.te(), cVar, false, false);
                } else if (str5.equals("live_talk_ban")) {
                    a(spannableStringBuilder, aVar.te(), cVar, false, false);
                } else if (!str5.equals("challenge_direct_start") && !str5.equals("challenge_direct_matched") && !str5.equals("challenge_random_start") && !str5.equals("challenge_random_matched") && !str5.equals("avts") && !str5.equals("allin")) {
                    if (str5.equals("share_rmb")) {
                        i = ta() ? -1647769 : color;
                        str3 = this.mContext.getString(a.i.ala_share_rmb);
                        a(spannableStringBuilder, aVar.te(), cVar, false, false);
                        color = i;
                    } else if (str5.equals("zan_rmb")) {
                        i = ta() ? -1647769 : color;
                        str3 = this.mContext.getString(a.i.ala_zan_rmb);
                        a(spannableStringBuilder, aVar.te(), cVar, false, false);
                        color = i;
                    } else if (str5.equals("guard_club_join")) {
                        color = -22844;
                        String string2 = this.mContext.getString(a.i.ala_guard_club_join);
                        str3 = (aVar.te() == null || TextUtils.isEmpty(aVar.te().getNameShow())) ? String.format(string2, "") : String.format(string2, "【" + aVar.te().getNameShow() + "】");
                    } else {
                        str3 = aVar.getContent();
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(aVar.getLink())) {
            spannableStringBuilder.append(com.baidu.live.utils.e.o(str3, color));
        } else {
            SpannableString valueOf = SpannableString.valueOf(str3);
            valueOf.setSpan(new a(this.mContext, aVar.getLink()), 0, str3.length(), 33);
            spannableStringBuilder.append((CharSequence) valueOf);
        }
        return spannableStringBuilder;
    }

    /* loaded from: classes6.dex */
    private static class a extends ClickableSpan {
        private String url;

        public a(Context context, String str) {
            this.url = str;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (1 == b.ahb) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_im_attention_color));
            } else if (2 == b.ahb) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_link_tip_a));
            }
            textPaint.setUnderlineText(true);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (!TextUtils.isEmpty(this.url)) {
                UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(view.getContext()), new String[]{this.url}, true);
            }
        }
    }
}

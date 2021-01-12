package com.baidu.live.yuyinim.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.gift.aj;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.view.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends b {
    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context) {
        super(context, com.baidu.live.im.a.bgE);
    }

    @Override // com.baidu.live.yuyinim.a.b
    protected void Jb() {
        if (Jc()) {
            Jd();
        } else {
            Je();
        }
    }

    @Override // com.baidu.live.yuyinim.a.b
    protected int getColor() {
        if (Jc()) {
            return -19840;
        }
        return TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_other_b);
    }

    @Override // com.baidu.live.yuyinim.a.b
    protected SpannableStringBuilder a(com.baidu.live.im.data.b bVar, final com.baidu.live.yuyinim.a aVar) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        a(spannableStringBuilder, bVar.JB(), aVar, false, false);
        a D = D(bVar);
        String string = (D == null || TextUtils.isEmpty(D.giftName)) ? this.mContext.getString(a.h.sdk_gift) : D.giftName;
        SpannableString valueOf = SpannableString.valueOf("送给");
        valueOf.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf.length(), 33);
        spannableStringBuilder.append((CharSequence) valueOf);
        SpannableString valueOf2 = SpannableString.valueOf(" " + bVar.blP + " ");
        valueOf2.setSpan(new ForegroundColorSpan(-5462), 0, valueOf2.length(), 33);
        spannableStringBuilder.append((CharSequence) valueOf2);
        SpannableString valueOf3 = SpannableString.valueOf(string);
        valueOf3.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf3.length(), 33);
        spannableStringBuilder.append((CharSequence) valueOf3);
        if (D != null && !TextUtils.isEmpty(D.aTL)) {
            AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
            alaLiveMarkData.mark_pic = D.aTL;
            alaLiveMarkData.isWidthAutoFit = true;
            com.baidu.live.view.b bVar2 = new com.baidu.live.view.b(this.mContext, alaLiveMarkData, false, new b.a() { // from class: com.baidu.live.yuyinim.a.c.1
                @Override // com.baidu.live.view.b.a
                public void e(Bitmap bitmap) {
                    aVar.bgU.forceLayout();
                }

                @Override // com.baidu.live.view.b.a
                public void a(com.baidu.live.view.b bVar3, Bitmap bitmap) {
                }
            });
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" [img]");
            spannableStringBuilder2.setSpan(bVar2, 1, spannableStringBuilder2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        }
        a(spannableStringBuilder, D);
        return spannableStringBuilder;
    }

    private void a(SpannableStringBuilder spannableStringBuilder, a aVar) {
        if (aVar != null) {
            String str = !TextUtils.isEmpty(aVar.bkD) ? aVar.bkD : "1";
            String str2 = !TextUtils.isEmpty(aVar.bkE) ? aVar.bkE : "1";
            if (!TextUtils.isEmpty(str)) {
                SpannableString valueOf = SpannableString.valueOf("×" + str);
                valueOf.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf);
            }
            if (this.bko && !aVar.bjp && !TextUtils.isEmpty(str2)) {
                SpannableString valueOf2 = SpannableString.valueOf(String.format(this.mContext.getString(a.h.ala_rec_gift_charm_value), str2));
                valueOf2.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf2.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf2);
            }
            if (aj.fU(aVar.giftId) && !aj.fS(aVar.giftId) && aj.fT(aVar.giftId)) {
                SpannableString valueOf3 = SpannableString.valueOf(this.mContext.getString(a.h.ala_dynamic_gift_downloading));
                valueOf3.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf3.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf3);
            }
            if (!aVar.bjp && aVar.bjo > 0.0d) {
                com.baidu.live.yuyinim.view.a aVar2 = new com.baidu.live.yuyinim.view.a(this.mContext, aVar.bjo + "倍");
                SpannableString spannableString = new SpannableString(" rate");
                spannableString.setSpan(aVar2, 1, spannableString.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableString);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00a3 A[Catch: JSONException -> 0x00d2, TryCatch #0 {JSONException -> 0x00d2, blocks: (B:3:0x0003, B:5:0x000b, B:6:0x0012, B:8:0x0057, B:9:0x0071, B:12:0x007b, B:14:0x008b, B:16:0x0091, B:17:0x009b, B:19:0x00a3, B:21:0x00ae, B:23:0x00b6, B:30:0x00d7, B:26:0x00cc, B:25:0x00c0), top: B:32:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private a D(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        boolean z = true;
        try {
            if (bVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) bVar.getObjContent();
            } else {
                jSONObject = new JSONObject(bVar.getContent());
            }
            a aVar = new a();
            aVar.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            aVar.bYS = jSONObject.optBoolean("is_owner");
            aVar.room_name = jSONObject.optString(DpStatConstants.KEY_ROOM_NAME);
            aVar.bkD = bVar.JJ() + "";
            if (bVar.JL() > 0) {
                aVar.bkE = bVar.JL() + "";
            } else {
                aVar.bkE = "";
            }
            aVar.bjp = jSONObject.optInt("is_free") == 1;
            aVar.bjo = bVar.JK();
            com.baidu.live.gift.g fQ = aj.fQ(aVar.giftId);
            if (fQ != null) {
                if (fQ.CL()) {
                    aVar.giftName = this.mContext.getString(a.h.sdk_text_gift_graffiti);
                    if (TextUtils.isEmpty(aVar.giftName)) {
                        aVar.giftName = jSONObject.optString("gift_name");
                    }
                    if (z && TextUtils.isEmpty(aVar.aTL)) {
                        aVar.aTL = jSONObject.optString("gift_url");
                        return aVar;
                    }
                }
                aVar.giftName = fQ.CD();
                aVar.aTL = fQ.getThumbnail_url();
            }
            z = false;
            if (TextUtils.isEmpty(aVar.giftName)) {
            }
            return z ? aVar : aVar;
        } catch (JSONException e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        public String aTL;
        public boolean bYS;
        public double bjo;
        public boolean bjp;
        public String bkD;
        public String bkE;
        public String giftId;
        public String giftName;
        public String room_name;

        private a() {
        }
    }
}

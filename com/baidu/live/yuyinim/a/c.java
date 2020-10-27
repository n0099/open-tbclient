package com.baidu.live.yuyinim.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.gift.ai;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.view.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends b {
    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context) {
        super(context, com.baidu.live.im.a.bfR);
    }

    @Override // com.baidu.live.yuyinim.a.b
    protected void LB() {
        if (LC()) {
            LD();
        } else {
            LE();
        }
    }

    @Override // com.baidu.live.yuyinim.a.b
    protected int getColor() {
        if (LC()) {
            return -19840;
        }
        return TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_other_b);
    }

    @Override // com.baidu.live.yuyinim.a.b
    protected SpannableStringBuilder a(com.baidu.live.im.data.a aVar, final com.baidu.live.yuyinim.a aVar2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        a(spannableStringBuilder, aVar.LO(), aVar2, false, false);
        a z = z(aVar);
        String string = (z == null || TextUtils.isEmpty(z.giftName)) ? this.mContext.getString(a.i.sdk_gift) : z.giftName;
        SpannableString valueOf = SpannableString.valueOf("送给");
        valueOf.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf.length(), 33);
        spannableStringBuilder.append((CharSequence) valueOf);
        SpannableString valueOf2 = SpannableString.valueOf(" " + aVar.bkn + " ");
        valueOf2.setSpan(new ForegroundColorSpan(-5462), 0, valueOf2.length(), 33);
        spannableStringBuilder.append((CharSequence) valueOf2);
        SpannableString valueOf3 = SpannableString.valueOf(string);
        valueOf3.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf3.length(), 33);
        spannableStringBuilder.append((CharSequence) valueOf3);
        if (z != null && !TextUtils.isEmpty(z.aUh)) {
            AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
            alaLiveMarkData.mark_pic = z.aUh;
            alaLiveMarkData.isWidthAutoFit = true;
            com.baidu.live.view.c cVar = new com.baidu.live.view.c(this.mContext, alaLiveMarkData, false, new c.a() { // from class: com.baidu.live.yuyinim.a.c.1
                @Override // com.baidu.live.view.c.a
                public void d(Bitmap bitmap) {
                    aVar2.bgh.forceLayout();
                }

                @Override // com.baidu.live.view.c.a
                public void a(com.baidu.live.view.c cVar2, Bitmap bitmap) {
                }
            });
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" [img]");
            spannableStringBuilder2.setSpan(cVar, 1, spannableStringBuilder2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        }
        a(spannableStringBuilder, z);
        return spannableStringBuilder;
    }

    private void a(SpannableStringBuilder spannableStringBuilder, a aVar) {
        if (aVar != null) {
            String str = !TextUtils.isEmpty(aVar.bjC) ? aVar.bjC : "1";
            String str2 = !TextUtils.isEmpty(aVar.bjD) ? aVar.bjD : "1";
            if (!TextUtils.isEmpty(str)) {
                SpannableString valueOf = SpannableString.valueOf("×" + str);
                valueOf.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf);
            }
            if (this.bjs && !aVar.biC && !TextUtils.isEmpty(str2)) {
                SpannableString valueOf2 = SpannableString.valueOf(String.format(this.mContext.getString(a.i.ala_rec_gift_charm_value), str2));
                valueOf2.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf2.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf2);
            }
            if (ai.ha(aVar.giftId) && !ai.gY(aVar.giftId) && ai.gZ(aVar.giftId)) {
                SpannableString valueOf3 = SpannableString.valueOf(this.mContext.getString(a.i.ala_dynamic_gift_downloading));
                valueOf3.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf3.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf3);
            }
            if (!aVar.biC && aVar.biB > 0.0d) {
                com.baidu.live.yuyinim.view.a aVar2 = new com.baidu.live.yuyinim.view.a(this.mContext, aVar.biB + "倍");
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
    private a z(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        boolean z = true;
        try {
            if (aVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) aVar.getObjContent();
            } else {
                jSONObject = new JSONObject(aVar.getContent());
            }
            a aVar2 = new a();
            aVar2.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            aVar2.bNS = jSONObject.optBoolean("is_owner");
            aVar2.room_name = jSONObject.optString(DpStatConstants.KEY_ROOM_NAME);
            aVar2.bjC = aVar.LW() + "";
            if (aVar.LY() > 0) {
                aVar2.bjD = aVar.LY() + "";
            } else {
                aVar2.bjD = "";
            }
            aVar2.biC = jSONObject.optInt("is_free") == 1;
            aVar2.biB = aVar.LX();
            com.baidu.live.gift.g gW = ai.gW(aVar2.giftId);
            if (gW != null) {
                if (gW.Fz()) {
                    aVar2.giftName = this.mContext.getString(a.i.sdk_text_gift_graffiti);
                    if (TextUtils.isEmpty(aVar2.giftName)) {
                        aVar2.giftName = jSONObject.optString("gift_name");
                    }
                    if (z && TextUtils.isEmpty(aVar2.aUh)) {
                        aVar2.aUh = jSONObject.optString("gift_url");
                        return aVar2;
                    }
                }
                aVar2.giftName = gW.Ft();
                aVar2.aUh = gW.getThumbnail_url();
            }
            z = false;
            if (TextUtils.isEmpty(aVar2.giftName)) {
            }
            return z ? aVar2 : aVar2;
        } catch (JSONException e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        public String aUh;
        public boolean bNS;
        public double biB;
        public boolean biC;
        public String bjC;
        public String bjD;
        public String giftId;
        public String giftName;
        public String room_name;

        private a() {
        }
    }
}

package com.baidu.live.im.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.baidu.live.adp.lib.resourceloader.BdResourceCallback;
import com.baidu.live.adp.lib.resourceloader.BdResourceLoader;
import com.baidu.live.adp.lib.util.BdBitmapHelper;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.widget.CenteredImageSpan;
import com.baidu.live.adp.widget.imageview.BdImage;
import com.baidu.live.gift.q;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c extends b {
    private boolean XD;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context) {
        super(context, com.baidu.live.im.a.aer);
        this.XD = true;
    }

    @Override // com.baidu.live.im.a.b
    protected void ta() {
        if (tb()) {
            tc();
        } else {
            td();
        }
    }

    @Override // com.baidu.live.im.a.b
    protected int getColor() {
        if (tb()) {
            return -1647769;
        }
        return TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_other_b);
    }

    @Override // com.baidu.live.im.a.b
    protected SpannableStringBuilder a(com.baidu.live.im.data.a aVar, final com.baidu.live.im.c cVar) {
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        a(spannableStringBuilder, aVar.tf(), cVar, false, false);
        final a h = h(aVar);
        String str = (h == null || TextUtils.isEmpty(h.WC)) ? "1" : h.WC;
        String string = (h == null || TextUtils.isEmpty(h.giftName)) ? this.mContext.getString(a.i.sdk_gift) : h.giftName;
        if (h != null && !TextUtils.isEmpty(h.ahb)) {
            String str2 = h.ahb;
        }
        String format = String.format(this.mContext.getString(a.i.ala_rec_gift), str, string);
        SpannableString valueOf = SpannableString.valueOf(format);
        if (format != null) {
            valueOf.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf.length(), 33);
        }
        spannableStringBuilder.append((CharSequence) valueOf);
        if (h != null && !TextUtils.isEmpty(h.aha)) {
            this.XD = true;
            BdResourceLoader.getInstance().loadResource(h.aha, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.im.a.c.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                public void onLoaded(BdImage bdImage, String str3, int i) {
                    Bitmap rawBitmap;
                    Bitmap copy;
                    Bitmap copy2;
                    super.onLoaded((AnonymousClass1) bdImage, str3, i);
                    if (bdImage != null && (rawBitmap = bdImage.getRawBitmap()) != null && !rawBitmap.isRecycled()) {
                        try {
                            if (rawBitmap.getConfig() == null) {
                                copy2 = rawBitmap.copy(Bitmap.Config.ARGB_8888, false);
                            } else {
                                copy2 = rawBitmap.copy(rawBitmap.getConfig(), false);
                            }
                            copy = copy2;
                        } catch (OutOfMemoryError e) {
                            BdLog.e(e);
                            if (rawBitmap.getConfig() == null) {
                                try {
                                    copy = rawBitmap.copy(Bitmap.Config.RGB_565, false);
                                } catch (OutOfMemoryError e2) {
                                    BdLog.e(e2);
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        if (copy != null) {
                            int dimensionPixelSize = c.this.mContext.getResources().getDimensionPixelSize(a.e.sdk_tbds36);
                            try {
                                Bitmap resizeBitmap = BdBitmapHelper.getInstance().resizeBitmap(copy, dimensionPixelSize, dimensionPixelSize);
                                if (resizeBitmap != copy) {
                                    copy.recycle();
                                }
                                if (resizeBitmap != null) {
                                    CenteredImageSpan centeredImageSpan = new CenteredImageSpan(c.this.mContext, resizeBitmap);
                                    SpannableString spannableString = new SpannableString(" [img]");
                                    spannableString.setSpan(centeredImageSpan, 1, spannableString.length(), 33);
                                    spannableStringBuilder.append((CharSequence) spannableString);
                                    if (c.this.agN && h != null && !TextUtils.isEmpty(h.ahb)) {
                                        SpannableString valueOf2 = SpannableString.valueOf(String.format(c.this.mContext.getString(a.i.ala_rec_gift_charm_value), h.ahb));
                                        valueOf2.setSpan(new ForegroundColorSpan(c.this.getColor()), 0, valueOf2.length(), 33);
                                        spannableStringBuilder.append((CharSequence) valueOf2);
                                    }
                                    if (q.co(h.giftId) && !q.cm(h.giftId) && q.cn(h.giftId)) {
                                        SpannableString valueOf3 = SpannableString.valueOf(c.this.mContext.getString(a.i.ala_dynamic_gift_downloading));
                                        valueOf3.setSpan(new ForegroundColorSpan(c.this.getColor()), 0, valueOf3.length(), 33);
                                        spannableStringBuilder.append((CharSequence) valueOf3);
                                    }
                                    if (!h.ahc && h.ahd > 0.0d) {
                                        com.baidu.live.im.view.a aVar2 = new com.baidu.live.im.view.a(c.this.mContext, "*" + h.ahd + "倍");
                                        SpannableString spannableString2 = new SpannableString(" rate");
                                        spannableString2.setSpan(aVar2, 1, spannableString2.length(), 33);
                                        spannableStringBuilder.append((CharSequence) spannableString2);
                                    }
                                    if (!c.this.XD) {
                                        cVar.aeI.setText(spannableStringBuilder);
                                    }
                                }
                            } catch (OutOfMemoryError e3) {
                                BdLog.e(e3);
                                if (copy != null) {
                                    copy.recycle();
                                }
                            }
                        }
                    }
                }
            }, null);
            this.XD = false;
        }
        return spannableStringBuilder;
    }

    private a h(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        try {
            if (aVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) aVar.getObjContent();
            } else {
                jSONObject = new JSONObject(aVar.getContent());
            }
            a aVar2 = new a();
            aVar2.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            aVar2.WC = jSONObject.optString("gift_count");
            aVar2.giftName = jSONObject.optString("gift_name");
            aVar2.aha = jSONObject.optString("gift_url");
            aVar2.ahb = jSONObject.optString("charm_value");
            aVar2.ahc = jSONObject.optInt("is_free") == 1;
            aVar2.ahd = jSONObject.optDouble("gift_rate");
            com.baidu.live.gift.g cl = q.cl(aVar2.giftId);
            if (cl != null) {
                aVar2.giftName = cl.pd();
                aVar2.aha = cl.pf();
                return aVar2;
            }
            return aVar2;
        } catch (JSONException e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a {
        public String WC;
        public String aha;
        public String ahb;
        public boolean ahc;
        public double ahd;
        public String giftId;
        public String giftName;

        private a() {
        }
    }
}

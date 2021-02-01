package com.baidu.live.tbadk.widget.largeimage.tools;

import android.content.Context;
import android.graphics.BitmapRegionDecoder;
import java.io.IOException;
/* loaded from: classes11.dex */
public class BitmapDecoderCreator implements IBitmapDecoderCreator {
    private Context mContext;
    private final int[] mWidthAndheight = new int[2];

    public BitmapDecoderCreator(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.tbadk.widget.largeimage.tools.IBitmapDecoderCreator
    public BitmapRegionDecoder createDecoder(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, false);
        this.mWidthAndheight[0] = newInstance.getWidth();
        this.mWidthAndheight[1] = newInstance.getHeight();
        return newInstance;
    }

    @Override // com.baidu.live.tbadk.widget.largeimage.tools.IBitmapDecoderCreator
    public int[] getImageWidthAndHeight() {
        return this.mWidthAndheight;
    }
}

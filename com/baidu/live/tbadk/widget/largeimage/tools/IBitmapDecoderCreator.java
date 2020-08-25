package com.baidu.live.tbadk.widget.largeimage.tools;

import android.graphics.BitmapRegionDecoder;
import java.io.IOException;
/* loaded from: classes7.dex */
public interface IBitmapDecoderCreator {
    BitmapRegionDecoder createDecoder(byte[] bArr) throws IOException;

    int[] getImageWidthAndHeight();
}

package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdRecyclerAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.widget.richText.TbRichTextEmotionInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bn;
import com.repackage.kg;
import com.repackage.oi;
import com.repackage.on;
import com.repackage.pn;
import com.repackage.sn;
import com.repackage.tn;
import com.repackage.ym;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class PreLoadImageHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float IMAGE_MAX_CACHE_SIZE_PERCENT = 0.8f;
    public transient /* synthetic */ FieldHolder $fh;

    public PreLoadImageHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void addPreloadSuggestSize(pn pnVar, Object obj, PreLoadImageInfo preLoadImageInfo) {
        bn<on, TypeAdapter.ViewHolder> c;
        ym preloadSize;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, null, pnVar, obj, preLoadImageInfo) == null) || pnVar == null || obj == null || preLoadImageInfo == null) {
            return;
        }
        if (preLoadImageInfo.width <= 0 || preLoadImageInfo.height <= 0) {
            tn tnVar = null;
            if (pnVar instanceof tn) {
                tnVar = (tn) pnVar;
            } else if (pnVar instanceof BdRecyclerAdapter) {
                BdRecyclerAdapter bdRecyclerAdapter = (BdRecyclerAdapter) pnVar;
                if (bdRecyclerAdapter.p() instanceof tn) {
                    tnVar = (tn) bdRecyclerAdapter.p();
                }
            }
            if (tnVar == null || !(obj instanceof on) || (c = tnVar.c((on) obj)) == null || (preloadSize = c.getPreloadSize(preLoadImageInfo.preloadType)) == null || preloadSize.b() <= 0 || preloadSize.a() <= 0) {
                return;
            }
            preLoadImageInfo.width = preloadSize.b();
            preLoadImageInfo.height = preloadSize.a();
        }
    }

    public static void load(sn snVar, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, snVar, bdUniqueId) == null) {
            load(snVar, bdUniqueId, 13);
        }
    }

    public static void load(sn snVar, BdUniqueId bdUniqueId, int i) {
        pn adapter;
        pn pnVar;
        ArrayList<PreLoadImageInfo> images;
        pn pnVar2;
        int i2;
        int pbImageSize;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65539, null, snVar, bdUniqueId, i) == null) || snVar == null || !oi.H() || (adapter = snVar.getAdapter()) == null) {
            return;
        }
        int bigImageMaxUsedMemory = (int) (TbConfig.getBigImageMaxUsedMemory() * 0.8f);
        boolean isSupportGifEmotions = TbImageHelper.isSupportGifEmotions();
        int firstVisiblePosition = snVar.getFirstVisiblePosition();
        int lastVisiblePosition = snVar.getLastVisiblePosition();
        kg.h().f(bdUniqueId, null);
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (firstVisiblePosition < adapter.getCount()) {
            Object item = adapter.getItem(firstVisiblePosition);
            if (!(item instanceof PreLoadImageProvider) || (images = ((PreLoadImageProvider) item).getImages()) == null || images.size() == 0) {
                pnVar = adapter;
            } else {
                Iterator<PreLoadImageInfo> it = images.iterator();
                int i9 = i7;
                int i10 = i8;
                while (it.hasNext()) {
                    PreLoadImageInfo next = it.next();
                    if (kg.h().j(next.procType)) {
                        int i11 = next.procType;
                        if (12 != i11 && 28 != i11) {
                            int i12 = next.width * next.height;
                            if (i12 > 0) {
                                pbImageSize = next.bigEmotion != null ? i12 * 4 : i12 * 2;
                            } else if (next.bigEmotion != null) {
                                BdLog.e("missing big emotion image width and height!");
                                pbImageSize = TbConfig.getBigEmotionsSize();
                            } else {
                                pbImageSize = TbConfig.getPbImageSize();
                            }
                            int i13 = i9 + pbImageSize;
                            int i14 = i6 + 1;
                            if (i14 <= i && i13 < bigImageMaxUsedMemory && firstVisiblePosition > lastVisiblePosition) {
                                TbRichTextEmotionInfo tbRichTextEmotionInfo = next.bigEmotion;
                                if (tbRichTextEmotionInfo != null) {
                                    GifInfo gifInfo = tbRichTextEmotionInfo.mGifInfo;
                                    String str = isSupportGifEmotions ? gifInfo.mDynamicUrl : gifInfo.mStaticUrl;
                                    if (!TextUtils.isEmpty(str)) {
                                        kg h = kg.h();
                                        GifInfo gifInfo2 = tbRichTextEmotionInfo.mGifInfo;
                                        String str2 = gifInfo2.mSharpText;
                                        pnVar2 = adapter;
                                        i3 = i14;
                                        i4 = i10;
                                        i5 = i13;
                                        h.k(str2, next.procType, null, next.width, next.height, bdUniqueId, gifInfo2.mGid, str2, Boolean.valueOf(isSupportGifEmotions), str);
                                    }
                                } else {
                                    pnVar2 = adapter;
                                    i3 = i14;
                                    i4 = i10;
                                    i5 = i13;
                                    String str3 = next.imgUrl;
                                    if (!TextUtils.isEmpty(str3)) {
                                        kg.h().k(str3, next.procType, null, next.width, next.height, bdUniqueId, new Object[0]);
                                    }
                                }
                                i10 = i4;
                                i9 = i5;
                                i6 = i3;
                            }
                            pnVar2 = adapter;
                            i3 = i14;
                            i4 = i10;
                            i5 = i13;
                            i10 = i4;
                            i9 = i5;
                            i6 = i3;
                        } else {
                            pnVar2 = adapter;
                            int i15 = i10 + 1;
                            if (i15 > 30 || firstVisiblePosition <= lastVisiblePosition || TextUtils.isEmpty(next.imgUrl)) {
                                i2 = i9;
                            } else {
                                int i16 = next.procType;
                                if (12 == i16) {
                                    i2 = i9;
                                    kg.h().k(next.imgUrl, 12, null, next.width, next.height, bdUniqueId, new Object[0]);
                                } else {
                                    int i17 = i9;
                                    if (28 == i16) {
                                        i2 = i17;
                                        kg.h().k(next.imgUrl, 28, null, next.width, next.height, bdUniqueId, new Object[0]);
                                    } else {
                                        i2 = i17;
                                    }
                                }
                            }
                            i10 = i15;
                            i9 = i2;
                        }
                        adapter = pnVar2;
                    }
                }
                pnVar = adapter;
                int i18 = i10;
                int i19 = i9;
                if ((i6 > i || i19 >= bigImageMaxUsedMemory) && i18 > 30) {
                    return;
                }
                i8 = i18;
                i7 = i19;
            }
            firstVisiblePosition++;
            adapter = pnVar;
        }
    }
}

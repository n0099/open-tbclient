package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import c.a.d.f.l.d;
import c.a.d.f.p.k;
import c.a.d.m.c.c;
import c.a.d.m.e.a;
import c.a.d.m.e.n;
import c.a.d.m.e.o;
import c.a.d.m.e.q;
import c.a.d.m.e.r;
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
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class PreLoadImageHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float IMAGE_MAX_CACHE_SIZE_PERCENT = 0.8f;
    public transient /* synthetic */ FieldHolder $fh;

    public PreLoadImageHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void addPreloadSuggestSize(o oVar, Object obj, PreLoadImageInfo preLoadImageInfo) {
        a<n, TypeAdapter.ViewHolder> adapterByData;
        c D;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, null, oVar, obj, preLoadImageInfo) == null) || oVar == null || obj == null || preLoadImageInfo == null) {
            return;
        }
        if (preLoadImageInfo.width <= 0 || preLoadImageInfo.height <= 0) {
            r rVar = null;
            if (oVar instanceof r) {
                rVar = (r) oVar;
            } else if (oVar instanceof BdRecyclerAdapter) {
                BdRecyclerAdapter bdRecyclerAdapter = (BdRecyclerAdapter) oVar;
                if (bdRecyclerAdapter.getWrappedAdapter() instanceof r) {
                    rVar = (r) bdRecyclerAdapter.getWrappedAdapter();
                }
            }
            if (rVar == null || !(obj instanceof n) || (adapterByData = rVar.getAdapterByData((n) obj)) == null || (D = adapterByData.D(preLoadImageInfo.preloadType)) == null || D.b() <= 0 || D.a() <= 0) {
                return;
            }
            preLoadImageInfo.width = D.b();
            preLoadImageInfo.height = D.a();
        }
    }

    public static void load(q qVar, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, qVar, bdUniqueId) == null) {
            load(qVar, bdUniqueId, 13);
        }
    }

    public static void load(q qVar, BdUniqueId bdUniqueId, int i2) {
        o adapter;
        o oVar;
        ArrayList<PreLoadImageInfo> images;
        o oVar2;
        int i3;
        int pbImageSize;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65539, null, qVar, bdUniqueId, i2) == null) || qVar == null || !k.H() || (adapter = qVar.getAdapter()) == null) {
            return;
        }
        int bigImageMaxUsedMemory = (int) (TbConfig.getBigImageMaxUsedMemory() * 0.8f);
        boolean isSupportGifEmotions = TbImageHelper.isSupportGifEmotions();
        int firstVisiblePosition = qVar.getFirstVisiblePosition();
        int lastVisiblePosition = qVar.getLastVisiblePosition();
        d.h().f(bdUniqueId, null);
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (firstVisiblePosition < adapter.getCount()) {
            Object item = adapter.getItem(firstVisiblePosition);
            if (!(item instanceof PreLoadImageProvider) || (images = ((PreLoadImageProvider) item).getImages()) == null || images.size() == 0) {
                oVar = adapter;
            } else {
                Iterator<PreLoadImageInfo> it = images.iterator();
                int i10 = i8;
                int i11 = i9;
                while (it.hasNext()) {
                    PreLoadImageInfo next = it.next();
                    if (d.h().j(next.procType)) {
                        int i12 = next.procType;
                        if (12 != i12 && 28 != i12) {
                            int i13 = next.width * next.height;
                            if (i13 > 0) {
                                pbImageSize = next.bigEmotion != null ? i13 * 4 : i13 * 2;
                            } else if (next.bigEmotion != null) {
                                BdLog.e("missing big emotion image width and height!");
                                pbImageSize = TbConfig.getBigEmotionsSize();
                            } else {
                                pbImageSize = TbConfig.getPbImageSize();
                            }
                            int i14 = i10 + pbImageSize;
                            int i15 = i7 + 1;
                            if (i15 <= i2 && i14 < bigImageMaxUsedMemory && firstVisiblePosition > lastVisiblePosition) {
                                TbRichTextEmotionInfo tbRichTextEmotionInfo = next.bigEmotion;
                                if (tbRichTextEmotionInfo != null) {
                                    GifInfo gifInfo = tbRichTextEmotionInfo.mGifInfo;
                                    String str = isSupportGifEmotions ? gifInfo.mDynamicUrl : gifInfo.mStaticUrl;
                                    if (!TextUtils.isEmpty(str)) {
                                        d h2 = d.h();
                                        GifInfo gifInfo2 = tbRichTextEmotionInfo.mGifInfo;
                                        String str2 = gifInfo2.mSharpText;
                                        oVar2 = adapter;
                                        i4 = i15;
                                        i5 = i11;
                                        i6 = i14;
                                        h2.k(str2, next.procType, null, next.width, next.height, bdUniqueId, gifInfo2.mGid, str2, Boolean.valueOf(isSupportGifEmotions), str);
                                    }
                                } else {
                                    oVar2 = adapter;
                                    i4 = i15;
                                    i5 = i11;
                                    i6 = i14;
                                    String str3 = next.imgUrl;
                                    if (!TextUtils.isEmpty(str3)) {
                                        d.h().k(str3, next.procType, null, next.width, next.height, bdUniqueId, new Object[0]);
                                    }
                                }
                                i11 = i5;
                                i10 = i6;
                                i7 = i4;
                            }
                            oVar2 = adapter;
                            i4 = i15;
                            i5 = i11;
                            i6 = i14;
                            i11 = i5;
                            i10 = i6;
                            i7 = i4;
                        } else {
                            oVar2 = adapter;
                            int i16 = i11 + 1;
                            if (i16 > 30 || firstVisiblePosition <= lastVisiblePosition || TextUtils.isEmpty(next.imgUrl)) {
                                i3 = i10;
                            } else {
                                int i17 = next.procType;
                                if (12 == i17) {
                                    i3 = i10;
                                    d.h().k(next.imgUrl, 12, null, next.width, next.height, bdUniqueId, new Object[0]);
                                } else {
                                    int i18 = i10;
                                    if (28 == i17) {
                                        i3 = i18;
                                        d.h().k(next.imgUrl, 28, null, next.width, next.height, bdUniqueId, new Object[0]);
                                    } else {
                                        i3 = i18;
                                    }
                                }
                            }
                            i11 = i16;
                            i10 = i3;
                        }
                        adapter = oVar2;
                    }
                }
                oVar = adapter;
                int i19 = i11;
                int i20 = i10;
                if ((i7 > i2 || i20 >= bigImageMaxUsedMemory) && i19 > 30) {
                    return;
                }
                i9 = i19;
                i8 = i20;
            }
            firstVisiblePosition++;
            adapter = oVar;
        }
    }
}

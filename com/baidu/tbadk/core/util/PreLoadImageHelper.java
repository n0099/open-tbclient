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
import com.repackage.bo;
import com.repackage.eo;
import com.repackage.gg;
import com.repackage.ki;
import com.repackage.ro;
import com.repackage.so;
import com.repackage.vo;
import com.repackage.wo;
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

    public static void addPreloadSuggestSize(so soVar, Object obj, PreLoadImageInfo preLoadImageInfo) {
        eo<ro, TypeAdapter.ViewHolder> c;
        bo D;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, null, soVar, obj, preLoadImageInfo) == null) || soVar == null || obj == null || preLoadImageInfo == null) {
            return;
        }
        if (preLoadImageInfo.width <= 0 || preLoadImageInfo.height <= 0) {
            wo woVar = null;
            if (soVar instanceof wo) {
                woVar = (wo) soVar;
            } else if (soVar instanceof BdRecyclerAdapter) {
                BdRecyclerAdapter bdRecyclerAdapter = (BdRecyclerAdapter) soVar;
                if (bdRecyclerAdapter.q() instanceof wo) {
                    woVar = (wo) bdRecyclerAdapter.q();
                }
            }
            if (woVar == null || !(obj instanceof ro) || (c = woVar.c((ro) obj)) == null || (D = c.D(preLoadImageInfo.preloadType)) == null || D.b() <= 0 || D.a() <= 0) {
                return;
            }
            preLoadImageInfo.width = D.b();
            preLoadImageInfo.height = D.a();
        }
    }

    public static void load(vo voVar, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, voVar, bdUniqueId) == null) {
            load(voVar, bdUniqueId, 13);
        }
    }

    public static void load(vo voVar, BdUniqueId bdUniqueId, int i) {
        so adapter;
        so soVar;
        ArrayList<PreLoadImageInfo> images;
        so soVar2;
        int i2;
        int pbImageSize;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65539, null, voVar, bdUniqueId, i) == null) || voVar == null || !ki.H() || (adapter = voVar.getAdapter()) == null) {
            return;
        }
        int bigImageMaxUsedMemory = (int) (TbConfig.getBigImageMaxUsedMemory() * 0.8f);
        boolean isSupportGifEmotions = TbImageHelper.isSupportGifEmotions();
        int firstVisiblePosition = voVar.getFirstVisiblePosition();
        int lastVisiblePosition = voVar.getLastVisiblePosition();
        gg.h().f(bdUniqueId, null);
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (firstVisiblePosition < adapter.getCount()) {
            Object item = adapter.getItem(firstVisiblePosition);
            if (!(item instanceof PreLoadImageProvider) || (images = ((PreLoadImageProvider) item).getImages()) == null || images.size() == 0) {
                soVar = adapter;
            } else {
                Iterator<PreLoadImageInfo> it = images.iterator();
                int i9 = i7;
                int i10 = i8;
                while (it.hasNext()) {
                    PreLoadImageInfo next = it.next();
                    if (gg.h().j(next.procType)) {
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
                                        gg h = gg.h();
                                        GifInfo gifInfo2 = tbRichTextEmotionInfo.mGifInfo;
                                        String str2 = gifInfo2.mSharpText;
                                        soVar2 = adapter;
                                        i3 = i14;
                                        i4 = i10;
                                        i5 = i13;
                                        h.k(str2, next.procType, null, next.width, next.height, bdUniqueId, gifInfo2.mGid, str2, Boolean.valueOf(isSupportGifEmotions), str);
                                    }
                                } else {
                                    soVar2 = adapter;
                                    i3 = i14;
                                    i4 = i10;
                                    i5 = i13;
                                    String str3 = next.imgUrl;
                                    if (!TextUtils.isEmpty(str3)) {
                                        gg.h().k(str3, next.procType, null, next.width, next.height, bdUniqueId, new Object[0]);
                                    }
                                }
                                i10 = i4;
                                i9 = i5;
                                i6 = i3;
                            }
                            soVar2 = adapter;
                            i3 = i14;
                            i4 = i10;
                            i5 = i13;
                            i10 = i4;
                            i9 = i5;
                            i6 = i3;
                        } else {
                            soVar2 = adapter;
                            int i15 = i10 + 1;
                            if (i15 > 30 || firstVisiblePosition <= lastVisiblePosition || TextUtils.isEmpty(next.imgUrl)) {
                                i2 = i9;
                            } else {
                                int i16 = next.procType;
                                if (12 == i16) {
                                    i2 = i9;
                                    gg.h().k(next.imgUrl, 12, null, next.width, next.height, bdUniqueId, new Object[0]);
                                } else {
                                    int i17 = i9;
                                    if (28 == i16) {
                                        i2 = i17;
                                        gg.h().k(next.imgUrl, 28, null, next.width, next.height, bdUniqueId, new Object[0]);
                                    } else {
                                        i2 = i17;
                                    }
                                }
                            }
                            i10 = i15;
                            i9 = i2;
                        }
                        adapter = soVar2;
                    }
                }
                soVar = adapter;
                int i18 = i10;
                int i19 = i9;
                if ((i6 > i || i19 >= bigImageMaxUsedMemory) && i18 > 30) {
                    return;
                }
                i8 = i18;
                i7 = i19;
            }
            firstVisiblePosition++;
            adapter = soVar;
        }
    }
}

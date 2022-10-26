package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.widget.ListView.BdRecyclerAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.widget.richText.TbRichTextEmotionInfo;
import com.baidu.tieba.ah;
import com.baidu.tieba.eo;
import com.baidu.tieba.fo;
import com.baidu.tieba.io;
import com.baidu.tieba.jo;
import com.baidu.tieba.on;
import com.baidu.tieba.rn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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

    public static void addPreloadSuggestSize(fo foVar, Object obj, PreLoadImageInfo preLoadImageInfo) {
        rn<eo, TypeAdapter.ViewHolder> c;
        on preloadSize;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, foVar, obj, preLoadImageInfo) == null) && foVar != null && obj != null && preLoadImageInfo != null) {
            if (preLoadImageInfo.width > 0 && preLoadImageInfo.height > 0) {
                return;
            }
            jo joVar = null;
            if (foVar instanceof jo) {
                joVar = (jo) foVar;
            } else if (foVar instanceof BdRecyclerAdapter) {
                BdRecyclerAdapter bdRecyclerAdapter = (BdRecyclerAdapter) foVar;
                if (bdRecyclerAdapter.p() instanceof jo) {
                    joVar = (jo) bdRecyclerAdapter.p();
                }
            }
            if (joVar != null && (obj instanceof eo) && (c = joVar.c((eo) obj)) != null && (preloadSize = c.getPreloadSize(preLoadImageInfo.preloadType)) != null && preloadSize.b() > 0 && preloadSize.a() > 0) {
                preLoadImageInfo.width = preloadSize.b();
                preLoadImageInfo.height = preloadSize.a();
            }
        }
    }

    public static void load(io ioVar, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, ioVar, bdUniqueId) == null) {
            load(ioVar, bdUniqueId, 13);
        }
    }

    public static void load(io ioVar, BdUniqueId bdUniqueId, int i) {
        fo adapter;
        fo foVar;
        ArrayList images;
        fo foVar2;
        int i2;
        int pbImageSize;
        int i3;
        int i4;
        int i5;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(65539, null, ioVar, bdUniqueId, i) != null) || ioVar == null || !BdNetTypeUtil.isWifiNet() || (adapter = ioVar.getAdapter()) == null) {
            return;
        }
        int bigImageMaxUsedMemory = (int) (TbConfig.getBigImageMaxUsedMemory() * 0.8f);
        boolean isSupportGifEmotions = TbImageHelper.isSupportGifEmotions();
        int firstVisiblePosition = ioVar.getFirstVisiblePosition();
        int lastVisiblePosition = ioVar.getLastVisiblePosition();
        ah.h().f(bdUniqueId, null);
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (firstVisiblePosition < adapter.getCount()) {
            Object item = adapter.getItem(firstVisiblePosition);
            if ((item instanceof PreLoadImageProvider) && (images = ((PreLoadImageProvider) item).getImages()) != null && images.size() != 0) {
                Iterator it = images.iterator();
                int i9 = i7;
                int i10 = i8;
                while (it.hasNext()) {
                    PreLoadImageInfo preLoadImageInfo = (PreLoadImageInfo) it.next();
                    if (ah.h().j(preLoadImageInfo.procType)) {
                        int i11 = preLoadImageInfo.procType;
                        if (12 != i11 && 28 != i11) {
                            int i12 = preLoadImageInfo.width * preLoadImageInfo.height;
                            if (i12 > 0) {
                                if (preLoadImageInfo.bigEmotion != null) {
                                    pbImageSize = i12 * 4;
                                } else {
                                    pbImageSize = i12 * 2;
                                }
                            } else if (preLoadImageInfo.bigEmotion != null) {
                                BdLog.e("missing big emotion image width and height!");
                                pbImageSize = TbConfig.getBigEmotionsSize();
                            } else {
                                pbImageSize = TbConfig.getPbImageSize();
                            }
                            int i13 = i9 + pbImageSize;
                            int i14 = i6 + 1;
                            if (i14 <= i && i13 < bigImageMaxUsedMemory && firstVisiblePosition > lastVisiblePosition) {
                                TbRichTextEmotionInfo tbRichTextEmotionInfo = preLoadImageInfo.bigEmotion;
                                if (tbRichTextEmotionInfo != null) {
                                    GifInfo gifInfo = tbRichTextEmotionInfo.mGifInfo;
                                    if (isSupportGifEmotions) {
                                        str = gifInfo.mDynamicUrl;
                                    } else {
                                        str = gifInfo.mStaticUrl;
                                    }
                                    if (!TextUtils.isEmpty(str)) {
                                        ah h = ah.h();
                                        GifInfo gifInfo2 = tbRichTextEmotionInfo.mGifInfo;
                                        String str2 = gifInfo2.mSharpText;
                                        foVar2 = adapter;
                                        i3 = i14;
                                        i4 = i10;
                                        i5 = i13;
                                        h.k(str2, preLoadImageInfo.procType, null, preLoadImageInfo.width, preLoadImageInfo.height, bdUniqueId, gifInfo2.mGid, str2, Boolean.valueOf(isSupportGifEmotions), str);
                                    }
                                } else {
                                    foVar2 = adapter;
                                    i3 = i14;
                                    i4 = i10;
                                    i5 = i13;
                                    String str3 = preLoadImageInfo.imgUrl;
                                    if (!TextUtils.isEmpty(str3)) {
                                        ah.h().k(str3, preLoadImageInfo.procType, null, preLoadImageInfo.width, preLoadImageInfo.height, bdUniqueId, new Object[0]);
                                    }
                                }
                                i10 = i4;
                                i9 = i5;
                                i6 = i3;
                            }
                            foVar2 = adapter;
                            i3 = i14;
                            i4 = i10;
                            i5 = i13;
                            i10 = i4;
                            i9 = i5;
                            i6 = i3;
                        } else {
                            foVar2 = adapter;
                            int i15 = i10 + 1;
                            if (i15 <= 30 && firstVisiblePosition > lastVisiblePosition && !TextUtils.isEmpty(preLoadImageInfo.imgUrl)) {
                                int i16 = preLoadImageInfo.procType;
                                if (12 == i16) {
                                    i2 = i9;
                                    ah.h().k(preLoadImageInfo.imgUrl, 12, null, preLoadImageInfo.width, preLoadImageInfo.height, bdUniqueId, new Object[0]);
                                } else {
                                    int i17 = i9;
                                    if (28 == i16) {
                                        i2 = i17;
                                        ah.h().k(preLoadImageInfo.imgUrl, 28, null, preLoadImageInfo.width, preLoadImageInfo.height, bdUniqueId, new Object[0]);
                                    } else {
                                        i2 = i17;
                                    }
                                }
                            } else {
                                i2 = i9;
                            }
                            i10 = i15;
                            i9 = i2;
                        }
                        adapter = foVar2;
                    }
                }
                foVar = adapter;
                int i18 = i10;
                int i19 = i9;
                if ((i6 <= i && i19 < bigImageMaxUsedMemory) || i18 <= 30) {
                    i8 = i18;
                    i7 = i19;
                } else {
                    return;
                }
            } else {
                foVar = adapter;
            }
            firstVisiblePosition++;
            adapter = foVar;
        }
    }
}

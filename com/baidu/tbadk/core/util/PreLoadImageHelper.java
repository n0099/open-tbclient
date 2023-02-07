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
import com.baidu.tieba.Cdo;
import com.baidu.tieba.eo;
import com.baidu.tieba.ho;
import com.baidu.tieba.io;
import com.baidu.tieba.nn;
import com.baidu.tieba.qn;
import com.baidu.tieba.zg;
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

    public static void addPreloadSuggestSize(eo eoVar, Object obj, PreLoadImageInfo preLoadImageInfo) {
        qn<Cdo, TypeAdapter.ViewHolder> c;
        nn preloadSize;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, eoVar, obj, preLoadImageInfo) == null) && eoVar != null && obj != null && preLoadImageInfo != null) {
            if (preLoadImageInfo.width > 0 && preLoadImageInfo.height > 0) {
                return;
            }
            io ioVar = null;
            if (eoVar instanceof io) {
                ioVar = (io) eoVar;
            } else if (eoVar instanceof BdRecyclerAdapter) {
                BdRecyclerAdapter bdRecyclerAdapter = (BdRecyclerAdapter) eoVar;
                if (bdRecyclerAdapter.p() instanceof io) {
                    ioVar = (io) bdRecyclerAdapter.p();
                }
            }
            if (ioVar != null && (obj instanceof Cdo) && (c = ioVar.c((Cdo) obj)) != null && (preloadSize = c.getPreloadSize(preLoadImageInfo.preloadType)) != null && preloadSize.b() > 0 && preloadSize.a() > 0) {
                preLoadImageInfo.width = preloadSize.b();
                preLoadImageInfo.height = preloadSize.a();
            }
        }
    }

    public static void load(ho hoVar, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, hoVar, bdUniqueId) == null) {
            load(hoVar, bdUniqueId, 13);
        }
    }

    public static void load(ho hoVar, BdUniqueId bdUniqueId, int i) {
        eo adapter;
        eo eoVar;
        ArrayList<PreLoadImageInfo> images;
        eo eoVar2;
        int i2;
        int pbImageSize;
        int i3;
        int i4;
        int i5;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(65539, null, hoVar, bdUniqueId, i) != null) || hoVar == null || !BdNetTypeUtil.isWifiNet() || (adapter = hoVar.getAdapter()) == null) {
            return;
        }
        int bigImageMaxUsedMemory = (int) (TbConfig.getBigImageMaxUsedMemory() * 0.8f);
        boolean isSupportGifEmotions = TbImageHelper.isSupportGifEmotions();
        int firstVisiblePosition = hoVar.getFirstVisiblePosition();
        int lastVisiblePosition = hoVar.getLastVisiblePosition();
        zg.h().f(bdUniqueId, null);
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (firstVisiblePosition < adapter.getCount()) {
            Object item = adapter.getItem(firstVisiblePosition);
            if ((item instanceof PreLoadImageProvider) && (images = ((PreLoadImageProvider) item).getImages()) != null && images.size() != 0) {
                Iterator<PreLoadImageInfo> it = images.iterator();
                int i9 = i7;
                int i10 = i8;
                while (it.hasNext()) {
                    PreLoadImageInfo next = it.next();
                    if (zg.h().j(next.procType)) {
                        int i11 = next.procType;
                        if (12 != i11 && 28 != i11) {
                            int i12 = next.width * next.height;
                            if (i12 > 0) {
                                if (next.bigEmotion != null) {
                                    pbImageSize = i12 * 4;
                                } else {
                                    pbImageSize = i12 * 2;
                                }
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
                                    if (isSupportGifEmotions) {
                                        str = gifInfo.mDynamicUrl;
                                    } else {
                                        str = gifInfo.mStaticUrl;
                                    }
                                    if (!TextUtils.isEmpty(str)) {
                                        zg h = zg.h();
                                        GifInfo gifInfo2 = tbRichTextEmotionInfo.mGifInfo;
                                        String str2 = gifInfo2.mSharpText;
                                        eoVar2 = adapter;
                                        i3 = i14;
                                        i4 = i10;
                                        i5 = i13;
                                        h.k(str2, next.procType, null, next.width, next.height, bdUniqueId, gifInfo2.mGid, str2, Boolean.valueOf(isSupportGifEmotions), str);
                                    }
                                } else {
                                    eoVar2 = adapter;
                                    i3 = i14;
                                    i4 = i10;
                                    i5 = i13;
                                    String str3 = next.imgUrl;
                                    if (!TextUtils.isEmpty(str3)) {
                                        zg.h().k(str3, next.procType, null, next.width, next.height, bdUniqueId, new Object[0]);
                                    }
                                }
                                i10 = i4;
                                i9 = i5;
                                i6 = i3;
                            }
                            eoVar2 = adapter;
                            i3 = i14;
                            i4 = i10;
                            i5 = i13;
                            i10 = i4;
                            i9 = i5;
                            i6 = i3;
                        } else {
                            eoVar2 = adapter;
                            int i15 = i10 + 1;
                            if (i15 <= 30 && firstVisiblePosition > lastVisiblePosition && !TextUtils.isEmpty(next.imgUrl)) {
                                int i16 = next.procType;
                                if (12 == i16) {
                                    i2 = i9;
                                    zg.h().k(next.imgUrl, 12, null, next.width, next.height, bdUniqueId, new Object[0]);
                                } else {
                                    int i17 = i9;
                                    if (28 == i16) {
                                        i2 = i17;
                                        zg.h().k(next.imgUrl, 28, null, next.width, next.height, bdUniqueId, new Object[0]);
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
                        adapter = eoVar2;
                    }
                }
                eoVar = adapter;
                int i18 = i10;
                int i19 = i9;
                if ((i6 <= i && i19 < bigImageMaxUsedMemory) || i18 <= 30) {
                    i8 = i18;
                    i7 = i19;
                } else {
                    return;
                }
            } else {
                eoVar = adapter;
            }
            firstVisiblePosition++;
            adapter = eoVar;
        }
    }
}

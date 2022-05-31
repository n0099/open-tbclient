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
import com.repackage.fg;
import com.repackage.ji;
import com.repackage.jn;
import com.repackage.kn;
import com.repackage.nn;
import com.repackage.on;
import com.repackage.tm;
import com.repackage.wm;
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

    public static void addPreloadSuggestSize(kn knVar, Object obj, PreLoadImageInfo preLoadImageInfo) {
        wm<jn, TypeAdapter.ViewHolder> c;
        tm D;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, null, knVar, obj, preLoadImageInfo) == null) || knVar == null || obj == null || preLoadImageInfo == null) {
            return;
        }
        if (preLoadImageInfo.width <= 0 || preLoadImageInfo.height <= 0) {
            on onVar = null;
            if (knVar instanceof on) {
                onVar = (on) knVar;
            } else if (knVar instanceof BdRecyclerAdapter) {
                BdRecyclerAdapter bdRecyclerAdapter = (BdRecyclerAdapter) knVar;
                if (bdRecyclerAdapter.q() instanceof on) {
                    onVar = (on) bdRecyclerAdapter.q();
                }
            }
            if (onVar == null || !(obj instanceof jn) || (c = onVar.c((jn) obj)) == null || (D = c.D(preLoadImageInfo.preloadType)) == null || D.b() <= 0 || D.a() <= 0) {
                return;
            }
            preLoadImageInfo.width = D.b();
            preLoadImageInfo.height = D.a();
        }
    }

    public static void load(nn nnVar, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, nnVar, bdUniqueId) == null) {
            load(nnVar, bdUniqueId, 13);
        }
    }

    public static void load(nn nnVar, BdUniqueId bdUniqueId, int i) {
        kn adapter;
        kn knVar;
        ArrayList<PreLoadImageInfo> images;
        kn knVar2;
        int i2;
        int pbImageSize;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65539, null, nnVar, bdUniqueId, i) == null) || nnVar == null || !ji.H() || (adapter = nnVar.getAdapter()) == null) {
            return;
        }
        int bigImageMaxUsedMemory = (int) (TbConfig.getBigImageMaxUsedMemory() * 0.8f);
        boolean isSupportGifEmotions = TbImageHelper.isSupportGifEmotions();
        int firstVisiblePosition = nnVar.getFirstVisiblePosition();
        int lastVisiblePosition = nnVar.getLastVisiblePosition();
        fg.h().f(bdUniqueId, null);
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (firstVisiblePosition < adapter.getCount()) {
            Object item = adapter.getItem(firstVisiblePosition);
            if (!(item instanceof PreLoadImageProvider) || (images = ((PreLoadImageProvider) item).getImages()) == null || images.size() == 0) {
                knVar = adapter;
            } else {
                Iterator<PreLoadImageInfo> it = images.iterator();
                int i9 = i7;
                int i10 = i8;
                while (it.hasNext()) {
                    PreLoadImageInfo next = it.next();
                    if (fg.h().j(next.procType)) {
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
                                        fg h = fg.h();
                                        GifInfo gifInfo2 = tbRichTextEmotionInfo.mGifInfo;
                                        String str2 = gifInfo2.mSharpText;
                                        knVar2 = adapter;
                                        i3 = i14;
                                        i4 = i10;
                                        i5 = i13;
                                        h.k(str2, next.procType, null, next.width, next.height, bdUniqueId, gifInfo2.mGid, str2, Boolean.valueOf(isSupportGifEmotions), str);
                                    }
                                } else {
                                    knVar2 = adapter;
                                    i3 = i14;
                                    i4 = i10;
                                    i5 = i13;
                                    String str3 = next.imgUrl;
                                    if (!TextUtils.isEmpty(str3)) {
                                        fg.h().k(str3, next.procType, null, next.width, next.height, bdUniqueId, new Object[0]);
                                    }
                                }
                                i10 = i4;
                                i9 = i5;
                                i6 = i3;
                            }
                            knVar2 = adapter;
                            i3 = i14;
                            i4 = i10;
                            i5 = i13;
                            i10 = i4;
                            i9 = i5;
                            i6 = i3;
                        } else {
                            knVar2 = adapter;
                            int i15 = i10 + 1;
                            if (i15 > 30 || firstVisiblePosition <= lastVisiblePosition || TextUtils.isEmpty(next.imgUrl)) {
                                i2 = i9;
                            } else {
                                int i16 = next.procType;
                                if (12 == i16) {
                                    i2 = i9;
                                    fg.h().k(next.imgUrl, 12, null, next.width, next.height, bdUniqueId, new Object[0]);
                                } else {
                                    int i17 = i9;
                                    if (28 == i16) {
                                        i2 = i17;
                                        fg.h().k(next.imgUrl, 28, null, next.width, next.height, bdUniqueId, new Object[0]);
                                    } else {
                                        i2 = i17;
                                    }
                                }
                            }
                            i10 = i15;
                            i9 = i2;
                        }
                        adapter = knVar2;
                    }
                }
                knVar = adapter;
                int i18 = i10;
                int i19 = i9;
                if ((i6 > i || i19 >= bigImageMaxUsedMemory) && i18 > 30) {
                    return;
                }
                i8 = i18;
                i7 = i19;
            }
            firstVisiblePosition++;
            adapter = knVar;
        }
    }
}

package com.baidu.searchbox.crius.ui.recycler;

import android.util.Log;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.CriusRuntime;
import com.baidu.searchbox.crius.parser.CriusData;
import com.baidu.searchbox.crius.ui.CriusUI;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\u0018\u0000B\u0007¢\u0006\u0004\b\u0016\u0010\tJ\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/crius/ui/recycler/RecyclableItemHelper;", "Lcom/baidu/searchbox/crius/parser/CriusData;", "criusData", "", "index", "", "appendChildAt", "(Lcom/baidu/searchbox/crius/parser/CriusData;I)V", "clearRenderList", "()V", "viewType", "getCriusData", "(I)Lcom/baidu/searchbox/crius/parser/CriusData;", "getItemCount", "()I", "Lcom/baidu/searchbox/crius/ui/CriusUI;", "Landroid/view/View;", "getItemUI", "(I)Lcom/baidu/searchbox/crius/ui/CriusUI;", "", "renderList", "Ljava/util/List;", "<init>", "lib-crius_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class RecyclableItemHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<CriusData> renderList;

    public RecyclableItemHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.renderList = new ArrayList();
    }

    private final void clearRenderList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.renderList.clear();
        }
    }

    public final void appendChildAt(CriusData criusData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, criusData, i) == null) {
            Intrinsics.checkNotNullParameter(criusData, "criusData");
            if (i == 0 && getItemCount() > 0) {
                clearRenderList();
            }
            if (CriusRuntime.DEBUG) {
                Log.d(RecyclableItemHelperKt.TAG, "#appendChildAt# index=" + i + ", size=" + getItemCount());
            }
            this.renderList.add(i, criusData);
        }
    }

    public final CriusData getCriusData(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? this.renderList.get(i) : (CriusData) invokeI.objValue;
    }

    public final int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.renderList.size() : invokeV.intValue;
    }

    public final CriusUI<View> getItemUI(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            CriusUI<View> ui = this.renderList.get(i).getUI();
            Intrinsics.checkNotNullExpressionValue(ui, "renderList[viewType].ui");
            return ui;
        }
        return (CriusUI) invokeI.objValue;
    }
}

package com.baidu.searchbox.crius.ui.recycler;

import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.crius.CriusNode;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.crius.CriusRuntime;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.crius.parser.CriusData;
import com.baidu.searchbox.crius.ui.CriusUI;
import com.baidu.searchbox.crius.ui.view.CriusLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\f¢\u0006\u0004\b\"\u0010#J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0010\u001a\u00020\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0015\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/baidu/searchbox/crius/ui/recycler/CriusUIRecyclerView;", "Lcom/baidu/searchbox/crius/ui/CriusUI;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/RecyclerView;", "createView", "(Landroid/content/Context;)Landroidx/recyclerview/widget/RecyclerView;", "", CriusAttrConstants.POSITION, "Landroid/view/View;", "getChildAt", "(I)Landroid/view/View;", "Lcom/baidu/searchbox/crius/parser/CriusData;", "childData", "index", "", "insertChild", "(Lcom/baidu/searchbox/crius/parser/CriusData;I)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "criusData", "Lcom/baidu/searchbox/crius/parser/CriusData;", "getCriusData", "()Lcom/baidu/searchbox/crius/parser/CriusData;", "Lcom/baidu/searchbox/crius/ui/recycler/RecyclableItemHelper;", "itemHelper", "Lcom/baidu/searchbox/crius/ui/recycler/RecyclableItemHelper;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "llm", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Lcom/baidu/searchbox/crius/ui/recycler/RecyclerViewAdapter;", "rvAdapter", "Lcom/baidu/searchbox/crius/ui/recycler/RecyclerViewAdapter;", "<init>", "(Landroid/content/Context;Lcom/baidu/searchbox/crius/parser/CriusData;)V", "lib-crius_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class CriusUIRecyclerView extends CriusUI<RecyclerView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context context;
    public final CriusData criusData;
    public RecyclableItemHelper itemHelper;
    public LinearLayoutManager llm;
    public RecyclerViewAdapter rvAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CriusUIRecyclerView(Context context, CriusData criusData) {
        super(context, criusData);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, criusData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (CriusData) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(criusData, "criusData");
        this.context = context;
        this.criusData = criusData;
    }

    @Override // com.baidu.searchbox.crius.ui.CriusUI
    public View getChildAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            LinearLayoutManager linearLayoutManager = this.llm;
            if (linearLayoutManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("llm");
            }
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            LinearLayoutManager linearLayoutManager2 = this.llm;
            if (linearLayoutManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("llm");
            }
            int findLastVisibleItemPosition = linearLayoutManager2.findLastVisibleItemPosition();
            if (findFirstVisibleItemPosition <= i && findLastVisibleItemPosition >= i) {
                return ((RecyclerView) this.mView).getChildAt(i - findFirstVisibleItemPosition);
            }
            return null;
        }
        return (View) invokeI.objValue;
    }

    public final Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.context : (Context) invokeV.objValue;
    }

    public final CriusData getCriusData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.criusData : (CriusData) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.crius.ui.CriusUI, com.baidu.searchbox.crius.ui.RenderImplInterface
    public void insertChild(CriusData criusData, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, criusData, i) == null) || criusData == null || criusData.getUI() == null) {
            return;
        }
        this.renderObject.criusNode.setMeasureFunction(null);
        RecyclableItemHelper recyclableItemHelper = this.itemHelper;
        if (recyclableItemHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemHelper");
        }
        if (i <= recyclableItemHelper.getItemCount()) {
            RecyclableItemHelper recyclableItemHelper2 = this.itemHelper;
            if (recyclableItemHelper2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemHelper");
            }
            if (i < 0) {
                RecyclableItemHelper recyclableItemHelper3 = this.itemHelper;
                if (recyclableItemHelper3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("itemHelper");
                }
                i = recyclableItemHelper3.getItemCount();
            }
            recyclableItemHelper2.appendChildAt(criusData, i);
            CriusUI ui = criusData.getUI();
            Intrinsics.checkNotNullExpressionValue(ui, "childData.ui");
            if (!(ui.getView() instanceof CriusLayout)) {
                if (AppConfig.isDebug()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("RecyclerView, add view child: ");
                    CriusUI ui2 = criusData.getUI();
                    Intrinsics.checkNotNullExpressionValue(ui2, "childData.ui");
                    sb.append(ui2.getView());
                    Log.d(CriusUIRecyclerViewKt.TAG, sb.toString());
                }
                CriusNode criusNode = criusData.criusNode;
                Intrinsics.checkNotNullExpressionValue(criusNode, "childData.criusNode");
                CriusUI ui3 = criusData.getUI();
                Intrinsics.checkNotNullExpressionValue(ui3, "childData.ui");
                criusNode.setData(ui3.getView());
                criusData.criusNode.setMeasureFunction(new CriusLayout.ViewMeasureFunction());
            }
            RecyclerViewAdapter recyclerViewAdapter = this.rvAdapter;
            if (recyclerViewAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rvAdapter");
            }
            recyclerViewAdapter.notifyDataSetChanged();
        } else if (CriusRuntime.DEBUG) {
            Log.e(CriusUIRecyclerViewKt.TAG, "crius Error, appendChildAt: " + i + ", out of range");
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.crius.ui.CriusUI
    public RecyclerView createView(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            CriusData renderObject = this.renderObject;
            Intrinsics.checkNotNullExpressionValue(renderObject, "renderObject");
            if (renderObject.isHScroll()) {
                linearLayoutManager.setOrientation(0);
            }
            Unit unit = Unit.INSTANCE;
            this.llm = linearLayoutManager;
            RecyclableItemHelper recyclableItemHelper = new RecyclableItemHelper();
            this.itemHelper = recyclableItemHelper;
            if (recyclableItemHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemHelper");
            }
            this.rvAdapter = new RecyclerViewAdapter(recyclableItemHelper);
            CriusData renderObject2 = this.renderObject;
            Intrinsics.checkNotNullExpressionValue(renderObject2, "renderObject");
            CriusRecyclerView criusRecyclerView = new CriusRecyclerView(context, renderObject2);
            criusRecyclerView.setOverScrollMode(2);
            criusRecyclerView.setFocusable(false);
            criusRecyclerView.setFocusableInTouchMode(false);
            LinearLayoutManager linearLayoutManager2 = this.llm;
            if (linearLayoutManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("llm");
            }
            criusRecyclerView.setLayoutManager(linearLayoutManager2);
            RecyclerViewAdapter recyclerViewAdapter = this.rvAdapter;
            if (recyclerViewAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rvAdapter");
            }
            criusRecyclerView.setAdapter(recyclerViewAdapter);
            return criusRecyclerView;
        }
        return (RecyclerView) invokeL.objValue;
    }
}

package com.baidu.searchbox.crius.ui.recycler;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.crius.CriusNode;
import com.baidu.searchbox.crius.CriusRuntime;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.crius.parser.CriusData;
import com.baidu.searchbox.crius.ui.CriusUI;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u000b\u001a\u00020\n2\n\u0010\t\u001a\u00060\bR\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0010\u001a\u00060\bR\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/crius/ui/recycler/RecyclerViewAdapter;", "androidx/recyclerview/widget/RecyclerView$Adapter", "", "getItemCount", "()I", CriusAttrConstants.POSITION, "getItemViewType", "(I)I", "Lcom/baidu/searchbox/crius/ui/recycler/RecyclerViewAdapter$VH;", "holder", "", "onBindViewHolder", "(Lcom/baidu/searchbox/crius/ui/recycler/RecyclerViewAdapter$VH;I)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/baidu/searchbox/crius/ui/recycler/RecyclerViewAdapter$VH;", "Lcom/baidu/searchbox/crius/ui/recycler/RecyclableItemHelper;", "itemHelper", "Lcom/baidu/searchbox/crius/ui/recycler/RecyclableItemHelper;", "<init>", "(Lcom/baidu/searchbox/crius/ui/recycler/RecyclableItemHelper;)V", "VH", "lib-crius_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class RecyclerViewAdapter extends RecyclerView.Adapter<VH> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final RecyclableItemHelper itemHelper;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? i : invokeI.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(VH holder, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, holder, i) == null) {
            Intrinsics.checkNotNullParameter(holder, "holder");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/crius/ui/recycler/RecyclerViewAdapter$VH;", "androidx/recyclerview/widget/RecyclerView$ViewHolder", "Landroid/view/View;", "itemView", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "<init>", "(Lcom/baidu/searchbox/crius/ui/recycler/RecyclerViewAdapter;Landroid/view/View;)V", "lib-crius_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public final class VH extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final View itemView;
        public final /* synthetic */ RecyclerViewAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VH(RecyclerViewAdapter recyclerViewAdapter, View itemView) {
            super(itemView);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recyclerViewAdapter, itemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = recyclerViewAdapter;
            this.itemView = itemView;
        }

        public final View getItemView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.itemView;
            }
            return (View) invokeV.objValue;
        }
    }

    public RecyclerViewAdapter(RecyclableItemHelper itemHelper) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {itemHelper};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(itemHelper, "itemHelper");
        this.itemHelper = itemHelper;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.itemHelper.getItemCount();
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public VH onCreateViewHolder(ViewGroup parent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, parent, i)) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            CriusData criusData = this.itemHelper.getCriusData(i);
            if (CriusRuntime.DEBUG) {
                StringBuilder sb = new StringBuilder();
                sb.append("onCreateViewHolder, type: ");
                sb.append(criusData.type);
                sb.append(", layoutWidth=");
                CriusNode criusNode = criusData.criusNode;
                Intrinsics.checkNotNullExpressionValue(criusNode, "criusData.criusNode");
                sb.append(criusNode.getLayoutWidth());
                sb.append(", layoutHeight=");
                CriusNode criusNode2 = criusData.criusNode;
                Intrinsics.checkNotNullExpressionValue(criusNode2, "criusData.criusNode");
                sb.append(criusNode2.getLayoutHeight());
                sb.append(", pLayoutWidth=");
                CriusNode criusNode3 = criusData.parent.criusNode;
                Intrinsics.checkNotNullExpressionValue(criusNode3, "criusData.parent.criusNode");
                sb.append(criusNode3.getLayoutWidth());
                sb.append(", pLayoutHeight=");
                CriusNode criusNode4 = criusData.parent.criusNode;
                Intrinsics.checkNotNullExpressionValue(criusNode4, "criusData.parent.criusNode");
                sb.append(criusNode4.getLayoutHeight());
                Log.d(RecyclerViewAdapterKt.TAG, sb.toString());
            }
            CriusUI ui = criusData.getUI();
            Intrinsics.checkNotNullExpressionValue(ui, "criusData.ui");
            View itemView = ui.getView();
            criusData.getUI().setViewLp();
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            return new VH(this, itemView);
        }
        return (VH) invokeLI.objValue;
    }
}

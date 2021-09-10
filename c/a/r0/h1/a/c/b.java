package c.a.r0.h1.a.c;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f18912a;

    /* renamed from: b  reason: collision with root package name */
    public AbsHListView f18913b;

    public b(AbsHListView absHListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {absHListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18913b = absHListView;
    }

    @Override // c.a.r0.h1.a.c.a
    @TargetApi(11)
    public void a(ActionMode actionMode, int i2, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{actionMode, Integer.valueOf(i2), Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            this.f18912a.a(actionMode, i2, j2, z);
            if (this.f18913b.getCheckedItemCount() == 0) {
                actionMode.finish();
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f18912a != null : invokeV.booleanValue;
    }

    public void c(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f18912a = aVar;
        }
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, actionMode, menuItem)) == null) ? this.f18912a.onActionItemClicked(actionMode, menuItem) : invokeLL.booleanValue;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, actionMode, menu)) == null) {
            if (this.f18912a.onCreateActionMode(actionMode, menu)) {
                this.f18913b.setLongClickable(false);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, actionMode) == null) {
            this.f18912a.onDestroyActionMode(actionMode);
            AbsHListView absHListView = this.f18913b;
            absHListView.mChoiceActionMode = null;
            absHListView.clearChoices();
            AbsHListView absHListView2 = this.f18913b;
            absHListView2.mDataChanged = true;
            absHListView2.rememberSyncState();
            this.f18913b.requestLayout();
            this.f18913b.setLongClickable(true);
        }
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, actionMode, menu)) == null) ? this.f18912a.onPrepareActionMode(actionMode, menu) : invokeLL.booleanValue;
    }
}

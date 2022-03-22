package com.baidu.live.business.base;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class LiveFeedBaseHolder extends RecyclerView.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LiveBaseItemView a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveFeedBaseHolder(LiveBaseItemView liveBaseItemView) {
        super(liveBaseItemView);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {liveBaseItemView};
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
        this.a = liveBaseItemView;
    }

    public void b() {
        LiveBaseItemView liveBaseItemView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (liveBaseItemView = this.a) == null) {
            return;
        }
        liveBaseItemView.a();
    }

    public void c() {
        LiveBaseItemView liveBaseItemView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (liveBaseItemView = this.a) == null) {
            return;
        }
        liveBaseItemView.b();
    }

    public void d() {
        LiveBaseItemView liveBaseItemView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (liveBaseItemView = this.a) == null) {
            return;
        }
        liveBaseItemView.c();
    }
}

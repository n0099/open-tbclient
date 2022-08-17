package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public TextView b;
    public Context c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = false;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0865, (ViewGroup) this, true);
            this.a = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09216f);
            this.b = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092132);
            this.c = context;
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0109);
        }
    }

    public final void c(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) == null) || this.b == null || threadData == null || !this.e) {
            return;
        }
        if (threadData.getReply_num() >= 0) {
            this.b.setVisibility(0);
            this.b.setText(String.format(this.c.getString(R.string.obfuscated_res_0x7f0f040b), StringHelper.numberUniformFormat(threadData.getReply_num())));
            return;
        }
        this.b.setVisibility(8);
    }

    public final void d(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, threadData) == null) && this.b != null && threadData != null && this.h && threadData.isSharedLiveThread()) {
            this.b.setVisibility(0);
            this.b.setText(String.format(this.c.getString(R.string.obfuscated_res_0x7f0f0e6a), StringHelper.numberUniformFormat((threadData.getThreadAlaInfo() == null || threadData.getThreadAlaInfo().share_info == null) ? 0 : threadData.getThreadAlaInfo().share_info.share_count)));
        }
    }

    public final void e(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, threadData) == null) || this.a == null || threadData == null || !this.d) {
            return;
        }
        if (threadData.getView_num() >= 0) {
            this.a.setVisibility(0);
            this.a.setText(String.format(this.c.getString(R.string.obfuscated_res_0x7f0f0e6d), StringHelper.numberUniformFormat(threadData.getView_num())));
            return;
        }
        this.a.setVisibility(8);
    }

    public final void f(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, threadData) == null) || this.a == null || threadData == null || !this.f || threadData.getThreadAlaInfo() == null || !threadData.isSharedLiveThread()) {
            return;
        }
        this.a.setVisibility(0);
        this.a.setText(String.format(this.c.getString(R.string.obfuscated_res_0x7f0f0e6b), StringHelper.numberUniformFormat(threadData.getThreadAlaInfo().audience_count)));
    }

    public final void g(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, threadData) == null) && this.b != null && threadData != null && this.g && threadData.isSharedLiveThread()) {
            this.b.setVisibility(0);
            this.b.setText(String.format(this.c.getString(R.string.obfuscated_res_0x7f0f0e6c), StringHelper.numberUniformFormat(threadData.getAgreeNum())));
        }
    }

    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, threadData) == null) {
            if (threadData == null) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            f(threadData);
            e(threadData);
            c(threadData);
            g(threadData);
            d(threadData);
        }
    }

    public void setIsShowAudienceNum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f = z;
        }
    }

    public void setIsShowReadNum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.d = z;
        }
    }

    public void setIsShowReplayNum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.e = z;
        }
    }

    public void setIsShowShareNum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.h = z;
        }
    }

    public void setIsShowZanNum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.g = z;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = false;
        a(context);
    }
}

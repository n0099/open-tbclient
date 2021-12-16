package c.a.s0.s2.q.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f22505b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f22506c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f22507d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f22508e;

    public f(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = view;
        this.f22505b = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.f22506c = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.f22507d = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.f22508e = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundResource(this.a, R.drawable.bg_rec_lick);
            SkinManager.setBackgroundResource(this.f22505b, R.drawable.bg_rec_comment);
            SkinManager.setViewTextColor(this.f22506c, R.color.CAM_X0108, 1);
            SkinManager.setViewTextColor(this.f22507d, R.color.CAM_X0110, 1);
            SkinManager.setImageResource(this.f22508e, R.drawable.recommend_pb_share_selector);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.f22505b.setOnClickListener(onClickListener);
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f22507d.setText(str);
        }
    }

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f22508e.setOnClickListener(onClickListener);
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.a.setVisibility(z ? 0 : 8);
        }
    }
}

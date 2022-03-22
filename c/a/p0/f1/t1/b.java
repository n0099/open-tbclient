package c.a.p0.f1.t1;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public BarImageView f14643b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f14644c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f14645d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f14646e;

    /* renamed from: f  reason: collision with root package name */
    public EntelechyUserLikeButton f14647f;

    /* renamed from: g  reason: collision with root package name */
    public View f14648g;

    /* renamed from: h  reason: collision with root package name */
    public int f14649h;
    public int i;

    public b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = 3;
        this.a = view;
        this.f14643b = (BarImageView) view.findViewById(R.id.obfuscated_res_0x7f090ae6);
        this.f14644c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090ae9);
        this.f14645d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090ae7);
        this.f14646e = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090ae8);
        this.f14647f = (EntelechyUserLikeButton) view.findViewById(R.id.obfuscated_res_0x7f090ae4);
        this.f14648g = view.findViewById(R.id.obfuscated_res_0x7f090ae5);
    }
}

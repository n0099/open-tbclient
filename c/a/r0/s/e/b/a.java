package c.a.r0.s.e.b;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public EditText f24537a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f24538b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f24539c;

    /* renamed from: d  reason: collision with root package name */
    public TextWatcher f24540d;

    /* renamed from: e  reason: collision with root package name */
    public c f24541e;

    /* renamed from: f  reason: collision with root package name */
    public Context f24542f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext<?> f24543g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f24544h;

    /* renamed from: c.a.r0.s.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1141a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24545e;

        public View$OnClickListenerC1141a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24545e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f24545e.f24538b) {
                    String charSequence2String = k.charSequence2String(this.f24545e.f24537a.getText(), null);
                    if (StringUtils.isNULL(charSequence2String)) {
                        return;
                    }
                    if (charSequence2String.trim().length() != 0) {
                        this.f24545e.i(charSequence2String.trim());
                        this.f24545e.f24538b.setClickable(false);
                    } else if (charSequence2String.length() > 0) {
                        this.f24545e.f24543g.showToast(R.string.input_content);
                    }
                } else if (view == this.f24545e.f24539c) {
                    this.f24545e.k("");
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24546e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24546e = aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (TextUtils.isEmpty(editable)) {
                    this.f24546e.f24539c.setVisibility(8);
                } else {
                    this.f24546e.f24539c.setVisibility(0);
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(String str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f24544h = new View$OnClickListenerC1141a(this);
        this.f24543g = tbPageContext;
        this.f24542f = tbPageContext.getPageActivity();
        this.f24537a = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.f24538b = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.f24539c = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.f24538b.setOnClickListener(this.f24544h);
        this.f24539c.setOnClickListener(this.f24544h);
        b bVar = new b(this);
        this.f24540d = bVar;
        this.f24537a.addTextChangedListener(bVar);
        f(TbadkCoreApplication.getInst().getSkinType());
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            SkinManager.setViewTextColor(this.f24538b, R.color.CAM_X0111, 1);
            this.f24537a.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            SkinManager.setImageResource(this.f24539c, R.drawable.icon_search_close);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            l.x(this.f24542f, this.f24537a);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f24537a.removeTextChangedListener(this.f24540d);
        }
    }

    public final void i(String str) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (cVar = this.f24541e) == null) {
            return;
        }
        cVar.a(str);
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f24538b.setClickable(z);
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f24537a.setText(str);
        }
    }

    public void l(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.f24541e = cVar;
        }
    }
}

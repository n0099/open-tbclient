package c.a.p0.f1.q1;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.p0.a4.b0;
import c.a.p0.f1.q1.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.HeadItem;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends c.a.p0.f1.q1.a {
    public static /* synthetic */ Interceptable $ic;
    public static final int A;
    public static final int u;
    public static final int v;
    public static final int w;
    public static final int x;
    public static final int y;
    public static final int z;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView m;
    public TextView n;
    public TextView o;
    public View p;
    public RankStarView q;
    public EditText r;
    public TextView s;
    public Editable t;

    /* loaded from: classes2.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent == null || motionEvent.getAction() != 2) {
                    return false;
                }
                n.w(this.a.a, view);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* renamed from: c.a.p0.f1.q1.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1088b implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C1088b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.p0.f1.q1.c.b
        public void a(InputMethodManager inputMethodManager) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, inputMethodManager) == null) || inputMethodManager == null) {
                return;
            }
            b bVar = this.a;
            bVar.a.HidenSoftKeyPad(inputMethodManager, bVar.r);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.a.t = editable;
                if (this.a.t.length() > 500) {
                    this.a.s.setText(String.format(this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f06fb), Integer.valueOf(500 - this.a.t.length())));
                    this.a.s.setVisibility(0);
                } else {
                    this.a.s.setVisibility(8);
                }
                this.a.s();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements b0.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.p0.a4.b0.f
        public void onDraftLoaded(WriteData writeData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, writeData) == null) || writeData == null) {
                return;
            }
            this.a.q.setStarCount(writeData.getOtherGrade());
            this.a.r.setText(writeData.getOtherComment());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-53282707, "Lc/a/p0/f1/q1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-53282707, "Lc/a/p0/f1/q1/b;");
                return;
            }
        }
        u = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
        v = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
        w = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds234);
        x = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
        y = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
        z = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds208);
        A = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, forumWriteData, serializableItemInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((BaseFragmentActivity) objArr2[0], (ForumWriteData) objArr2[1], (SerializableItemInfo) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.p0.f1.q1.a
    public void c() {
        ForumWriteData forumWriteData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (forumWriteData = this.f14418b) == null) {
            return;
        }
        b0.r(String.valueOf(forumWriteData.forumId), new d(this));
    }

    @Override // c.a.p0.f1.q1.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0047, (ViewGroup) null);
            this.f14419c = inflate;
            this.f14420d = (NavigationBar) inflate.findViewById(R.id.obfuscated_res_0x7f091519);
            this.m = (TbImageView) this.f14419c.findViewById(R.id.obfuscated_res_0x7f090f7b);
            this.n = (TextView) this.f14419c.findViewById(R.id.obfuscated_res_0x7f090fab);
            this.o = (TextView) this.f14419c.findViewById(R.id.obfuscated_res_0x7f090fa6);
            this.p = this.f14419c.findViewById(R.id.obfuscated_res_0x7f0907e1);
            this.q = (RankStarView) this.f14419c.findViewById(R.id.obfuscated_res_0x7f090fa2);
            this.r = (EditText) this.f14419c.findViewById(R.id.obfuscated_res_0x7f091626);
            this.s = (TextView) this.f14419c.findViewById(R.id.obfuscated_res_0x7f092490);
            this.m.setPlaceHolder(2);
            this.m.setConrers(15);
            this.m.setRadius(n.f(this.a, R.dimen.tbds10));
            this.q.setStarSpacing(n.f(this.a, R.dimen.tbds24));
            this.q.setClickable(true);
            this.r.setLineSpacing(n.f(this.a, R.dimen.tbds16), 1.0f);
            SerializableItemInfo serializableItemInfo = this.f14424h;
            if (serializableItemInfo != null) {
                u(serializableItemInfo.getTags());
                this.n.setText(this.f14424h.getName());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
                if (this.f14424h.getIconSize() == 1.0d) {
                    layoutParams.width = u;
                    layoutParams.height = v;
                } else if (this.f14424h.getIconSize() == 0.67d) {
                    layoutParams.width = w;
                    layoutParams.height = x;
                } else {
                    layoutParams.width = y;
                    layoutParams.height = z;
                }
                this.m.setLayoutParams(layoutParams);
                this.m.J(this.f14424h.icon_url, 10, false);
                if (this.f14424h.getScore() != null && this.f14424h.getScore().isCommented == 1) {
                    this.q.setStarCount(this.f14424h.getScore().getCommentStar());
                }
            }
            this.f14419c.findViewById(R.id.obfuscated_res_0x7f091c0f).setOnTouchListener(new a(this));
            this.i.h(new C1088b(this));
        }
    }

    @Override // c.a.p0.f1.q1.a
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f14422f.setOnClickListener(this);
            this.f14423g.setOnClickListener(this);
            this.r.addTextChangedListener(new c(this));
        }
    }

    @Override // c.a.p0.f1.q1.a
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.i();
            SkinManager.setBackgroundColor(this.p, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0109);
            this.q.e(TbadkCoreApplication.getInst().getSkinType());
            SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0105);
            this.r.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0301);
            TbImageView tbImageView = this.m;
            if (tbImageView != null) {
                tbImageView.setPlaceHolder(2);
                this.m.invalidate();
            }
        }
    }

    @Override // c.a.p0.f1.q1.a
    public void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f14418b == null) {
            return;
        }
        WriteData writeData = new WriteData();
        writeData.setOtherGrade(this.q.getStarCount());
        writeData.setOtherComment(this.r.getText().toString());
        b0.B(String.valueOf(this.f14418b.forumId), writeData);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            if (view == this.f14422f) {
                l();
            } else if (view == this.f14423g) {
                if (!TextUtils.isEmpty(this.t) && this.t.length() >= 20) {
                    if (this.t.length() > 500) {
                        n.M(this.a, R.string.obfuscated_res_0x7f0f0ceb);
                        return;
                    } else {
                        this.i.g(this.t.toString(), t(), this.f14418b);
                        return;
                    }
                }
                n.M(this.a, R.string.obfuscated_res_0x7f0f0cec);
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (!TextUtils.isEmpty(this.t) && this.t.length() >= 20 && this.t.length() <= 500) {
                this.f14423g.setAlpha(1.0f);
            } else {
                this.f14423g.setAlpha(0.5f);
            }
        }
    }

    public final String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new HeadItem("", String.valueOf(this.q.getStarCount()), 2));
            return this.j.toJson(arrayList);
        }
        return (String) invokeV.objValue;
    }

    public final void u(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            if (list != null && !list.isEmpty()) {
                this.o.setVisibility(0);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    spannableStringBuilder.append((CharSequence) list.get(i));
                    if (i != list.size() - 1) {
                        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" ");
                        spannableStringBuilder2.setSpan(new c.a.o0.r.l0.r.b(A), 0, spannableStringBuilder2.length(), 33);
                        spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                    }
                }
                this.o.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
                return;
            }
            this.o.setVisibility(8);
        }
    }
}

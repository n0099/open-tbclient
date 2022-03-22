package c.a.p0.f1.q1;

import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.p0.a4.b0;
import c.a.p0.f1.q1.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.SearchMajorActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.HeadItem;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class d extends c.a.p0.f1.q1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RankStarView A;
    public RankStarView B;
    public Editable C;
    public Editable D;
    public TextView E;
    public TextView F;
    public TbImageView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public EditText v;
    public EditText w;
    public ImageView x;
    public View y;
    public View z;

    /* loaded from: classes2.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
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

    /* loaded from: classes2.dex */
    public class b implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.p0.f1.q1.c.b
        public void a(InputMethodManager inputMethodManager) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, inputMethodManager) == null) || inputMethodManager == null) {
                return;
            }
            d dVar = this.a;
            dVar.a.HidenSoftKeyPad(inputMethodManager, dVar.v);
            d dVar2 = this.a;
            dVar2.a.HidenSoftKeyPad(inputMethodManager, dVar2.w);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.a.C = editable;
                if (this.a.C.length() <= 500) {
                    this.a.E.setVisibility(4);
                } else {
                    this.a.E.setText((500 - this.a.C.length()) + "/500");
                    this.a.E.setVisibility(0);
                }
                this.a.A();
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

    /* renamed from: c.a.p0.f1.q1.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1089d implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public C1089d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.a.D = editable;
                if (this.a.D.length() <= 500) {
                    this.a.F.setVisibility(4);
                } else {
                    this.a.F.setText((500 - this.a.D.length()) + "/500");
                    this.a.F.setVisibility(0);
                }
                this.a.A();
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
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (view.getId() == R.id.obfuscated_res_0x7f09226e) {
                    d dVar = this.a;
                    if (dVar.z(dVar.v)) {
                        view.getParent().requestDisallowInterceptTouchEvent(true);
                        if (motionEvent.getAction() == 1) {
                            view.getParent().requestDisallowInterceptTouchEvent(false);
                        }
                    }
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public f(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (view.getId() == R.id.obfuscated_res_0x7f092277) {
                    d dVar = this.a;
                    if (dVar.z(dVar.w)) {
                        view.getParent().requestDisallowInterceptTouchEvent(true);
                        if (motionEvent.getAction() == 1) {
                            view.getParent().requestDisallowInterceptTouchEvent(false);
                        }
                    }
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class g implements b0.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public g(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.p0.a4.b0.f
        public void onDraftLoaded(WriteData writeData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, writeData) == null) || writeData == null) {
                return;
            }
            try {
                this.a.B.setStarCount(Integer.parseInt(writeData.getmUniversitySubjectGrade()));
            } catch (NumberFormatException unused) {
                this.a.B.setStarCount(0.0f);
            }
            try {
                this.a.A.setStarCount(Integer.parseInt(writeData.getmUniversityGrade()));
            } catch (NumberFormatException unused2) {
                this.a.A.setStarCount(0.0f);
            }
            this.a.r.setText(writeData.getmUniversitySubjectContent());
            this.a.v.setText(writeData.getmUniversityComment());
            this.a.w.setText(writeData.getmUniversitySubjectComment());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, forumWriteData, serializableItemInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((BaseFragmentActivity) objArr2[0], (ForumWriteData) objArr2[1], (SerializableItemInfo) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!TextUtils.isEmpty(this.C) && this.C.length() >= 20 && !TextUtils.isEmpty(this.D) && this.D.length() >= 20 && !this.a.getString(R.string.obfuscated_res_0x7f0f10ce).equals(this.r.getText()) && this.C.length() <= 500 && this.D.length() <= 500) {
                this.f14423g.setAlpha(1.0f);
            } else {
                this.f14423g.setAlpha(0.5f);
            }
        }
    }

    public final String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            int starCount = this.B.getStarCount();
            int starCount2 = this.A.getStarCount();
            if (starCount != 0) {
                arrayList.add(new HeadItem("学校评分", String.valueOf(starCount2), 2));
            }
            arrayList.add(new HeadItem("专业", this.r.getText().toString(), 1));
            if (starCount2 != 0) {
                arrayList.add(new HeadItem("专业评分", String.valueOf(starCount), 2));
            }
            return this.j.toJson(arrayList);
        }
        return (String) invokeV.objValue;
    }

    public final String C(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            if (list != null) {
                StringBuilder sb = new StringBuilder();
                for (String str : list) {
                    sb.append(str);
                    sb.append(" ");
                }
                return sb.toString();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // c.a.p0.f1.q1.a
    public void c() {
        ForumWriteData forumWriteData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (forumWriteData = this.f14418b) == null) {
            return;
        }
        b0.r(String.valueOf(forumWriteData.forumId), new g(this));
    }

    @Override // c.a.p0.f1.q1.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d005a, (ViewGroup) null);
            this.f14419c = inflate;
            this.f14420d = (NavigationBar) inflate.findViewById(R.id.obfuscated_res_0x7f091519);
            this.m = (TbImageView) this.f14419c.findViewById(R.id.obfuscated_res_0x7f092274);
            this.n = (TextView) this.f14419c.findViewById(R.id.obfuscated_res_0x7f092275);
            this.o = (TextView) this.f14419c.findViewById(R.id.obfuscated_res_0x7f092271);
            this.p = (TextView) this.f14419c.findViewById(R.id.obfuscated_res_0x7f092272);
            this.q = (TextView) this.f14419c.findViewById(R.id.obfuscated_res_0x7f092276);
            this.r = (TextView) this.f14419c.findViewById(R.id.obfuscated_res_0x7f092279);
            this.x = (ImageView) this.f14419c.findViewById(R.id.obfuscated_res_0x7f091dce);
            this.s = (TextView) this.f14419c.findViewById(R.id.obfuscated_res_0x7f09227a);
            this.t = (TextView) this.f14419c.findViewById(R.id.obfuscated_res_0x7f092270);
            this.u = (TextView) this.f14419c.findViewById(R.id.obfuscated_res_0x7f091dcb);
            EditText editText = (EditText) this.f14419c.findViewById(R.id.obfuscated_res_0x7f09226e);
            this.v = editText;
            editText.setLineSpacing(n.f(this.a, R.dimen.tbds16), 1.0f);
            EditText editText2 = (EditText) this.f14419c.findViewById(R.id.obfuscated_res_0x7f092277);
            this.w = editText2;
            editText2.setLineSpacing(n.f(this.a, R.dimen.tbds16), 1.0f);
            this.E = (TextView) this.f14419c.findViewById(R.id.obfuscated_res_0x7f09226f);
            this.F = (TextView) this.f14419c.findViewById(R.id.obfuscated_res_0x7f092278);
            this.z = this.f14419c.findViewById(R.id.obfuscated_res_0x7f091c8b);
            RankStarView rankStarView = (RankStarView) this.f14419c.findViewById(R.id.obfuscated_res_0x7f092273);
            this.A = rankStarView;
            rankStarView.setClickable(true);
            this.A.setStarSpacing(n.f(this.a, R.dimen.tbds24));
            RankStarView rankStarView2 = (RankStarView) this.f14419c.findViewById(R.id.obfuscated_res_0x7f09227b);
            this.B = rankStarView2;
            rankStarView2.setClickable(true);
            this.B.setStarSpacing(n.f(this.a, R.dimen.tbds24));
            this.y = this.f14419c.findViewById(R.id.obfuscated_res_0x7f0907e1);
            SerializableItemInfo serializableItemInfo = this.f14424h;
            if (serializableItemInfo != null) {
                this.o.setText(C(serializableItemInfo.getTags()));
                this.n.setText(this.f14424h.getName());
                this.m.J(this.f14424h.icon_url, 10, false);
            }
            this.m.setPlaceHolder(2);
            this.m.setPageId(this.a.getUniqueId());
            this.m.setConrers(15);
            this.m.setRadius(n.f(this.a, R.dimen.tbds10));
            this.f14419c.findViewById(R.id.obfuscated_res_0x7f091c0f).setOnTouchListener(new a(this));
            this.i.h(new b(this));
        }
    }

    @Override // c.a.p0.f1.q1.a
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f14422f.setOnClickListener(this);
            this.f14423g.setOnClickListener(this);
            this.z.setOnClickListener(this);
            this.v.addTextChangedListener(new c(this));
            this.w.addTextChangedListener(new C1089d(this));
            this.v.setOnTouchListener(new e(this));
            this.w.setOnTouchListener(new f(this));
        }
    }

    @Override // c.a.p0.f1.q1.a
    public void h(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048582, this, i, i2, intent) == null) && i2 == -1 && intent != null && i == 25047) {
            String stringExtra = intent.getStringExtra(IntentConfig.SEARCH_MAJOR_NAME);
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            this.r.setText(stringExtra);
            SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0105);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.x, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            A();
        }
    }

    @Override // c.a.p0.f1.q1.a
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.i();
            SkinManager.setBackgroundColor(this.y, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0105);
            if (this.a.getString(R.string.obfuscated_res_0x7f0f10ce).equals(this.r.getText())) {
                SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0109);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.x, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0105);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.x, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.u, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.v, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.w, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.E, (int) R.color.CAM_X0301);
            SkinManager.setViewTextColor(this.F, (int) R.color.CAM_X0301);
            this.v.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.w.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
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
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f14418b == null) {
            return;
        }
        WriteData writeData = new WriteData();
        int starCount = this.B.getStarCount();
        writeData.setmUniversityGrade(String.valueOf(this.A.getStarCount()));
        writeData.setmUniversitySubjectGrade(String.valueOf(starCount));
        writeData.setmUniversitySubjectContent(this.r.getText().toString());
        writeData.setmUniversityComment(this.v.getText().toString());
        writeData.setmUniversitySubjectComment(this.w.getText().toString());
        b0.B(String.valueOf(this.f14418b.forumId), writeData);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            if (view == this.f14422f) {
                l();
            } else if (view == this.z) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchMajorActivityConfig(this.a, 25047)));
            } else if (view == this.f14423g) {
                if (!TextUtils.isEmpty(this.C) && !TextUtils.isEmpty(this.D) && !this.a.getString(R.string.obfuscated_res_0x7f0f10ce).equals(this.r.getText())) {
                    if (this.C.length() < 20) {
                        n.M(this.a, R.string.obfuscated_res_0x7f0f147a);
                        return;
                    } else if (this.D.length() < 20) {
                        n.M(this.a, R.string.obfuscated_res_0x7f0f11e5);
                        return;
                    } else if (this.C.length() > 500) {
                        n.M(this.a, R.string.obfuscated_res_0x7f0f1478);
                        return;
                    } else if (this.D.length() > 500) {
                        n.M(this.a, R.string.obfuscated_res_0x7f0f11e4);
                        return;
                    } else {
                        this.i.g("学校评价：" + ((Object) this.C) + "\n专业评价：" + ((Object) this.D), B(), this.f14418b);
                        return;
                    }
                }
                n.M(this.a, R.string.obfuscated_res_0x7f0f1479);
            }
        }
    }

    public final boolean z(EditText editText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, editText)) == null) {
            int scrollY = editText.getScrollY();
            int height = editText.getLayout().getHeight() - ((editText.getHeight() - editText.getCompoundPaddingTop()) - editText.getCompoundPaddingBottom());
            if (height == 0) {
                return false;
            }
            return scrollY > 0 || scrollY < height - 1;
        }
        return invokeL.booleanValue;
    }
}

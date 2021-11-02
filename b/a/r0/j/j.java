package b.a.r0.j;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
import b.a.q0.s.q.x0;
import b.a.r0.j.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRuleEditActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public i B;
    public UserData C;
    public boolean D;
    public boolean E;
    public int F;
    public ClickableSpan G;
    public boolean H;
    public CompoundButton.OnCheckedChangeListener I;
    public PopupWindow.OnDismissListener J;
    public CustomMessageListener K;

    /* renamed from: a  reason: collision with root package name */
    public Context f18275a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f18276b;

    /* renamed from: c  reason: collision with root package name */
    public x0 f18277c;

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<String> f18278d;

    /* renamed from: e  reason: collision with root package name */
    public List<b.C0927b> f18279e;

    /* renamed from: f  reason: collision with root package name */
    public int f18280f;

    /* renamed from: g  reason: collision with root package name */
    public int f18281g;

    /* renamed from: h  reason: collision with root package name */
    public int f18282h;

    /* renamed from: i  reason: collision with root package name */
    public NEGFeedBackView.b f18283i;
    public PopupWindow j;
    public View k;
    public b.a.r0.j.b l;
    public boolean m;
    public int n;
    public PopupWindow o;
    public ViewGroup p;
    public EMTextView q;
    public EMTextView r;
    public EMTextView s;
    public EMTextView t;
    public EMTextView u;
    public LinearLayout v;
    public String w;
    public g x;
    public h y;
    public b.a.q0.s.g0.a z;

    /* loaded from: classes4.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f18284e;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18284e = jVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                if (this.f18284e.f18283i != null) {
                    this.f18284e.f18283i.onCheckedChanged(this.f18284e.f18277c, compoundButton, z);
                }
                if (compoundButton.getTag() instanceof b.C0927b) {
                    b.C0927b c0927b = (b.C0927b) compoundButton.getTag();
                    if (z) {
                        if (this.f18284e.f18279e.contains(c0927b)) {
                            return;
                        }
                        this.f18284e.f18279e.add(c0927b);
                        if (!this.f18284e.D || this.f18284e.r == null) {
                            return;
                        }
                        this.f18284e.r.setClickable(true);
                        b.a.q0.s.u.c.d(this.f18284e.r).v(R.color.CAM_X0302);
                        return;
                    }
                    this.f18284e.f18279e.remove(c0927b);
                    if (!this.f18284e.D || this.f18284e.r == null) {
                        return;
                    }
                    this.f18284e.r.setClickable(false);
                    this.f18284e.r.setTextColor(b.a.r0.l3.c.a(SkinManager.getColor(R.color.CAM_X0302), SkinManager.RESOURCE_ALPHA_DISABLE));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f18285e;

        public b(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18285e = jVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f18285e.j == null) {
                return;
            }
            this.f18285e.j.dismiss();
            this.f18285e.j = null;
            MessageManager.getInstance().unRegisterListener(this.f18285e.K);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f18286a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(j jVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18286a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                this.f18286a.t();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f18287e;

        public d(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18287e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f18287e.j != null) {
                    this.f18287e.j.dismiss();
                    this.f18287e.j = null;
                }
                if (this.f18287e.o != null) {
                    this.f18287e.o.dismiss();
                    this.f18287e.o = null;
                }
                if (this.f18287e.H) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_CANCEL_CLICK).param("obj_source", this.f18287e.w));
                }
                if (this.f18287e.x != null) {
                    this.f18287e.x.onClick();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f18288e;

        public e(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18288e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                JSONObject w = this.f18288e.w();
                if (this.f18288e.w == "3" || this.f18288e.w == "4" || this.f18288e.w == "1") {
                    this.f18288e.v();
                } else if (w != null) {
                    this.f18288e.H();
                    CustomMessage customMessage = new CustomMessage(2016489, this.f18288e.f18276b.getUniqueId());
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, w);
                    customResponsedMessage.setOrginalMessage(customMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f18289e;

        public f(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18289e = jVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumRuleEditActivityConfig(this.f18289e.f18275a, this.f18289e.B.b(), this.f18289e.B.c(), this.f18289e.B.a(), this.f18289e.B.g(), ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_FRS)));
                if (this.f18289e.j != null) {
                    this.f18289e.j.dismiss();
                    this.f18289e.j = null;
                }
                if (this.f18289e.o != null) {
                    this.f18289e.o.dismiss();
                    this.f18289e.o = null;
                }
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setColor(SkinManager.getColor(R.color.CAM_X0304));
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface g {
        void onClick();
    }

    /* loaded from: classes4.dex */
    public interface h {
        void a(JSONArray jSONArray);
    }

    public j(TbPageContext tbPageContext, View view, i iVar, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, iVar, userData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18275a = null;
        this.f18277c = null;
        this.f18278d = null;
        this.f18279e = new ArrayList();
        this.f18283i = null;
        this.o = null;
        this.z = null;
        this.A = 3;
        this.D = true;
        this.E = false;
        this.I = new a(this);
        this.J = new b(this);
        this.K = new c(this, 2001304);
        this.f18275a = tbPageContext.getPageActivity();
        this.f18276b = tbPageContext;
        this.k = view;
        this.B = iVar;
        this.C = userData;
        A();
        z();
    }

    public final void A() {
        UserData userData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            i iVar = this.B;
            if (iVar != null) {
                if (iVar.e() == 1) {
                    this.D = false;
                } else {
                    this.D = true;
                }
                if (this.B.d() == 1) {
                    this.E = false;
                } else {
                    this.E = true;
                }
            }
            if (!this.E || (userData = this.C) == null) {
                return;
            }
            this.F = userData.getIs_manager();
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.m && this.f18279e.size() != 0) {
            this.f18279e.clear();
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.H = z;
        }
    }

    public void D(x0 x0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, x0Var) == null) || x0Var == null) {
            return;
        }
        this.f18277c = x0Var;
        SparseArray<String> b2 = x0Var.b();
        this.f18278d = b2;
        if (b2 != null && b2.size() > 8) {
            for (int size = this.f18278d.size() - 1; size >= 8; size--) {
                this.f18278d.removeAt(size);
            }
        }
        this.l.j(x0Var);
    }

    public void E(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, strArr) == null) {
            this.l.k(strArr);
        }
    }

    public void F(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hVar) == null) {
            this.y = hVar;
        }
    }

    public void G(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || this.f18275a == null) {
            return;
        }
        this.w = str;
        View x = x();
        if (x != null && x.getParent() != null) {
            ((ViewGroup) x.getParent()).removeView(x);
        }
        if (x == null) {
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0205));
        gradientDrawable.setCornerRadius(l.g(this.f18275a, R.dimen.tbds31));
        x.setBackgroundDrawable(gradientDrawable);
        t();
        this.f18280f = y();
        PopupWindow popupWindow = new PopupWindow(x, this.f18281g, this.f18280f);
        this.o = popupWindow;
        popupWindow.setFocusable(true);
        this.o.setTouchable(true);
        this.o.setOnDismissListener(this.J);
        B();
        PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(this.f18275a).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
        this.j = popupWindow2;
        if (Build.VERSION.SDK_INT >= 22) {
            popupWindow2.setAttachedInDecor(false);
        }
        this.j.showAtLocation(this.k, 0, 0, 0);
        this.o.showAtLocation(this.k, 17, 0, 0);
        NEGFeedBackView.b bVar = this.f18283i;
        if (bVar != null) {
            bVar.onNEGFeedbackWindowShow(this.f18277c);
        }
        this.m = true;
        MessageManager.getInstance().registerListener(this.K);
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.z == null) {
                this.z = new b.a.q0.s.g0.a(this.f18276b);
            }
            this.z.i(R.string.loading);
            this.z.h(true);
        }
    }

    public final void t() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.A) {
            return;
        }
        SkinManager.setViewTextColor(this.s, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColorSelector(this.q, R.color.CAM_X0105);
        if (this.D) {
            this.r.setTextColor(b.a.r0.l3.c.a(SkinManager.getColor(R.color.CAM_X0302), SkinManager.RESOURCE_ALPHA_DISABLE));
            this.r.setClickable(false);
        } else {
            b.a.q0.s.u.c.d(this.r).v(R.color.CAM_X0302);
        }
        SkinManager.setViewTextColor(this.t, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.u, R.color.CAM_X0105, 1);
        this.u.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.pic_popup_guide));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0205));
        gradientDrawable.setCornerRadius(l.g(this.f18275a, R.dimen.tbds31));
        this.p.setBackgroundDrawable(gradientDrawable);
        this.A = skinType;
    }

    public void u() {
        b.a.q0.s.g0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (aVar = this.z) == null) {
            return;
        }
        aVar.h(false);
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            PopupWindow popupWindow = this.o;
            if (popupWindow != null) {
                popupWindow.dismiss();
                this.o = null;
            }
            PopupWindow popupWindow2 = this.j;
            if (popupWindow2 != null) {
                popupWindow2.dismiss();
                this.j = null;
            }
        }
    }

    public final JSONObject w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (this.f18277c == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            int i2 = 0;
            if (!ListUtils.isEmpty(this.f18279e)) {
                int i3 = 0;
                while (i2 < this.f18279e.size()) {
                    b.C0927b c0927b = this.f18279e.get(i2);
                    if (c0927b != null) {
                        jSONArray.put(String.valueOf(c0927b.f18209b));
                        i3 = c0927b.f18208a + 1;
                    }
                    i2++;
                }
                i2 = i3;
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_DELETE_THREAD_REASON).param("obj_source", this.w).param("obj_type", i2));
            if (this.H) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_REASON_CLICK).param("obj_source", this.w).param("obj_type", i2));
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_CONFIRM_CLICK).param("obj_source", this.w).param("obj_type", i2));
            }
            h hVar = this.y;
            if (hVar != null) {
                hVar.a(jSONArray);
            }
            try {
                jSONObject.put("reason", jSONArray);
                jSONObject.put("thread_ids", this.f18277c.g());
                jSONObject.put("type", this.f18277c.a());
                jSONObject.put("forum_id", this.f18277c.c());
                jSONObject.put("is_frs_masks", this.f18277c.d());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final View x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            Context context = this.f18275a;
            if (context == null) {
                return null;
            }
            if (this.p == null) {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.ueg_new_delete_thread_view, (ViewGroup) null);
                this.p = viewGroup;
                EMTextView eMTextView = (EMTextView) viewGroup.findViewById(R.id.ueg_new_delete_thread_title_view);
                this.s = eMTextView;
                if (this.H) {
                    eMTextView.setText(R.string.shield_reason);
                } else {
                    eMTextView.setText(R.string.delete_reason);
                }
                b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.s);
                d2.A(R.string.F_X02);
                d2.v(R.color.CAM_X0105);
                EMTextView eMTextView2 = (EMTextView) this.p.findViewById(R.id.ueg_new_delete_thread_describe_view);
                this.t = eMTextView2;
                b.a.q0.s.u.c.d(eMTextView2).z(R.dimen.T_X08);
                EMTextView eMTextView3 = (EMTextView) this.p.findViewById(R.id.ueg_new_delete_thread_cancel_view);
                this.q = eMTextView3;
                eMTextView3.setOnClickListener(new d(this));
                EMTextView eMTextView4 = (EMTextView) this.p.findViewById(R.id.ueg_new_delete_thread_certain_view);
                this.r = eMTextView4;
                if (this.H) {
                    eMTextView4.setText(R.string.shield);
                } else {
                    eMTextView4.setText(R.string.delete);
                }
                this.r.setOnClickListener(new e(this));
            }
            this.v = (LinearLayout) this.p.findViewById(R.id.ueg_new_delete_thread_reason_view_container);
            View g2 = this.l.g();
            if (g2 != null && g2.getParent() == null) {
                int g3 = l.g(this.f18275a, R.dimen.M_W_X009);
                g2.setPadding(g3, 0, g3, 0);
                this.v.addView(g2);
            }
            EMTextView eMTextView5 = (EMTextView) this.p.findViewById(R.id.ueg_new_delete_thread_tip_view);
            this.u = eMTextView5;
            eMTextView5.setHighlightColor(SelectorHelper.getResources().getColor(17170445));
            if (this.E) {
                this.u.setVisibility(0);
                if (1 == this.F) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) this.f18275a.getString(R.string.set_forum_rule_tip_manager));
                    f fVar = new f(this);
                    this.G = fVar;
                    spannableStringBuilder.setSpan(fVar, 13, 17, 18);
                    this.u.setText(spannableStringBuilder);
                    this.u.setMovementMethod(LinkMovementMethod.getInstance());
                } else {
                    this.u.setText(this.f18275a.getString(R.string.set_forum_rule_tip_assist));
                }
            } else {
                this.u.setVisibility(8);
            }
            this.u.setClickable(false);
            this.u.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.pic_popup_guide));
            t();
            return this.p;
        }
        return (View) invokeV.objValue;
    }

    public final int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            ViewGroup viewGroup = this.p;
            if (viewGroup == null) {
                return 0;
            }
            viewGroup.measure(0, 0);
            int measuredHeight = this.p.getMeasuredHeight();
            this.f18282h = measuredHeight;
            return measuredHeight;
        }
        return invokeV.intValue;
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.n = l.g(this.f18275a, R.dimen.M_W_X009);
            this.f18281g = l.k(this.f18275a) - (this.n * 2);
            b.a.r0.j.b bVar = new b.a.r0.j.b(this.f18276b);
            this.l = bVar;
            bVar.o(this.I);
            this.l.n(true);
            if (this.E) {
                this.l.l(5);
            }
        }
    }
}

package c.a.p0;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.f0.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.tieba.R;
import com.baidu.tieba.attention.AttentionView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class q implements c.a.p0.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f17070b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f17071c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f17072d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f17073e;

    /* renamed from: f  reason: collision with root package name */
    public EMTextView f17074f;

    /* renamed from: g  reason: collision with root package name */
    public AttentionView f17075g;

    /* renamed from: h  reason: collision with root package name */
    public h f17076h;
    @Nullable
    public f i;
    public final ArrayList<SelectForumData> j;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q a;

        public a(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.i == null) {
                return;
            }
            this.a.i.a(this.a.j);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q a;

        public b(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f17075g == null || this.a.a == null) {
                return;
            }
            this.a.i();
            new ForumSquareActivityConfig(this.a.a.getPageActivity()).start();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements AttentionView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q a;

        public c(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qVar;
        }

        @Override // com.baidu.tieba.attention.AttentionView.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.r();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q a;

        public d(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qVar;
        }

        @Override // c.a.p0.q.e
        public void a(SelectForumData selectForumData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, selectForumData) == null) || selectForumData == null) {
                return;
            }
            if (this.a.j.size() == 2 && !selectForumData.isInterestForumSelected) {
                c.a.d.f.p.n.N(this.a.a.getPageActivity(), this.a.a.getString(R.string.obfuscated_res_0x7f0f0096));
                return;
            }
            boolean z = !selectForumData.isInterestForumSelected;
            selectForumData.isInterestForumSelected = z;
            if (z) {
                this.a.j.add(selectForumData);
            } else {
                this.a.p(selectForumData);
            }
            if (this.a.f17075g != null) {
                this.a.f17075g.t(selectForumData.index);
            }
            this.a.o();
        }
    }

    /* loaded from: classes2.dex */
    public interface e {
        void a(SelectForumData selectForumData);
    }

    /* loaded from: classes2.dex */
    public interface f {
        void a(ArrayList<SelectForumData> arrayList);
    }

    public q(@NonNull TbPageContext tbPageContext, @NonNull LinearLayout linearLayout, @NonNull NavigationBar navigationBar, @NonNull f fVar, @Nullable ArrayList<SelectForumData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, linearLayout, navigationBar, fVar, arrayList};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ArrayList<SelectForumData> arrayList2 = new ArrayList<>();
        this.j = arrayList2;
        this.a = tbPageContext;
        this.f17070b = linearLayout;
        this.f17071c = navigationBar;
        this.i = fVar;
        if (arrayList != null) {
            arrayList2.addAll(arrayList);
        }
        n();
        m();
    }

    @Override // c.a.o0.x0.b
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14494");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // c.a.o0.x0.b
    public boolean isOnViewCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.o0.x0.b
    public boolean isOnViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final e j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new d(this) : (e) invokeV.objValue;
    }

    public final AttentionView.d k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new c(this) : (AttentionView.d) invokeV.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            EMTextView eMTextView = this.f17074f;
            if (eMTextView != null) {
                eMTextView.setVisibility(0);
            }
            AttentionView attentionView = this.f17075g;
            if (attentionView != null) {
                attentionView.setVisibility(0);
            }
            h hVar = this.f17076h;
            if (hVar == null || !hVar.isViewAttached()) {
                return;
            }
            this.f17076h.dettachView(this.f17072d);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d04ea, (ViewGroup) this.f17070b, true);
            this.f17072d = (RelativeLayout) this.f17070b.findViewById(R.id.obfuscated_res_0x7f091c79);
            this.f17074f = (EMTextView) this.f17070b.findViewById(R.id.obfuscated_res_0x7f091c7a);
            AttentionView attentionView = (AttentionView) this.f17070b.findViewById(R.id.obfuscated_res_0x7f091c78);
            this.f17075g = attentionView;
            if (attentionView != null) {
                attentionView.setForumSelectStateChangedListener(j());
                this.f17075g.setResultEmptyListener(k());
                this.f17075g.o(this.j);
                this.f17075g.c(null);
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f17071c.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0098));
            TextView addTextButton = this.f17071c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.a.getString(R.string.obfuscated_res_0x7f0f0097));
            this.f17073e = addTextButton;
            if (addTextButton != null) {
                addTextButton.setOnClickListener(new a(this));
            }
            o();
        }
    }

    public final void o() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (textView = this.f17073e) == null) {
            return;
        }
        textView.setEnabled(!this.j.isEmpty());
    }

    @Override // c.a.p0.f
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            AttentionView attentionView = this.f17075g;
            if (attentionView != null) {
                attentionView.onDestroy();
            }
            this.i = null;
        }
    }

    @Override // c.a.p0.f
    public void onResume() {
        h hVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (hVar = this.f17076h) != null && hVar.isViewAttached()) {
            l();
            AttentionView attentionView = this.f17075g;
            if (attentionView != null) {
                attentionView.c(null);
            }
        }
    }

    @Override // c.a.o0.x0.b
    public void onViewChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            EMTextView eMTextView = this.f17074f;
            if (eMTextView != null) {
                SkinManager.setViewTextColor(eMTextView, (int) R.color.CAM_X0108);
            }
            TextView textView = this.f17073e;
            if (textView != null) {
                textView.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(R.color.CAM_X0302, i));
            }
            AttentionView attentionView = this.f17075g;
            if (attentionView != null) {
                attentionView.a();
            }
            h hVar = this.f17076h;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
        }
    }

    public final void p(SelectForumData selectForumData) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, selectForumData) == null) || selectForumData == null) {
            return;
        }
        Iterator<SelectForumData> it = this.j.iterator();
        while (it.hasNext()) {
            SelectForumData next = it.next();
            if (next != null && (str = next.forumId) != null && str.equals(selectForumData.forumId)) {
                it.remove();
                return;
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14493");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.a == null || this.f17072d == null) {
            return;
        }
        h hVar = this.f17076h;
        if (hVar == null || !hVar.isViewAttached()) {
            h hVar2 = new h(this.a.getPageActivity(), new b(this));
            this.f17076h = hVar2;
            hVar2.j(true);
            this.f17076h.m(this.a.getString(R.string.obfuscated_res_0x7f0f0093));
            this.f17076h.o(this.a.getString(R.string.obfuscated_res_0x7f0f0094));
            this.f17076h.g(this.a.getString(R.string.obfuscated_res_0x7f0f0092));
            this.f17076h.i(R.drawable.new_pic_emotion_07);
            this.f17076h.p();
            this.f17076h.attachView(this.f17072d);
            EMTextView eMTextView = this.f17074f;
            if (eMTextView != null) {
                eMTextView.setVisibility(8);
            }
            AttentionView attentionView = this.f17075g;
            if (attentionView != null) {
                attentionView.setVisibility(8);
            }
            q();
        }
    }
}

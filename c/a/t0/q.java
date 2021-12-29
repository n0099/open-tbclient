package c.a.t0;

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
import c.a.s0.g0.h;
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
/* loaded from: classes8.dex */
public class q implements c.a.t0.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f22018e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f22019f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBar f22020g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f22021h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f22022i;

    /* renamed from: j  reason: collision with root package name */
    public EMTextView f22023j;

    /* renamed from: k  reason: collision with root package name */
    public AttentionView f22024k;
    public h l;
    @Nullable
    public f m;
    public final ArrayList<SelectForumData> n;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q f22025e;

        public a(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22025e = qVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f22025e.m == null) {
                return;
            }
            this.f22025e.m.a(this.f22025e.n);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q f22026e;

        public b(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22026e = qVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f22026e.f22024k == null || this.f22026e.f22018e == null) {
                return;
            }
            this.f22026e.j();
            new ForumSquareActivityConfig(this.f22026e.f22018e.getPageActivity()).start();
        }
    }

    /* loaded from: classes8.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                this.a.s();
            }
        }
    }

    /* loaded from: classes8.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qVar;
        }

        @Override // c.a.t0.q.e
        public void a(SelectForumData selectForumData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, selectForumData) == null) || selectForumData == null) {
                return;
            }
            if (this.a.n.size() == 2 && !selectForumData.isInterestForumSelected) {
                c.a.d.f.p.n.M(this.a.f22018e.getPageActivity(), this.a.f22018e.getString(R.string.activity_select_interest_forum_limit));
                return;
            }
            boolean z = !selectForumData.isInterestForumSelected;
            selectForumData.isInterestForumSelected = z;
            if (z) {
                this.a.n.add(selectForumData);
            } else {
                this.a.q(selectForumData);
            }
            if (this.a.f22024k != null) {
                this.a.f22024k.notifyItemChanged(selectForumData.index);
            }
            this.a.p();
        }
    }

    /* loaded from: classes8.dex */
    public interface e {
        void a(SelectForumData selectForumData);
    }

    /* loaded from: classes8.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ArrayList<SelectForumData> arrayList2 = new ArrayList<>();
        this.n = arrayList2;
        this.f22018e = tbPageContext;
        this.f22019f = linearLayout;
        this.f22020g = navigationBar;
        this.m = fVar;
        if (arrayList != null) {
            arrayList2.addAll(arrayList);
        }
        o();
        n();
    }

    @Override // c.a.s0.y0.b
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    @Override // c.a.s0.y0.b
    public boolean isOnViewCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.s0.y0.b
    public boolean isOnViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14494");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public final e k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new d(this) : (e) invokeV.objValue;
    }

    public final AttentionView.d l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new c(this) : (AttentionView.d) invokeV.objValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            EMTextView eMTextView = this.f22023j;
            if (eMTextView != null) {
                eMTextView.setVisibility(0);
            }
            AttentionView attentionView = this.f22024k;
            if (attentionView != null) {
                attentionView.setVisibility(0);
            }
            h hVar = this.l;
            if (hVar == null || !hVar.isViewAttached()) {
                return;
            }
            this.l.dettachView(this.f22021h);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            LayoutInflater.from(this.f22018e.getPageActivity()).inflate(R.layout.layout_select_interest_forum, (ViewGroup) this.f22019f, true);
            this.f22021h = (RelativeLayout) this.f22019f.findViewById(R.id.select_interest_forum_root);
            this.f22023j = (EMTextView) this.f22019f.findViewById(R.id.select_interest_forum_title_hint);
            AttentionView attentionView = (AttentionView) this.f22019f.findViewById(R.id.select_interest_forum_attention_page);
            this.f22024k = attentionView;
            if (attentionView != null) {
                attentionView.setForumSelectStateChangedListener(k());
                this.f22024k.setResultEmptyListener(l());
                this.f22024k.initSelectedForums(this.n);
                this.f22024k.request((String) null);
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f22020g.setCenterTextTitle(this.f22018e.getString(R.string.activity_select_interest_forum_title));
            TextView addTextButton = this.f22020g.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f22018e.getString(R.string.activity_select_interest_forum_save));
            this.f22022i = addTextButton;
            if (addTextButton != null) {
                addTextButton.setOnClickListener(new a(this));
            }
            p();
        }
    }

    @Override // c.a.t0.f
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            AttentionView attentionView = this.f22024k;
            if (attentionView != null) {
                attentionView.onDestroy();
            }
            this.m = null;
        }
    }

    @Override // c.a.t0.f
    public void onResume() {
        h hVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (hVar = this.l) != null && hVar.isViewAttached()) {
            m();
            AttentionView attentionView = this.f22024k;
            if (attentionView != null) {
                attentionView.request((String) null);
            }
        }
    }

    @Override // c.a.s0.y0.b
    public void onViewChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            EMTextView eMTextView = this.f22023j;
            if (eMTextView != null) {
                SkinManager.setViewTextColor(eMTextView, R.color.CAM_X0108);
            }
            TextView textView = this.f22022i;
            if (textView != null) {
                textView.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(R.color.CAM_X0302, i2));
            }
            AttentionView attentionView = this.f22024k;
            if (attentionView != null) {
                attentionView.onChangeSkinType();
            }
            h hVar = this.l;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
        }
    }

    public final void p() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (textView = this.f22022i) == null) {
            return;
        }
        textView.setEnabled(!this.n.isEmpty());
    }

    public final void q(SelectForumData selectForumData) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, selectForumData) == null) || selectForumData == null) {
            return;
        }
        Iterator<SelectForumData> it = this.n.iterator();
        while (it.hasNext()) {
            SelectForumData next = it.next();
            if (next != null && (str = next.forumId) != null && str.equals(selectForumData.forumId)) {
                it.remove();
                return;
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14493");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.f22018e == null || this.f22021h == null) {
            return;
        }
        h hVar = this.l;
        if (hVar == null || !hVar.isViewAttached()) {
            h hVar2 = new h(this.f22018e.getPageActivity(), new b(this));
            this.l = hVar2;
            hVar2.j(true);
            this.l.m(this.f22018e.getString(R.string.activity_select_interest_forum_empty_forum_subtitle));
            this.l.o(this.f22018e.getString(R.string.activity_select_interest_forum_empty_forum_title));
            this.l.g(this.f22018e.getString(R.string.activity_select_interest_forum_empty_btn));
            this.l.i(R.drawable.new_pic_emotion_07);
            this.l.p();
            this.l.attachView(this.f22021h);
            EMTextView eMTextView = this.f22023j;
            if (eMTextView != null) {
                eMTextView.setVisibility(8);
            }
            AttentionView attentionView = this.f22024k;
            if (attentionView != null) {
                attentionView.setVisibility(8);
            }
            r();
        }
    }
}

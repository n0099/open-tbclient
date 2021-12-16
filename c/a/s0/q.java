package c.a.s0;

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
import c.a.r0.g0.h;
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
public class q implements c.a.s0.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f21503e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f21504f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBar f21505g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f21506h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f21507i;

    /* renamed from: j  reason: collision with root package name */
    public EMTextView f21508j;

    /* renamed from: k  reason: collision with root package name */
    public AttentionView f21509k;
    public h l;
    @Nullable
    public f m;
    public final ArrayList<SelectForumData> n;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q f21510e;

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
            this.f21510e = qVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f21510e.m == null) {
                return;
            }
            this.f21510e.m.a(this.f21510e.n);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q f21511e;

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
            this.f21511e = qVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f21511e.f21509k == null || this.f21511e.f21503e == null) {
                return;
            }
            this.f21511e.i();
            new ForumSquareActivityConfig(this.f21511e.f21503e.getPageActivity()).start();
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
                this.a.r();
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

        @Override // c.a.s0.q.e
        public void a(SelectForumData selectForumData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, selectForumData) == null) || selectForumData == null) {
                return;
            }
            if (this.a.n.size() == 2 && !selectForumData.isInterestForumSelected) {
                c.a.d.f.p.m.M(this.a.f21503e.getPageActivity(), this.a.f21503e.getString(R.string.activity_select_interest_forum_limit));
                return;
            }
            boolean z = !selectForumData.isInterestForumSelected;
            selectForumData.isInterestForumSelected = z;
            if (z) {
                this.a.n.add(selectForumData);
            } else {
                this.a.p(selectForumData);
            }
            if (this.a.f21509k != null) {
                this.a.f21509k.notifyItemChanged(selectForumData.index);
            }
            this.a.o();
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
        this.f21503e = tbPageContext;
        this.f21504f = linearLayout;
        this.f21505g = navigationBar;
        this.m = fVar;
        if (arrayList != null) {
            arrayList2.addAll(arrayList);
        }
        n();
        m();
    }

    @Override // c.a.r0.x0.a
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

    @Override // c.a.r0.x0.a
    public boolean isOnViewCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.x0.a
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
            EMTextView eMTextView = this.f21508j;
            if (eMTextView != null) {
                eMTextView.setVisibility(0);
            }
            AttentionView attentionView = this.f21509k;
            if (attentionView != null) {
                attentionView.setVisibility(0);
            }
            h hVar = this.l;
            if (hVar == null || !hVar.isViewAttached()) {
                return;
            }
            this.l.dettachView(this.f21506h);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            LayoutInflater.from(this.f21503e.getPageActivity()).inflate(R.layout.layout_select_interest_forum, (ViewGroup) this.f21504f, true);
            this.f21506h = (RelativeLayout) this.f21504f.findViewById(R.id.select_interest_forum_root);
            this.f21508j = (EMTextView) this.f21504f.findViewById(R.id.select_interest_forum_title_hint);
            AttentionView attentionView = (AttentionView) this.f21504f.findViewById(R.id.select_interest_forum_attention_page);
            this.f21509k = attentionView;
            if (attentionView != null) {
                attentionView.setForumSelectStateChangedListener(j());
                this.f21509k.setResultEmptyListener(k());
                this.f21509k.initSelectedForums(this.n);
                this.f21509k.request((String) null);
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f21505g.setCenterTextTitle(this.f21503e.getString(R.string.activity_select_interest_forum_title));
            TextView addTextButton = this.f21505g.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f21503e.getString(R.string.activity_select_interest_forum_save));
            this.f21507i = addTextButton;
            if (addTextButton != null) {
                addTextButton.setOnClickListener(new a(this));
            }
            o();
        }
    }

    public final void o() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (textView = this.f21507i) == null) {
            return;
        }
        textView.setEnabled(!this.n.isEmpty());
    }

    @Override // c.a.s0.f
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            AttentionView attentionView = this.f21509k;
            if (attentionView != null) {
                attentionView.onDestroy();
            }
            this.m = null;
        }
    }

    @Override // c.a.s0.f
    public void onResume() {
        h hVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (hVar = this.l) != null && hVar.isViewAttached()) {
            l();
            AttentionView attentionView = this.f21509k;
            if (attentionView != null) {
                attentionView.request((String) null);
            }
        }
    }

    @Override // c.a.r0.x0.a
    public void onViewChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            EMTextView eMTextView = this.f21508j;
            if (eMTextView != null) {
                SkinManager.setViewTextColor(eMTextView, R.color.CAM_X0108);
            }
            TextView textView = this.f21507i;
            if (textView != null) {
                textView.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(R.color.CAM_X0302, i2));
            }
            AttentionView attentionView = this.f21509k;
            if (attentionView != null) {
                attentionView.onChangeSkinType();
            }
            h hVar = this.l;
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
        Iterator<SelectForumData> it = this.n.iterator();
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
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.f21503e == null || this.f21506h == null) {
            return;
        }
        h hVar = this.l;
        if (hVar == null || !hVar.isViewAttached()) {
            h hVar2 = new h(this.f21503e.getPageActivity(), new b(this));
            this.l = hVar2;
            hVar2.j(true);
            this.l.m(this.f21503e.getString(R.string.activity_select_interest_forum_empty_forum_subtitle));
            this.l.o(this.f21503e.getString(R.string.activity_select_interest_forum_empty_forum_title));
            this.l.g(this.f21503e.getString(R.string.activity_select_interest_forum_empty_btn));
            this.l.i(R.drawable.new_pic_emotion_07);
            this.l.p();
            this.l.attachView(this.f21506h);
            EMTextView eMTextView = this.f21508j;
            if (eMTextView != null) {
                eMTextView.setVisibility(8);
            }
            AttentionView attentionView = this.f21509k;
            if (attentionView != null) {
                attentionView.setVisibility(8);
            }
            q();
        }
    }
}

package c.a.r0;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
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
/* loaded from: classes6.dex */
public class q implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f21359e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f21360f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBar f21361g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f21362h;

    /* renamed from: i  reason: collision with root package name */
    public EMTextView f21363i;

    /* renamed from: j  reason: collision with root package name */
    public AttentionView f21364j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    public d f21365k;
    public final ArrayList<SelectForumData> l;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q f21366e;

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
            this.f21366e = qVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f21366e.f21365k == null) {
                return;
            }
            this.f21366e.f21365k.a(this.f21366e.l);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements c {
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

        @Override // c.a.r0.q.c
        public void a(SelectForumData selectForumData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, selectForumData) == null) || selectForumData == null) {
                return;
            }
            if (this.a.l.size() == 2 && !selectForumData.isInterestForumSelected) {
                l.M(this.a.f21359e.getPageActivity(), this.a.f21359e.getString(R.string.activity_select_interest_forum_limit));
                return;
            }
            boolean z = !selectForumData.isInterestForumSelected;
            selectForumData.isInterestForumSelected = z;
            if (z) {
                this.a.l.add(selectForumData);
            } else {
                this.a.k(selectForumData);
            }
            if (this.a.f21364j != null) {
                this.a.f21364j.notifyItemChanged(selectForumData.index);
            }
            this.a.j();
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(SelectForumData selectForumData);
    }

    /* loaded from: classes6.dex */
    public interface d {
        void a(ArrayList<SelectForumData> arrayList);
    }

    public q(@NonNull TbPageContext tbPageContext, @NonNull LinearLayout linearLayout, @NonNull NavigationBar navigationBar, @NonNull d dVar, @Nullable ArrayList<SelectForumData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, linearLayout, navigationBar, dVar, arrayList};
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
        this.l = arrayList2;
        this.f21359e = tbPageContext;
        this.f21360f = linearLayout;
        this.f21361g = navigationBar;
        this.f21365k = dVar;
        if (arrayList != null) {
            arrayList2.addAll(arrayList);
        }
        i();
        h();
    }

    public final c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new b(this) : (c) invokeV.objValue;
    }

    @Override // c.a.q0.x0.a
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LayoutInflater.from(this.f21359e.getPageActivity()).inflate(R.layout.layout_select_interest_forum, (ViewGroup) this.f21360f, true);
            this.f21363i = (EMTextView) this.f21360f.findViewById(R.id.select_interest_forum_title_hint);
            AttentionView attentionView = (AttentionView) this.f21360f.findViewById(R.id.select_interest_forum_attention_page);
            this.f21364j = attentionView;
            if (attentionView != null) {
                attentionView.setForumSelectStateChangedListener(g());
                this.f21364j.initSelectedForums(this.l);
                this.f21364j.request((String) null);
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f21361g.setCenterTextTitle(this.f21359e.getString(R.string.activity_select_interest_forum_title));
            TextView addTextButton = this.f21361g.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f21359e.getString(R.string.activity_select_interest_forum_save));
            this.f21362h = addTextButton;
            if (addTextButton != null) {
                addTextButton.setOnClickListener(new a(this));
            }
            j();
        }
    }

    @Override // c.a.q0.x0.a
    public boolean isOnViewCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.q0.x0.a
    public boolean isOnViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void j() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (textView = this.f21362h) == null) {
            return;
        }
        textView.setEnabled(!this.l.isEmpty());
    }

    public final void k(SelectForumData selectForumData) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, selectForumData) == null) || selectForumData == null) {
            return;
        }
        Iterator<SelectForumData> it = this.l.iterator();
        while (it.hasNext()) {
            SelectForumData next = it.next();
            if (next != null && (str = next.forumId) != null && str.equals(selectForumData.forumId)) {
                it.remove();
                return;
            }
        }
    }

    @Override // c.a.r0.f
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            AttentionView attentionView = this.f21364j;
            if (attentionView != null) {
                attentionView.onDestroy();
            }
            this.f21365k = null;
        }
    }

    @Override // c.a.q0.x0.a
    public void onViewChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            EMTextView eMTextView = this.f21363i;
            if (eMTextView != null) {
                SkinManager.setViewTextColor(eMTextView, R.color.CAM_X0108);
            }
            TextView textView = this.f21362h;
            if (textView != null) {
                textView.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(R.color.CAM_X0302, i2));
            }
            AttentionView attentionView = this.f21364j;
            if (attentionView != null) {
                attentionView.onChangeSkinType();
            }
        }
    }
}

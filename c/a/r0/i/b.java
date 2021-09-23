package c.a.r0.i;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.q0.s.q.x0;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackReasonCheckBox;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f19035a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f19036b;

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<String> f19037c;

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<String> f19038d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f19039e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f19040f;

    /* renamed from: g  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f19041g;

    /* renamed from: h  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f19042h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<NEGFeedBackReasonCheckBox, Boolean> f19043i;

    /* renamed from: j  reason: collision with root package name */
    public int f19044j;
    public boolean k;
    public boolean l;
    public int m;

    /* loaded from: classes3.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f19045e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19045e = bVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Map.Entry entry;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) || compoundButton == null || this.f19045e.f19043i == null || this.f19045e.f19043i.isEmpty()) {
                return;
            }
            boolean z2 = false;
            if (z && this.f19045e.k) {
                for (Map.Entry entry2 : this.f19045e.f19043i.entrySet()) {
                    if (entry2 != null) {
                        if (entry2.getKey() == compoundButton) {
                            ((NEGFeedBackReasonCheckBox) entry2.getKey()).setChecked(true);
                            entry2.setValue(Boolean.TRUE);
                        } else {
                            ((NEGFeedBackReasonCheckBox) entry2.getKey()).setChecked(false);
                            entry2.setValue(Boolean.FALSE);
                        }
                    }
                }
            }
            if (this.f19045e.k && !z && !this.f19045e.l) {
                Iterator it = this.f19045e.f19043i.entrySet().iterator();
                while (it.hasNext() && ((entry = (Map.Entry) it.next()) == null || entry.getKey() == null || !(z2 = ((NEGFeedBackReasonCheckBox) entry.getKey()).isChecked()))) {
                }
                if (!z2) {
                    for (Map.Entry entry3 : this.f19045e.f19043i.entrySet()) {
                        if (entry3 != null && entry3.getKey() == compoundButton) {
                            ((NEGFeedBackReasonCheckBox) entry3.getKey()).setChecked(true);
                            entry3.setValue(Boolean.TRUE);
                            return;
                        }
                    }
                }
            }
            if (this.f19045e.f19041g != null) {
                this.f19045e.f19041g.onCheckedChanged(compoundButton, z);
            }
        }
    }

    /* renamed from: c.a.r0.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0920b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f19046a;

        /* renamed from: b  reason: collision with root package name */
        public int f19047b;

        /* renamed from: c  reason: collision with root package name */
        public String f19048c;

        /* renamed from: d  reason: collision with root package name */
        public String f19049d;

        public C0920b(b bVar, int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2), Integer.valueOf(i3), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19047b = i3;
            if (str != null && str.contains("%")) {
                String[] split = str.split("%");
                this.f19048c = split[0];
                if (split.length > 1) {
                    this.f19049d = split[1];
                }
            } else {
                this.f19048c = str;
            }
            this.f19046a = i2;
        }
    }

    public b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19035a = false;
        this.f19037c = null;
        this.f19038d = null;
        this.k = false;
        this.l = true;
        this.m = -1;
        this.f19036b = tbPageContext;
        this.f19044j = l.g(tbPageContext.getPageActivity(), R.dimen.M_H_X003);
        this.f19042h = new a(this);
    }

    public final View e(List<C0920b> list, boolean z, View view) {
        InterceptResult invokeCommon;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{list, Boolean.valueOf(z), view})) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            if (view instanceof LinearLayout) {
                linearLayout = (LinearLayout) view;
            } else {
                linearLayout = (LinearLayout) LayoutInflater.from(this.f19036b.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.f19040f, false);
            }
            NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
            NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
            nEGFeedBackReasonCheckBox.changeSkinType();
            nEGFeedBackReasonCheckBox2.changeSkinType();
            nEGFeedBackReasonCheckBox.setChecked(false);
            nEGFeedBackReasonCheckBox2.setChecked(false);
            this.f19043i.put(nEGFeedBackReasonCheckBox, Boolean.FALSE);
            this.f19043i.put(nEGFeedBackReasonCheckBox2, Boolean.FALSE);
            C0920b c0920b = list.get(0);
            if (c0920b != null) {
                nEGFeedBackReasonCheckBox.setText(c0920b.f19048c);
                nEGFeedBackReasonCheckBox.setTag(c0920b);
                if (c0920b.f19046a == this.m) {
                    nEGFeedBackReasonCheckBox.setEnabled(false);
                }
            }
            if (list.size() > 1 && list.get(1) != null) {
                C0920b c0920b2 = list.get(1);
                nEGFeedBackReasonCheckBox2.setText(c0920b2.f19048c);
                nEGFeedBackReasonCheckBox2.setVisibility(0);
                nEGFeedBackReasonCheckBox2.setTag(c0920b2);
                if (c0920b2.f19046a == this.m) {
                    nEGFeedBackReasonCheckBox2.setEnabled(false);
                }
            } else {
                nEGFeedBackReasonCheckBox2.setVisibility(4);
            }
            nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.f19042h);
            nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.f19042h);
            int i2 = z ? 0 : this.f19044j;
            if (linearLayout.getLayoutParams() != null) {
                ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i2;
            }
            return linearLayout;
        }
        return (View) invokeCommon.objValue;
    }

    public final View f(List<C0920b> list, boolean z, View view) {
        InterceptResult invokeCommon;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{list, Boolean.valueOf(z), view})) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            if (view instanceof LinearLayout) {
                linearLayout = (LinearLayout) view;
            } else {
                linearLayout = (LinearLayout) LayoutInflater.from(this.f19036b.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.f19040f, false);
            }
            NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
            NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
            nEGFeedBackReasonCheckBox.changeSkinType();
            nEGFeedBackReasonCheckBox2.changeSkinType();
            nEGFeedBackReasonCheckBox.setChecked(false);
            nEGFeedBackReasonCheckBox2.setChecked(false);
            this.f19043i.put(nEGFeedBackReasonCheckBox, Boolean.FALSE);
            this.f19043i.put(nEGFeedBackReasonCheckBox2, Boolean.FALSE);
            C0920b c0920b = list.get(0);
            if (c0920b != null) {
                nEGFeedBackReasonCheckBox.setText(c0920b.f19048c);
                nEGFeedBackReasonCheckBox.setTag(c0920b);
            }
            if (list.size() > 1 && list.get(1) != null) {
                C0920b c0920b2 = list.get(1);
                nEGFeedBackReasonCheckBox2.setText(c0920b2.f19048c);
                nEGFeedBackReasonCheckBox2.setVisibility(0);
                nEGFeedBackReasonCheckBox2.setTag(c0920b2);
            } else {
                nEGFeedBackReasonCheckBox2.setVisibility(8);
            }
            nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.f19042h);
            nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.f19042h);
            int i2 = z ? 0 : this.f19044j;
            if (linearLayout.getLayoutParams() != null) {
                ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i2;
            }
            return linearLayout;
        }
        return (View) invokeCommon.objValue;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f19040f == null) {
                LinearLayout linearLayout = new LinearLayout(this.f19036b.getPageActivity());
                this.f19040f = linearLayout;
                linearLayout.setOrientation(1);
            }
            List<List<C0920b>> p = p();
            if (ListUtils.isEmpty(p)) {
                return null;
            }
            int size = p.size();
            HashMap<NEGFeedBackReasonCheckBox, Boolean> hashMap = this.f19043i;
            if (hashMap == null) {
                this.f19043i = new HashMap<>();
            } else {
                hashMap.clear();
            }
            int i2 = 0;
            while (i2 < size) {
                View e2 = e(p.get(i2), i2 == size + (-1), this.f19040f.getChildAt(i2));
                if (e2 != null && e2.getParent() == null) {
                    this.f19040f.addView(e2);
                }
                i2++;
            }
            if (this.f19040f.getChildCount() > size) {
                LinearLayout linearLayout2 = this.f19040f;
                linearLayout2.removeViews(size, linearLayout2.getChildCount() - size);
            }
            return this.f19040f;
        }
        return (View) invokeV.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f19040f == null) {
                LinearLayout linearLayout = new LinearLayout(this.f19036b.getPageActivity());
                this.f19040f = linearLayout;
                linearLayout.setOrientation(1);
            }
            List<List<C0920b>> s = s();
            if (ListUtils.isEmpty(s)) {
                return null;
            }
            int size = s.size();
            HashMap<NEGFeedBackReasonCheckBox, Boolean> hashMap = this.f19043i;
            if (hashMap == null) {
                this.f19043i = new HashMap<>();
            } else {
                hashMap.clear();
            }
            int i2 = 0;
            while (i2 < size) {
                View f2 = f(s.get(i2), i2 == size + (-1), this.f19040f.getChildAt(i2));
                if (f2 != null && f2.getParent() == null) {
                    this.f19040f.addView(f2);
                }
                i2++;
            }
            if (this.f19040f.getChildCount() > size) {
                LinearLayout linearLayout2 = this.f19040f;
                linearLayout2.removeViews(size, linearLayout2.getChildCount() - size);
            }
            return this.f19040f;
        }
        return (View) invokeV.objValue;
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.l = z;
        }
    }

    public void j(x0 x0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, x0Var) == null) || x0Var == null) {
            return;
        }
        this.f19037c = x0Var.b();
        this.f19038d = x0Var.f14351g;
    }

    public void k(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, strArr) == null) {
            this.f19039e = strArr;
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.m = i2;
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f19035a = z;
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.k = z;
        }
    }

    public void o(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onCheckedChangeListener) == null) {
            this.f19041g = onCheckedChangeListener;
        }
    }

    public final List<List<C0920b>> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            SparseArray<String> sparseArray = this.f19037c;
            if (sparseArray != null && sparseArray.size() != 0) {
                int size = this.f19037c.size();
                ArrayList arrayList = new ArrayList();
                int i2 = 0;
                while (i2 < size) {
                    int i3 = i2 + 1;
                    int i4 = i2 + 2;
                    ArrayList arrayList2 = new ArrayList();
                    C0920b c0920b = new C0920b(this, i2, this.f19037c.keyAt(i2), this.f19037c.valueAt(i2));
                    SparseArray<String> sparseArray2 = this.f19038d;
                    if (sparseArray2 != null && !StringUtils.isNull(sparseArray2.get(this.f19037c.keyAt(i2)))) {
                        c0920b.f19049d = this.f19038d.get(this.f19037c.keyAt(i2));
                    }
                    arrayList2.add(c0920b);
                    if (i3 > i2 && i3 < size) {
                        C0920b c0920b2 = new C0920b(this, i3, this.f19037c.keyAt(i3), this.f19037c.valueAt(i3));
                        SparseArray<String> sparseArray3 = this.f19038d;
                        if (sparseArray3 != null && !StringUtils.isNull(sparseArray3.get(this.f19037c.keyAt(i2)))) {
                            c0920b2.f19049d = this.f19038d.get(this.f19037c.keyAt(i3));
                        }
                        arrayList2.add(c0920b2);
                    }
                    arrayList.add(arrayList2);
                    i2 = i4;
                }
                return arrayList;
            }
            return q();
        }
        return (List) invokeV.objValue;
    }

    public final List<List<C0920b>> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            String[] strArr = this.f19039e;
            if (strArr == null || strArr.length <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.f19039e.length; i2 += 2) {
                ArrayList arrayList2 = new ArrayList();
                if (!StringUtils.isNull(this.f19039e[i2])) {
                    arrayList2.add(new C0920b(this, i2, i2 + 1, this.f19039e[i2]));
                }
                int i3 = i2 + 1;
                String[] strArr2 = this.f19039e;
                if (i3 < strArr2.length && !StringUtils.isNull(strArr2[i3])) {
                    arrayList2.add(new C0920b(this, i3, i2 + 2, this.f19039e[i3]));
                }
                if (arrayList2.size() > 0) {
                    arrayList.add(arrayList2);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final List<List<C0920b>> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            String[] strArr = this.f19039e;
            if (strArr == null || strArr.length <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.f19039e.length; i2 += 2) {
                ArrayList arrayList2 = new ArrayList();
                if (!StringUtils.isNull(this.f19039e[i2])) {
                    arrayList2.add(new C0920b(this, i2, 0, this.f19039e[i2]));
                }
                int i3 = i2 + 1;
                String[] strArr2 = this.f19039e;
                if (i3 < strArr2.length && !StringUtils.isNull(strArr2[i3])) {
                    arrayList2.add(new C0920b(this, i3, 0, this.f19039e[i3]));
                }
                if (arrayList2.size() > 0) {
                    arrayList.add(arrayList2);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final List<List<C0920b>> s() {
        InterceptResult invokeV;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            SparseArray<String> sparseArray = this.f19037c;
            if (sparseArray != null && sparseArray.size() != 0) {
                int size = this.f19037c.size();
                int i4 = 0;
                int i5 = -1;
                int i6 = this.f19035a ? 0 : -1;
                int i7 = this.f19035a ? size - 1 : size;
                if (i7 > 1 && i7 % 2 == 1) {
                    i5 = i6 + 1;
                }
                ArrayList arrayList = new ArrayList();
                while (i4 < size) {
                    if (i4 == i6 || i4 == i5) {
                        i2 = i4 + 1;
                        i3 = i4;
                    } else {
                        i3 = i4 + 1;
                        i2 = i4 + 2;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    C0920b c0920b = new C0920b(this, i4, this.f19037c.keyAt(i4), this.f19037c.valueAt(i4));
                    SparseArray<String> sparseArray2 = this.f19038d;
                    if (sparseArray2 != null && !StringUtils.isNull(sparseArray2.get(this.f19037c.keyAt(i4)))) {
                        c0920b.f19049d = this.f19038d.get(this.f19037c.keyAt(i4));
                    }
                    arrayList2.add(c0920b);
                    if (i3 > i4 && i3 < size) {
                        C0920b c0920b2 = new C0920b(this, i3, this.f19037c.keyAt(i3), this.f19037c.valueAt(i3));
                        SparseArray<String> sparseArray3 = this.f19038d;
                        if (sparseArray3 != null && !StringUtils.isNull(sparseArray3.get(this.f19037c.keyAt(i4)))) {
                            c0920b2.f19049d = this.f19038d.get(this.f19037c.keyAt(i3));
                        }
                        arrayList2.add(c0920b2);
                    }
                    arrayList.add(arrayList2);
                    i4 = i2;
                }
                return arrayList;
            }
            return r();
        }
        return (List) invokeV.objValue;
    }
}

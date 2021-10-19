package c.a.r0.j;

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
    public boolean f19206a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f19207b;

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<String> f19208c;

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<String> f19209d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f19210e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f19211f;

    /* renamed from: g  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f19212g;

    /* renamed from: h  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f19213h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<NEGFeedBackReasonCheckBox, Boolean> f19214i;

    /* renamed from: j  reason: collision with root package name */
    public int f19215j;
    public boolean k;
    public boolean l;
    public int m;

    /* loaded from: classes3.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f19216e;

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
            this.f19216e = bVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Map.Entry entry;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) || compoundButton == null || this.f19216e.f19214i == null || this.f19216e.f19214i.isEmpty()) {
                return;
            }
            boolean z2 = false;
            if (z && this.f19216e.k) {
                for (Map.Entry entry2 : this.f19216e.f19214i.entrySet()) {
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
            if (this.f19216e.k && !z && !this.f19216e.l) {
                Iterator it = this.f19216e.f19214i.entrySet().iterator();
                while (it.hasNext() && ((entry = (Map.Entry) it.next()) == null || entry.getKey() == null || !(z2 = ((NEGFeedBackReasonCheckBox) entry.getKey()).isChecked()))) {
                }
                if (!z2) {
                    for (Map.Entry entry3 : this.f19216e.f19214i.entrySet()) {
                        if (entry3 != null && entry3.getKey() == compoundButton) {
                            ((NEGFeedBackReasonCheckBox) entry3.getKey()).setChecked(true);
                            entry3.setValue(Boolean.TRUE);
                            return;
                        }
                    }
                }
            }
            if (this.f19216e.f19212g != null) {
                this.f19216e.f19212g.onCheckedChanged(compoundButton, z);
            }
        }
    }

    /* renamed from: c.a.r0.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0929b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f19217a;

        /* renamed from: b  reason: collision with root package name */
        public int f19218b;

        /* renamed from: c  reason: collision with root package name */
        public String f19219c;

        /* renamed from: d  reason: collision with root package name */
        public String f19220d;

        public C0929b(b bVar, int i2, int i3, String str) {
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
            this.f19218b = i3;
            if (str != null && str.contains("%")) {
                String[] split = str.split("%");
                this.f19219c = split[0];
                if (split.length > 1) {
                    this.f19220d = split[1];
                }
            } else {
                this.f19219c = str;
            }
            this.f19217a = i2;
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
        this.f19206a = false;
        this.f19208c = null;
        this.f19209d = null;
        this.k = false;
        this.l = true;
        this.m = -1;
        this.f19207b = tbPageContext;
        this.f19215j = l.g(tbPageContext.getPageActivity(), R.dimen.M_H_X003);
        this.f19213h = new a(this);
    }

    public final View e(List<C0929b> list, boolean z, View view) {
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
                linearLayout = (LinearLayout) LayoutInflater.from(this.f19207b.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.f19211f, false);
            }
            NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
            NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
            nEGFeedBackReasonCheckBox.changeSkinType();
            nEGFeedBackReasonCheckBox2.changeSkinType();
            nEGFeedBackReasonCheckBox.setChecked(false);
            nEGFeedBackReasonCheckBox2.setChecked(false);
            this.f19214i.put(nEGFeedBackReasonCheckBox, Boolean.FALSE);
            this.f19214i.put(nEGFeedBackReasonCheckBox2, Boolean.FALSE);
            C0929b c0929b = list.get(0);
            if (c0929b != null) {
                nEGFeedBackReasonCheckBox.setText(c0929b.f19219c);
                nEGFeedBackReasonCheckBox.setTag(c0929b);
                if (c0929b.f19217a == this.m) {
                    nEGFeedBackReasonCheckBox.setEnabled(false);
                }
            }
            if (list.size() > 1 && list.get(1) != null) {
                C0929b c0929b2 = list.get(1);
                nEGFeedBackReasonCheckBox2.setText(c0929b2.f19219c);
                nEGFeedBackReasonCheckBox2.setVisibility(0);
                nEGFeedBackReasonCheckBox2.setTag(c0929b2);
                if (c0929b2.f19217a == this.m) {
                    nEGFeedBackReasonCheckBox2.setEnabled(false);
                }
            } else {
                nEGFeedBackReasonCheckBox2.setVisibility(4);
            }
            nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.f19213h);
            nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.f19213h);
            int i2 = z ? 0 : this.f19215j;
            if (linearLayout.getLayoutParams() != null) {
                ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i2;
            }
            return linearLayout;
        }
        return (View) invokeCommon.objValue;
    }

    public final View f(List<C0929b> list, boolean z, View view) {
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
                linearLayout = (LinearLayout) LayoutInflater.from(this.f19207b.getPageActivity()).inflate(R.layout.neg_feedback_reason_item, (ViewGroup) this.f19211f, false);
            }
            NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.left_reason);
            NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.right_reason);
            nEGFeedBackReasonCheckBox.changeSkinType();
            nEGFeedBackReasonCheckBox2.changeSkinType();
            nEGFeedBackReasonCheckBox.setChecked(false);
            nEGFeedBackReasonCheckBox2.setChecked(false);
            this.f19214i.put(nEGFeedBackReasonCheckBox, Boolean.FALSE);
            this.f19214i.put(nEGFeedBackReasonCheckBox2, Boolean.FALSE);
            C0929b c0929b = list.get(0);
            if (c0929b != null) {
                nEGFeedBackReasonCheckBox.setText(c0929b.f19219c);
                nEGFeedBackReasonCheckBox.setTag(c0929b);
            }
            if (list.size() > 1 && list.get(1) != null) {
                C0929b c0929b2 = list.get(1);
                nEGFeedBackReasonCheckBox2.setText(c0929b2.f19219c);
                nEGFeedBackReasonCheckBox2.setVisibility(0);
                nEGFeedBackReasonCheckBox2.setTag(c0929b2);
            } else {
                nEGFeedBackReasonCheckBox2.setVisibility(8);
            }
            nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.f19213h);
            nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.f19213h);
            int i2 = z ? 0 : this.f19215j;
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
            if (this.f19211f == null) {
                LinearLayout linearLayout = new LinearLayout(this.f19207b.getPageActivity());
                this.f19211f = linearLayout;
                linearLayout.setOrientation(1);
            }
            List<List<C0929b>> p = p();
            if (ListUtils.isEmpty(p)) {
                return null;
            }
            int size = p.size();
            HashMap<NEGFeedBackReasonCheckBox, Boolean> hashMap = this.f19214i;
            if (hashMap == null) {
                this.f19214i = new HashMap<>();
            } else {
                hashMap.clear();
            }
            int i2 = 0;
            while (i2 < size) {
                View e2 = e(p.get(i2), i2 == size + (-1), this.f19211f.getChildAt(i2));
                if (e2 != null && e2.getParent() == null) {
                    this.f19211f.addView(e2);
                }
                i2++;
            }
            if (this.f19211f.getChildCount() > size) {
                LinearLayout linearLayout2 = this.f19211f;
                linearLayout2.removeViews(size, linearLayout2.getChildCount() - size);
            }
            return this.f19211f;
        }
        return (View) invokeV.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f19211f == null) {
                LinearLayout linearLayout = new LinearLayout(this.f19207b.getPageActivity());
                this.f19211f = linearLayout;
                linearLayout.setOrientation(1);
            }
            List<List<C0929b>> s = s();
            if (ListUtils.isEmpty(s)) {
                return null;
            }
            int size = s.size();
            HashMap<NEGFeedBackReasonCheckBox, Boolean> hashMap = this.f19214i;
            if (hashMap == null) {
                this.f19214i = new HashMap<>();
            } else {
                hashMap.clear();
            }
            int i2 = 0;
            while (i2 < size) {
                View f2 = f(s.get(i2), i2 == size + (-1), this.f19211f.getChildAt(i2));
                if (f2 != null && f2.getParent() == null) {
                    this.f19211f.addView(f2);
                }
                i2++;
            }
            if (this.f19211f.getChildCount() > size) {
                LinearLayout linearLayout2 = this.f19211f;
                linearLayout2.removeViews(size, linearLayout2.getChildCount() - size);
            }
            return this.f19211f;
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
        this.f19208c = x0Var.b();
        this.f19209d = x0Var.f14371g;
    }

    public void k(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, strArr) == null) {
            this.f19210e = strArr;
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
            this.f19206a = z;
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
            this.f19212g = onCheckedChangeListener;
        }
    }

    public final List<List<C0929b>> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            SparseArray<String> sparseArray = this.f19208c;
            if (sparseArray != null && sparseArray.size() != 0) {
                int size = this.f19208c.size();
                ArrayList arrayList = new ArrayList();
                int i2 = 0;
                while (i2 < size) {
                    int i3 = i2 + 1;
                    int i4 = i2 + 2;
                    ArrayList arrayList2 = new ArrayList();
                    C0929b c0929b = new C0929b(this, i2, this.f19208c.keyAt(i2), this.f19208c.valueAt(i2));
                    SparseArray<String> sparseArray2 = this.f19209d;
                    if (sparseArray2 != null && !StringUtils.isNull(sparseArray2.get(this.f19208c.keyAt(i2)))) {
                        c0929b.f19220d = this.f19209d.get(this.f19208c.keyAt(i2));
                    }
                    arrayList2.add(c0929b);
                    if (i3 > i2 && i3 < size) {
                        C0929b c0929b2 = new C0929b(this, i3, this.f19208c.keyAt(i3), this.f19208c.valueAt(i3));
                        SparseArray<String> sparseArray3 = this.f19209d;
                        if (sparseArray3 != null && !StringUtils.isNull(sparseArray3.get(this.f19208c.keyAt(i2)))) {
                            c0929b2.f19220d = this.f19209d.get(this.f19208c.keyAt(i3));
                        }
                        arrayList2.add(c0929b2);
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

    public final List<List<C0929b>> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            String[] strArr = this.f19210e;
            if (strArr == null || strArr.length <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.f19210e.length; i2 += 2) {
                ArrayList arrayList2 = new ArrayList();
                if (!StringUtils.isNull(this.f19210e[i2])) {
                    arrayList2.add(new C0929b(this, i2, i2 + 1, this.f19210e[i2]));
                }
                int i3 = i2 + 1;
                String[] strArr2 = this.f19210e;
                if (i3 < strArr2.length && !StringUtils.isNull(strArr2[i3])) {
                    arrayList2.add(new C0929b(this, i3, i2 + 2, this.f19210e[i3]));
                }
                if (arrayList2.size() > 0) {
                    arrayList.add(arrayList2);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final List<List<C0929b>> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            String[] strArr = this.f19210e;
            if (strArr == null || strArr.length <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.f19210e.length; i2 += 2) {
                ArrayList arrayList2 = new ArrayList();
                if (!StringUtils.isNull(this.f19210e[i2])) {
                    arrayList2.add(new C0929b(this, i2, 0, this.f19210e[i2]));
                }
                int i3 = i2 + 1;
                String[] strArr2 = this.f19210e;
                if (i3 < strArr2.length && !StringUtils.isNull(strArr2[i3])) {
                    arrayList2.add(new C0929b(this, i3, 0, this.f19210e[i3]));
                }
                if (arrayList2.size() > 0) {
                    arrayList.add(arrayList2);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final List<List<C0929b>> s() {
        InterceptResult invokeV;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            SparseArray<String> sparseArray = this.f19208c;
            if (sparseArray != null && sparseArray.size() != 0) {
                int size = this.f19208c.size();
                int i4 = 0;
                int i5 = -1;
                int i6 = this.f19206a ? 0 : -1;
                int i7 = this.f19206a ? size - 1 : size;
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
                    C0929b c0929b = new C0929b(this, i4, this.f19208c.keyAt(i4), this.f19208c.valueAt(i4));
                    SparseArray<String> sparseArray2 = this.f19209d;
                    if (sparseArray2 != null && !StringUtils.isNull(sparseArray2.get(this.f19208c.keyAt(i4)))) {
                        c0929b.f19220d = this.f19209d.get(this.f19208c.keyAt(i4));
                    }
                    arrayList2.add(c0929b);
                    if (i3 > i4 && i3 < size) {
                        C0929b c0929b2 = new C0929b(this, i3, this.f19208c.keyAt(i3), this.f19208c.valueAt(i3));
                        SparseArray<String> sparseArray3 = this.f19209d;
                        if (sparseArray3 != null && !StringUtils.isNull(sparseArray3.get(this.f19208c.keyAt(i4)))) {
                            c0929b2.f19220d = this.f19209d.get(this.f19208c.keyAt(i3));
                        }
                        arrayList2.add(c0929b2);
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

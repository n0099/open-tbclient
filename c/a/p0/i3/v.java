package c.a.p0.i3;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.s.q.p0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class v {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            c.a.o0.t.c.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            return !(adAdSense == null || adAdSense.d()) ? c.a.e.e.p.j.H() : (c.a.e.e.p.j.x() && TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) || (c.a.e.e.p.j.H() && TbadkCoreApplication.getInst().getVideoAutoPlay() != 1);
        }
        return invokeV.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            c.a.o0.t.c.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            return !(adAdSense != null && adAdSense.i()) ? c.a.e.e.p.j.H() : (c.a.e.e.p.j.x() && TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) || (c.a.e.e.p.j.H() && TbadkCoreApplication.getInst().getVideoAutoPlay() != 1);
        }
        return invokeV.booleanValue;
    }

    public static int c(TbPageContext tbPageContext, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbPageContext, str)) == null) {
            if (tbPageContext == null || TextUtils.isEmpty(str)) {
                return 0;
            }
            if (!str.startsWith("tieba://deeplink?")) {
                return d(tbPageContext, str) ? 3 : 0;
            }
            Uri parse = Uri.parse(str);
            if (c.a.p0.x2.z.s(tbPageContext.getPageActivity(), Uri.parse(parse.getQueryParameter(TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT))) != 1000) {
                return d(tbPageContext, parse.getQueryParameter("wap")) ? 2 : 0;
            }
            return 1;
        }
        return invokeLL.intValue;
    }

    public static boolean d(TbPageContext tbPageContext, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, tbPageContext, str)) == null) {
            String[] strArr = {str};
            if (UrlManager.getInstance().UrlValidated(str)) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) tbPageContext, strArr, true);
                return true;
            }
            return UrlManager.getInstance().dealOneLink(tbPageContext, strArr);
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(List<Object> list, int i2) {
        int i3;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, list, i2) == null) || list == null || list.size() == 0) {
            return;
        }
        boolean z2 = MessageManager.getInstance().findTask(2016447) != null;
        int i4 = 0;
        while (i4 < list.size()) {
            if (list.get(i4) instanceof ICardInfo) {
                if (z2) {
                    ICardInfo iCardInfo = (ICardInfo) list.get(i4);
                    int viewCount = iCardInfo.getViewCount();
                    ArrayList arrayList = new ArrayList();
                    for (int i5 = 0; i5 < viewCount; i5++) {
                        ICardInfo viewItem = iCardInfo.getViewItem(i5, i2);
                        if (viewItem != null) {
                            viewItem.setBdUniqueId(c.a.p0.o1.o.e.f22615b.get(viewItem.getCardType()));
                            arrayList.add(viewItem);
                        }
                    }
                    if (arrayList.size() != 0) {
                        list.remove(i4);
                        list.addAll(i4, arrayList);
                        i3 = arrayList.size();
                        z = false;
                        if (!z) {
                            list.remove(i4);
                            i3 = 0;
                        }
                    }
                }
                i3 = 1;
                z = true;
                if (!z) {
                }
            } else {
                i3 = 1;
            }
            i4 += i3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void f(List<c.a.e.k.e.n> list, int i2) {
        int i3;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, list, i2) == null) || list == null || list.size() == 0) {
            return;
        }
        boolean z2 = MessageManager.getInstance().findTask(2016447) != null;
        int i4 = 0;
        while (i4 < list.size()) {
            if (list.get(i4) instanceof p0) {
                if (z2) {
                    if (!((p0) list.get(i4)).isValid()) {
                        ((p0) list.get(i4)).i();
                    }
                    if (((p0) list.get(i4)).isValid()) {
                        ICardInfo g2 = ((p0) list.get(i4)).g();
                        int viewCount = g2.getViewCount();
                        ArrayList arrayList = new ArrayList();
                        for (int i5 = 0; i5 < viewCount; i5++) {
                            ICardInfo viewItem = g2.getViewItem(i5, i2);
                            if (viewItem != null) {
                                viewItem.setBdUniqueId(c.a.p0.o1.o.e.f22615b.get(viewItem.getCardType()));
                                arrayList.add(viewItem);
                            }
                        }
                        if (arrayList.size() != 0) {
                            list.remove(i4);
                            list.addAll(i4, arrayList);
                            i3 = arrayList.size();
                            z = false;
                            if (!z) {
                                list.remove(i4);
                                i3 = 0;
                            }
                        }
                    }
                }
                i3 = 1;
                z = true;
                if (!z) {
                }
            } else {
                i3 = 1;
            }
            i4 += i3;
        }
    }

    public static ArrayList<BdUniqueId> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            int size = c.a.p0.o1.o.e.f22615b.size();
            ArrayList<BdUniqueId> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(c.a.p0.o1.o.e.f22615b.valueAt(i2));
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }
}

package c.a.r0.f1.n;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.r0.c0.a;
import c.a.r0.d1.e0;
import c.a.r0.s.r.d2;
import c.a.r0.u.m;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.common.others.url.UrlUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.ItemStarData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SpecHotTopicHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.module.hottopic.HotTopicStat;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.tbadk.widget.richText.RichTextMaker;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import tbclient.HeadItem;
import tbclient.PbContent;
import tbclient.TiebaPlusInfo;
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public static String a;

    /* renamed from: b  reason: collision with root package name */
    public static final h f12489b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends RichTextMaker<c.a.r0.j0.d.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            h(R.drawable.icon_pure_videotopic31);
            i(R.dimen.tbds3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.widget.richText.RichTextMaker
        @NonNull
        /* renamed from: j */
        public SpannableString b(int i2, @NonNull String str, @NonNull c.a.r0.j0.d.b bVar) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, str, bVar)) == null) {
                if (bVar.n() && str.contains("[视频]")) {
                    bVar.p(true);
                    str = str.replace("[视频]", "");
                }
                f(bVar.m());
                g(bVar.o() ? RichTextMaker.IconPos.START_OFFSET.setOffset(1) : RichTextMaker.IconPos.NONE);
                return super.b(i2, str, bVar);
            }
            return (SpannableString) invokeILL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.widget.richText.RichTextMaker
        /* renamed from: k */
        public void c(@NonNull View view, int i2, @NonNull c.a.r0.j0.d.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048579, this, view, i2, bVar) == null) {
                if (bVar.n()) {
                    Context context = view.getContext();
                    BdToast.i(context, context.getString(R.string.video_check_click_msg), R.drawable.icon_pure_toast_mistake40_svg, true).q();
                    return;
                }
                if (bVar.o()) {
                    HotTopicStat.a(UrlUtils.getParamValue(bVar.h(), "topic_id"), UrlUtils.getParamValue(bVar.h(), IntentConfig.TOPIC_NAME), bVar.i(), bVar.g(), bVar.k());
                }
                e.B(bVar.h(), bVar.l());
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends RichTextMaker<c.a.r0.f1.p.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(RichTextMaker.IconPos iconPos, int i2, int i3, int i4) {
            super(iconPos, i2, i3, i4);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iconPos, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((RichTextMaker.IconPos) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.widget.richText.RichTextMaker
        /* renamed from: j */
        public void c(@NonNull View view, int i2, @NonNull c.a.r0.f1.p.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2, aVar) == null) {
                aVar.q(TiePlusStat.StatType.CLICK);
                TiePlusEventController.onEvent(aVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends c.a.r0.f1.n.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i2, String str, String str2) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = str2;
        }

        @Override // c.a.r0.f1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                e.B(this.l, null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends c.a.r0.f1.n.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int i2, String str) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // c.a.r0.f1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                BdToast.i(SelectorHelper.getContext(), SelectorHelper.getContext().getString(R.string.video_check_click_msg), R.drawable.icon_pure_toast_mistake40_svg, true).q();
            }
        }
    }

    /* renamed from: c.a.r0.f1.n.e$e  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0809e extends c.a.r0.f1.n.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d2 l;
        public final /* synthetic */ String m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0809e(int i2, String str, d2 d2Var, String str2) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), str, d2Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = d2Var;
            this.m = str2;
        }

        @Override // c.a.r0.f1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                e.y(this.l, this.m);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class f extends c.a.r0.f1.n.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String l;
        public final /* synthetic */ d2 m;
        public final /* synthetic */ String n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(int i2, String str, String str2, d2 d2Var, String str3) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), str, str2, d2Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = str2;
            this.m = d2Var;
            this.n = str3;
        }

        @Override // c.a.r0.f1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                e.z(this.l, this.m, this.n);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class g extends c.a.r0.f1.n.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(int i2, String str, String str2) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = str2;
        }

        @Override // c.a.r0.f1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                e.A(this.l);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SparseArray<RichTextMaker<?>> a;

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new SparseArray<>();
        }

        public <T> RichTextMaker<T> a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (RichTextMaker<T>) this.a.get(i2) : (RichTextMaker) invokeI.objValue;
        }

        public void b(int i2, RichTextMaker<?> richTextMaker) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, richTextMaker) == null) {
                this.a.put(i2, richTextMaker);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(574995856, "Lc/a/r0/f1/n/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(574995856, "Lc/a/r0/f1/n/e;");
                return;
            }
        }
        f12489b = new h();
        w();
        v();
    }

    public static void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (TextUtils.isEmpty(str) || !(currentActivity instanceof TbPageContextSupport)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(((TbPageContextSupport) currentActivity).getPageContext(), new String[]{str});
        }
    }

    public static void B(String str, d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, d2Var) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (TextUtils.isEmpty(str) || !(currentActivity instanceof TbPageContextSupport)) {
                return;
            }
            TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) currentActivity;
            m mVar = new m();
            mVar.a = str;
            if (d2Var != null) {
                mVar.f13993b = d2Var.W0();
                mVar.f13994c = d2Var.I0();
            }
            c.a.r0.t0.b.h(mVar);
            UrlManager.getInstance().dealOneLink(tbPageContextSupport.getPageContext(), new String[]{mVar.a, mVar.f13994c});
        }
    }

    public static SpannableStringBuilder C(d2 d2Var, List<PbContent> list, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, d2Var, list, str)) == null) ? D(d2Var, list, str, null) : (SpannableStringBuilder) invokeLLL.objValue;
    }

    public static SpannableStringBuilder D(d2 d2Var, List<PbContent> list, String str, @Nullable List<c.a.r0.f1.p.a> list2) {
        InterceptResult invokeLLLL;
        int size;
        Pair<CharSequence, c.a.r0.f1.p.a> p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, d2Var, list, str, list2)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (ListUtils.isEmpty(list)) {
                if (str == null) {
                    str = "";
                }
                spannableStringBuilder.append((CharSequence) str);
            } else if (list != null && (size = list.size()) > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    PbContent pbContent = list.get(i2);
                    if (pbContent != null && (!TextUtils.isEmpty(pbContent.text) || !TextUtils.isEmpty(i(pbContent)))) {
                        int f2 = f(pbContent.type);
                        CharSequence charSequence = null;
                        if (f2 == 35 && (p = p(f2, d2Var, pbContent.tiebaplus_info)) != null) {
                            charSequence = p.first;
                            e0.b(list2);
                            list2.add(p.second);
                        }
                        if (charSequence == null) {
                            charSequence = n(d2Var, pbContent);
                        }
                        if (charSequence != null) {
                            spannableStringBuilder.append(charSequence);
                        }
                    }
                }
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLLLL.objValue;
    }

    public static SpannableStringBuilder E(List<PbContent> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) ? F(list, "") : (SpannableStringBuilder) invokeL.objValue;
    }

    public static SpannableStringBuilder F(List<PbContent> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, list, str)) == null) ? C(null, list, str) : (SpannableStringBuilder) invokeLL.objValue;
    }

    public static SpannableStringBuilder G(List<PbContent> list, List<HeadItem> list2, boolean z, @Nullable d2 d2Var, @Nullable List<c.a.r0.f1.p.a> list3) {
        InterceptResult invokeCommon;
        int size;
        CharSequence charSequence;
        char c2;
        Pair<CharSequence, c.a.r0.f1.p.a> p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{list, list2, Boolean.valueOf(z), d2Var, list3})) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (ListUtils.isEmpty(list)) {
                spannableStringBuilder.append((CharSequence) "");
            } else if (list != null && (size = list.size()) > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    PbContent pbContent = list.get(i2);
                    if (pbContent != null && (!TextUtils.isEmpty(pbContent.text) || !TextUtils.isEmpty(i(pbContent)))) {
                        int f2 = f(pbContent.type);
                        SpannableStringBuilder spannableStringBuilder2 = null;
                        if (f2 != 35 || (p = p(f2, d2Var, pbContent.tiebaplus_info)) == null) {
                            charSequence = null;
                        } else {
                            charSequence = p.first;
                            e0.b(list3);
                            list3.add(p.second);
                        }
                        if (charSequence == null) {
                            charSequence = n(d2Var, pbContent);
                        }
                        if (i2 != 0 || list2 == null) {
                            c2 = 65535;
                        } else {
                            spannableStringBuilder2 = e(list2);
                            c2 = f2 == 16 ? (char) 1 : (char) 0;
                        }
                        if (c2 == 65535) {
                            if (charSequence != null) {
                                spannableStringBuilder.append(charSequence);
                            }
                        } else if (c2 == 0) {
                            if (spannableStringBuilder2 != null) {
                                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                            }
                            if (charSequence != null) {
                                spannableStringBuilder.append(charSequence);
                            }
                        } else {
                            if (charSequence != null) {
                                spannableStringBuilder.append(charSequence);
                            }
                            if (spannableStringBuilder2 != null) {
                                if (z) {
                                    spannableStringBuilder.append((CharSequence) StringUtils.LF);
                                }
                                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                            }
                        }
                    }
                }
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    public static SpannableStringBuilder d(ItemStarData itemStarData) {
        InterceptResult invokeL;
        List<ItemStarData.SingleItemStar> list;
        int count;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, itemStarData)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (itemStarData == null || (list = itemStarData.list) == null || (count = ListUtils.getCount(list)) == 0) {
                return spannableStringBuilder;
            }
            if (count == 1) {
                try {
                    i3 = Integer.parseInt(((ItemStarData.SingleItemStar) ListUtils.getItem(itemStarData.list, 0)).content);
                } catch (NumberFormatException unused) {
                    i3 = 0;
                }
                spannableStringBuilder.append((CharSequence) q(i3, false));
            } else {
                for (ItemStarData.SingleItemStar singleItemStar : itemStarData.list) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(singleItemStar.name);
                    sb.append(": ");
                    sb.append(singleItemStar.type == 1 ? singleItemStar.content : " ");
                    spannableStringBuilder.append((CharSequence) new SpannableString(sb.toString()));
                    if (singleItemStar.type == 2) {
                        try {
                            i2 = Integer.parseInt(singleItemStar.content);
                        } catch (NumberFormatException unused2) {
                            i2 = 0;
                        }
                        spannableStringBuilder.append((CharSequence) q(i2, false));
                    }
                    if (!spannableStringBuilder.toString().endsWith(StringUtils.LF)) {
                        spannableStringBuilder.append((CharSequence) StringUtils.LF);
                    }
                }
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static SpannableStringBuilder e(List<HeadItem> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, list)) == null) {
            ItemStarData itemStarData = new ItemStarData();
            itemStarData.parseProto(list);
            return d(itemStarData);
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static int f(Integer num) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, num)) == null) {
            int intValue = num.intValue();
            if (intValue != 13) {
                if (intValue != 14) {
                    if (intValue != 18) {
                        if (intValue != 20) {
                            if (intValue != 27) {
                                if (intValue != 1282) {
                                    switch (intValue) {
                                        case 0:
                                            return 1;
                                        case 1:
                                            return 2;
                                        case 2:
                                            return 4;
                                        case 3:
                                            return 8;
                                        case 4:
                                            return 16;
                                        case 5:
                                            return 32;
                                        case 6:
                                            return 64;
                                        default:
                                            switch (intValue) {
                                                case 8:
                                                    return 128;
                                                case 9:
                                                    return 256;
                                                case 10:
                                                    return 512;
                                                case 11:
                                                    return 17;
                                                default:
                                                    switch (intValue) {
                                                        case 30:
                                                        case 31:
                                                        case 32:
                                                        case 33:
                                                            return 1;
                                                        default:
                                                            switch (intValue) {
                                                                case 35:
                                                                    return 35;
                                                                case 36:
                                                                    return 36;
                                                                case 37:
                                                                    return 37;
                                                                default:
                                                                    return 0;
                                                            }
                                                    }
                                            }
                                    }
                                }
                                return 1282;
                            }
                            return 39;
                        }
                        return 20;
                    }
                    return 18;
                }
                return 1280;
            }
            return 1024;
        }
        return invokeL.intValue;
    }

    public static void g(StatisticItem statisticItem, d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, statisticItem, d2Var) == null) {
            if (d2Var.H2()) {
                statisticItem.param("obj_type", 2);
            } else if (d2Var.h2()) {
                statisticItem.param("obj_type", 4);
            } else if (d2Var.B1) {
                statisticItem.param("obj_type", 5);
            } else if (d2Var.P1()) {
                statisticItem.param("obj_type", 6);
            } else if (d2Var.Q1()) {
                statisticItem.param("obj_type", 7);
            } else if (d2Var.S1()) {
                statisticItem.param("obj_type", 8);
            } else if (d2Var.R1()) {
                statisticItem.param("obj_type", 9);
            } else if (d2Var.getType() == d2.g3) {
                statisticItem.param("obj_type", 1);
            }
        }
    }

    public static SpannableString h(d2 d2Var, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, d2Var, str, str2)) == null) ? m(d2Var, 16, str, str2) : (SpannableString) invokeLLL.objValue;
    }

    @NonNull
    public static final String i(@NonNull PbContent pbContent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, pbContent)) == null) {
            TiebaPlusInfo tiebaPlusInfo = pbContent.tiebaplus_info;
            return tiebaPlusInfo != null ? tiebaPlusInfo.desc : "";
        }
        return (String) invokeL.objValue;
    }

    public static SpannableString j(String str) {
        InterceptResult invokeL;
        int b2;
        String str2;
        a.C0793a c2;
        double d2;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            if (str == null || (b2 = TbFaceManager.e().b(str)) == 0) {
                return null;
            }
            String f2 = TbFaceManager.e().f(str);
            if (!TextUtils.isEmpty(str) && str.startsWith("shoubai_emoji_")) {
                str2 = PreferencesUtil.LEFT_MOUNT + f2 + PreferencesUtil.RIGHT_MOUNT;
                c2 = TbFaceManager.e().c("image_emoticon");
            } else {
                str2 = SmallTailInfo.EMOTION_PREFIX + f2 + SmallTailInfo.EMOTION_SUFFIX;
                c2 = TbFaceManager.e().c(str);
            }
            SpannableString spannableString = new SpannableString(str2 + " ");
            c.a.r0.f1.n.d dVar = new c.a.r0.f1.n.d(TbadkCoreApplication.getInst().getContext(), b2);
            if (c2 != null) {
                if (str != null && str.startsWith("bearchildren_")) {
                    d2 = 0.25d;
                    a2 = c2.a();
                } else {
                    d2 = 0.4d;
                    a2 = c2.a();
                }
                int i2 = (int) (a2 * d2);
                dVar.setBounds(new Rect(0, 0, i2, i2));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new c.a.r0.f1.b(dVar, 2), 0, str2.length(), 33);
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public static SpannableString k(d2 d2Var, int i2, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{d2Var, Integer.valueOf(i2), str, str2, str3})) == null) ? r(d2Var, i2, str, str2, 0, str3) : (SpannableString) invokeCommon.objValue;
    }

    public static SpannableString l(d2 d2Var, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65555, null, d2Var, str, str2, str3)) == null) ? k(d2Var, 39, str, str2, str3) : (SpannableString) invokeLLLL.objValue;
    }

    public static SpannableString m(d2 d2Var, int i2, String str, String str2) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLILL = interceptable.invokeLILL(65556, null, d2Var, i2, str, str2)) == null) ? r(d2Var, i2, str, str2, 0, null) : (SpannableString) invokeLILL.objValue;
    }

    public static CharSequence n(d2 d2Var, PbContent pbContent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, d2Var, pbContent)) == null) {
            int f2 = f(pbContent.type);
            if (f2 != 2) {
                if (f2 != 4) {
                    if (f2 == 16) {
                        return h(d2Var, pbContent.text, String.valueOf(pbContent.uid));
                    }
                    if (f2 != 18) {
                        if (f2 == 35) {
                            return new SpannableString("");
                        }
                        if (f2 == 39) {
                            String str = pbContent.text;
                            return l(d2Var, str, pbContent.item_id + "", pbContent.item_forum_name);
                        } else if (f2 != 1282) {
                            String str2 = pbContent.text;
                            return new SpannableString(str2 != null ? str2 : "");
                        }
                    }
                    if (d2Var != null && pbContent != null) {
                        c.a.r0.j0.d.b f3 = c.a.r0.j0.d.b.f(d2Var, pbContent);
                        f3.b(HotTopicStat.Locate.THREAD_CARD);
                        f3.a(f2 == 1282);
                        return o(f3);
                    }
                }
                return j(pbContent.text);
            }
            return m(d2Var, 2, pbContent.text, pbContent.link);
        }
        return (CharSequence) invokeLL.objValue;
    }

    public static SpannableString o(@NonNull c.a.r0.j0.d.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, bVar)) == null) {
            SpannableString b2 = f12489b.a(18).b(18, bVar.j().text, bVar);
            SpecHotTopicHelper.addSpecTopic(bVar.l(), b2, b2.toString(), 0);
            return b2;
        }
        return (SpannableString) invokeL.objValue;
    }

    @Nullable
    public static Pair<CharSequence, c.a.r0.f1.p.a> p(int i2, @Nullable d2 d2Var, @Nullable TiebaPlusInfo tiebaPlusInfo) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65559, null, i2, d2Var, tiebaPlusInfo)) == null) {
            if (d2Var == null || !TiePlusHelper.j(tiebaPlusInfo) || TextUtils.isEmpty(tiebaPlusInfo.desc)) {
                return null;
            }
            c.a.r0.f1.p.a c2 = c.a.r0.f1.p.a.c(i2, tiebaPlusInfo, d2Var);
            RichTextMaker a2 = f12489b.a(i2);
            int intValue = tiebaPlusInfo.jump_type.intValue();
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue == 5) {
                        a2.h(R.drawable.icon_mask_messageline);
                    } else if (intValue == 6) {
                        a2.h(R.drawable.pic_post_order);
                    } else if (intValue != 7) {
                        a2.h(R.drawable.icon_pure_post_link16);
                    }
                }
                a2.h(R.drawable.icon_pure_wechat16);
            } else {
                a2.h(R.drawable.icon_pure_post_download16);
            }
            return Pair.create(a2.b(i2, tiebaPlusInfo.desc, c2), c2);
        }
        return (Pair) invokeILL.objValue;
    }

    public static SpannableString q(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65560, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (i2 < 0) {
                return null;
            }
            int i3 = i2 > 5 ? 5 : i2;
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds36);
            int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds13);
            SpannableString spannableString = new SpannableString(TbadkCoreApplication.getInst().getString(R.string.item_stars));
            spannableString.setSpan(new c.a.r0.s.i0.r.c(i3, dimenPixelSize, dimenPixelSize2, dimenPixelSize3, 0, z), 0, spannableString.length(), 33);
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public static SpannableString r(d2 d2Var, int i2, String str, String str2, int i3, String str3) {
        InterceptResult invokeCommon;
        SpannableString spannableString;
        c.a.r0.f1.n.f gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65561, null, new Object[]{d2Var, Integer.valueOf(i2), str, str2, Integer.valueOf(i3), str3})) == null) {
            String str4 = str;
            if (str4 != null) {
                boolean z = i2 == 2 && x(str, str2);
                boolean z2 = i2 == 39;
                if (!str4.endsWith(" ")) {
                    str4 = str4 + " ";
                }
                String str5 = str4;
                if (z) {
                    spannableString = new SpannableString("m" + str5);
                } else if (z2) {
                    spannableString = new SpannableString(str5 + "m");
                } else {
                    spannableString = new SpannableString(str5);
                }
                SpannableString spannableString2 = spannableString;
                if (i2 == 18) {
                    gVar = new c(i2, str2, str2);
                } else if (i2 == 1282) {
                    gVar = new d(i2, str2);
                } else if (i2 == 16) {
                    gVar = new C0809e(i2, str2, d2Var, str2);
                } else if (i2 == 39) {
                    gVar = new f(i2, str2, str2, d2Var, str3);
                } else {
                    gVar = new g(i2, str2, str2);
                }
                gVar.k(i3);
                if (i3 == 1) {
                    gVar.j(R.color.CAM_X0109);
                } else {
                    gVar.j(-1);
                }
                if (z) {
                    EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_post_link16, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
                    eMRichTextAnyIconSpan.c(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
                    spannableString2.setSpan(eMRichTextAnyIconSpan, 0, 1, 33);
                    spannableString2.setSpan(gVar, 1, (str5.length() + 1) - 1, 33);
                    return spannableString2;
                } else if (z2) {
                    EMRichTextAnyIconSpan eMRichTextAnyIconSpan2 = new EMRichTextAnyIconSpan(R.drawable.icon_use_item_n, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
                    eMRichTextAnyIconSpan2.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X006));
                    spannableString2.setSpan(eMRichTextAnyIconSpan2, str5.length() - 1, str5.length() + 1, 33);
                    spannableString2.setSpan(gVar, 0, str5.length() - 1, 33);
                    if (a != d2Var.v1()) {
                        a = d2Var.v1();
                        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_ITEM_THROUGH_EXPOSURE);
                        statisticItem.param("tid", a);
                        statisticItem.param("obj_locate", d2Var.b2 ? 1 : 2);
                        TiebaStatic.log(statisticItem);
                        return spannableString2;
                    }
                    return spannableString2;
                } else {
                    spannableString2.setSpan(gVar, 0, str5.length() - 1, 33);
                    return spannableString2;
                }
            }
            return null;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    @Deprecated
    public static SpannableString s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) ? new SpannableString("") : (SpannableString) invokeV.objValue;
    }

    public static boolean t(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, d2Var)) == null) {
            if (d2Var == null) {
                return false;
            }
            List<PbContent> W = d2Var.W();
            if (!ListUtils.isEmpty(W)) {
                for (int count = ListUtils.getCount(W) - 1; count >= 0; count--) {
                    if (W.get(count).type.intValue() == 37) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean u(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, postData)) == null) {
            if (postData != null && postData.M() != null) {
                ArrayList<TbRichTextData> y = postData.M().y();
                if (!ListUtils.isEmpty(y)) {
                    for (int count = ListUtils.getCount(y) - 1; count >= 0; count--) {
                        if (y.get(count).getType() == 37) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, null) == null) {
            f12489b.b(18, new a());
        }
    }

    public static void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, null) == null) {
            f12489b.b(35, new b(RichTextMaker.IconPos.START, R.drawable.icon_pure_post_link16, R.color.CAM_X0304, R.dimen.M_W_X002));
        }
    }

    public static boolean x(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65567, null, str, str2)) == null) {
            if (l.isEmpty(str) || l.isEmpty(str2)) {
                return false;
            }
            if (UrlManager.getInstance().isUrlValid(str2) && UrlManager.getInstance().isUrlValid(str)) {
                if (str.equals(str2)) {
                    return false;
                }
                List<String> queryParameters = Uri.parse(str2).getQueryParameters("url");
                if (ListUtils.isEmpty(queryParameters)) {
                    return true;
                }
                String str3 = queryParameters.get(0);
                if (!str.equals(str3)) {
                    if (!("http://" + str).equals(str3)) {
                        if (("https://" + str).equals(str3)) {
                        }
                    }
                }
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static void y(d2 d2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65568, null, d2Var, str) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (TextUtils.isEmpty(str) || currentActivity == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(currentActivity, str, null)));
            if (d2Var != null) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_DYNAMIC_CARD_CLICK);
                if (d2Var.a2()) {
                    statisticItem = new StatisticItem(TbadkCoreStatisticKey.CONCERN_TAB_THREAD_CLICK);
                    statisticItem.param("obj_source", 1);
                    g(statisticItem, d2Var);
                } else if (d2Var.b2) {
                    statisticItem.param("obj_source", 2);
                    if (d2Var.L() != null) {
                        statisticItem.param("obj_type", d2Var.L().oriUgcType);
                    }
                } else {
                    statisticItem.param("obj_source", 3);
                    if (d2Var.L() != null) {
                        statisticItem.param("obj_type", d2Var.L().oriUgcType);
                    }
                }
                statisticItem.param("obj_locate", 5);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public static void z(String str, d2 d2Var, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65569, null, str, d2Var, str2) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_ITEM_THROUGH_CLICK);
            statisticItem.param("tid", d2Var.v1());
            statisticItem.param("obj_locate", d2Var.b2 ? 1 : 2);
            statisticItem.param("obj_type", str);
            TiebaStatic.log(statisticItem);
            ItemClickJumpUtil.itemClickJump(str2, str, 8, 8);
        }
    }
}

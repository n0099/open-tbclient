package c.a.t0.t2.u.f.e1;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import c.a.s0.s.q.e2;
import c.a.t0.t2.r.f;
import c.a.t0.t2.r.o;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbPostShareDialogConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public b f23089b;

    /* loaded from: classes8.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.t0.t2.u.f.e1.c.b
        public void a(f fVar, e2 e2Var, PostData postData, c.a.s0.f1.n.a aVar) {
            String e2;
            String w1;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, fVar, e2Var, postData, aVar) == null) {
                if ((fVar == null && e2Var == null) || postData == null || this.a.a == null) {
                    return;
                }
                if (fVar == null) {
                    e2 = this.a.e(e2Var);
                } else {
                    String str2 = fVar.N(false)[0];
                    if (!StringUtils.isNull(str2) && str2.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str2 = str2.substring(37);
                    }
                    e2 O = fVar.O();
                    if (O == null) {
                        return;
                    }
                    String str3 = str2;
                    e2Var = O;
                    e2 = str3;
                }
                o oVar = new o();
                oVar.h(e2Var.o());
                if (!StringUtils.isNull(e2)) {
                    oVar.k(e2);
                }
                oVar.l(e2Var.s1());
                oVar.g(aVar);
                oVar.i(postData);
                String title = e2Var.getTitle();
                if (StringUtils.isNull(title)) {
                    title = e2Var.o();
                }
                oVar.h(title);
                if (e2Var.H2()) {
                    w1 = e2Var.L().oriUgcTid;
                    str = "?share=9105&fr=dshare&dtype=" + e2Var.L().oriUgcType + "&dvid=" + e2Var.L().oriUgcVid + "&nid=" + e2Var.L().oriUgcNid;
                } else {
                    w1 = e2Var.w1();
                    str = "?share=9105&fr=share";
                }
                oVar.j(this.a.d("http://tieba.baidu.com/p/" + w1 + (str + "&post_id=" + postData.G() + "&share_from=comment&post_sort=1")));
                ShareItem shareItem = new ShareItem();
                shareItem.b0 = 1;
                shareItem.k = true;
                shareItem.q = w1;
                shareItem.X = postData.G();
                Bundle bundle = new Bundle();
                bundle.putString("tid", w1);
                bundle.putString("pid", postData.G());
                bundle.putInt("source", 1);
                shareItem.k(bundle);
                PbPostShareDialogConfig pbPostShareDialogConfig = new PbPostShareDialogConfig(this.a.a.getPageActivity(), shareItem, true, oVar);
                pbPostShareDialogConfig.setIsCopyLink(false);
                pbPostShareDialogConfig.setHideMode(pbPostShareDialogConfig.hideMode | 32);
                this.a.a.sendMessage(new CustomMessage(2001276, pbPostShareDialogConfig));
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                statisticItem.param("tid", w1);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                if (e2Var.Z() != null) {
                    statisticItem.param("fid", e2Var.Z().a);
                }
                if (e2Var.z1() != null) {
                    statisticItem.param("post_id", postData.G());
                }
                statisticItem.param("obj_locate", 21);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(f fVar, e2 e2Var, PostData postData, c.a.s0.f1.n.a aVar);
    }

    public c(TbPageContext tbPageContext) {
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
        this.f23089b = new a(this);
        this.a = tbPageContext;
    }

    public final Bitmap d(String str) {
        InterceptResult invokeL;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null || str.length() == 0 || (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) == null || runTask.getData() == null) {
                return null;
            }
            return (Bitmap) runTask.getData();
        }
        return (Bitmap) invokeL.objValue;
    }

    public final String e(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2Var)) == null) {
            String str = null;
            if (e2Var == null) {
                return null;
            }
            if (e2Var.p1() != null && !TextUtils.isEmpty(e2Var.p1().cover)) {
                return e2Var.p1().cover;
            }
            if (e2Var.G0() == null) {
                return null;
            }
            ArrayList<MediaData> G0 = e2Var.G0();
            int size = G0.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                MediaData mediaData = G0.get(i2);
                if (mediaData != null && (mediaData.getType() == 3 || mediaData.getType() == 5)) {
                    if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                        str = mediaData.getThumbnails_url();
                        break;
                    } else if (!StringUtils.isNull(mediaData.getPicUrl())) {
                        str = mediaData.getPicUrl();
                        break;
                    }
                }
                i2++;
            }
            return (str != null || e2Var.u1() == null || TextUtils.isEmpty(e2Var.u1().thumbnail_url)) ? str : e2Var.u1().thumbnail_url;
        }
        return (String) invokeL.objValue;
    }
}

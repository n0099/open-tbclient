package cn.jingling.lib.filters;

import android.content.Context;
import cn.jingling.lib.filters.onekey.Ansel;
import cn.jingling.lib.filters.onekey.Archive;
import cn.jingling.lib.filters.onekey.BanBo;
import cn.jingling.lib.filters.onekey.BlueTone;
import cn.jingling.lib.filters.onekey.DarkBlue;
import cn.jingling.lib.filters.onekey.Dreamy;
import cn.jingling.lib.filters.onekey.Emission;
import cn.jingling.lib.filters.onekey.Etoc;
import cn.jingling.lib.filters.onekey.JiuShiGuang;
import cn.jingling.lib.filters.onekey.LomoPath;
import cn.jingling.lib.filters.onekey.Nashiv;
import cn.jingling.lib.filters.onekey.NiHong;
import cn.jingling.lib.filters.onekey.Pop;
import cn.jingling.lib.filters.onekey.Postive;
import cn.jingling.lib.filters.onekey.QingXin;
import cn.jingling.lib.filters.onekey.ReallyClassicHDR;
import cn.jingling.lib.filters.onekey.SingleColorPurple;
import cn.jingling.lib.filters.onekey.SingleColorRed;
import cn.jingling.lib.filters.onekey.Sketch;
import cn.jingling.lib.filters.onekey.Skin;
import cn.jingling.lib.filters.onekey.Sunny;
import cn.jingling.lib.filters.onekey.Sweety;
import cn.jingling.lib.filters.onekey.XingGuang;
import cn.jingling.lib.filters.onekey.XuanCai;
import cn.jingling.lib.filters.onekey.XuanGuang;
import cn.jingling.lib.filters.onekey.XueHua;
import cn.jingling.lib.filters.onekey.Yellow;
import cn.jingling.lib.filters.onekey.YouHua;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class FilterFactory {
    private static final Map<String, Class<? extends OneKeyFilter>> sOneKeyFilters = new HashMap<String, Class<? extends OneKeyFilter>>() { // from class: cn.jingling.lib.filters.FilterFactory.1
        private static final long serialVersionUID = -4215192030410560547L;

        {
            put("skin", Skin.class);
            put("fleeting", JiuShiGuang.class);
            put("dazzle", XuanCai.class);
            put("old", Archive.class);
            put("heaven", BanBo.class);
            put("bluetone", BlueTone.class);
            put("lomo", LomoPath.class);
            put("pupple", DarkBlue.class);
            put("romantic", Dreamy.class);
            put("timetravel", Emission.class);
            put("etoc", Etoc.class);
            put("gray", Ansel.class);
            put("nashiv", Nashiv.class);
            put("neon", NiHong.class);
            put("pop", Pop.class);
            put("positive", Postive.class);
            put("elegant", QingXin.class);
            put("classichdr", ReallyClassicHDR.class);
            put("singlepurple", SingleColorPurple.class);
            put("singlered", SingleColorRed.class);
            put("sketch", Sketch.class);
            put("sunny", Sunny.class);
            put("sweet", Sweety.class);
            put("star", XingGuang.class);
            put("warm", XuanGuang.class);
            put("snow", XueHua.class);
            put("yellow", Yellow.class);
            put("painting", YouHua.class);
        }
    };

    public static OneKeyFilter createOneKeyFilter(Context context, String str) {
        if (!checkPackage(context)) {
            System.out.println("packageName error");
            return null;
        }
        try {
            return sOneKeyFilters.get(str.toLowerCase()).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e2) {
            e2.printStackTrace();
            return null;
        } catch (NullPointerException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    private static boolean checkPackage(Context context) {
        for (int i = 0; i < AllowedPackageList.packs.size(); i++) {
            if (context.getApplicationInfo().packageName.equals(AllowedPackageList.packs.get(i))) {
                return true;
            }
        }
        return false;
    }
}

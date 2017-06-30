package com.baidu.tbadk.core.hybrid;

import android.widget.Toast;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class h {
    public static void cv(int i) {
        String str = "";
        switch (i) {
            case 1:
                str = "IO读取异常";
                break;
        }
        Toast.makeText(TbadkCoreApplication.m9getInst(), str, 0).show();
    }
}

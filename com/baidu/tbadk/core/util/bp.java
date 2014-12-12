package com.baidu.tbadk.core.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class bp {
    private static int JH = -1;
    private static int JI = -1;
    private static boolean JJ = false;
    private static com.baidu.adp.lib.e.a<Integer, Integer> JK = new com.baidu.adp.lib.e.a<>(500);
    private static Context mAppContext = null;

    public static void S(Context context) {
        mAppContext = context;
        JJ = true;
    }

    private static void pL() {
        if (mAppContext != null && mAppContext.getResources() != null) {
            JI = mAppContext.getResources().getColor(com.baidu.tieba.t.more_color);
            JH = mAppContext.getResources().getColor(com.baidu.tieba.t.skin_1_common_color);
        }
    }

    private static int bZ(int i) {
        return an(i == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int an(boolean z) {
        if (JJ) {
            JJ = false;
            pL();
        }
        return z ? JH : JI;
    }

    public static void m(View view) {
        if (view instanceof ViewGroup) {
            b((ViewGroup) view, TbadkCoreApplication.m255getInst().getSkinType());
        }
    }

    public static void n(View view) {
        if (view != null) {
            JK.remove(Integer.valueOf(System.identityHashCode(view)));
        }
    }

    public static void b(ViewGroup viewGroup, int i) {
        int identityHashCode = System.identityHashCode(viewGroup);
        Integer num = JK.get(Integer.valueOf(identityHashCode));
        if (num == null || i != num.intValue()) {
            c(viewGroup, i);
            JK.put(Integer.valueOf(identityHashCode), Integer.valueOf(i));
        }
    }

    public static void a(ViewGroup viewGroup, boolean z, br brVar) {
        if (!z || !brVar.k(viewGroup)) {
            LinkedList linkedList = new LinkedList();
            while (true) {
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (!brVar.k(childAt)) {
                        if (childAt instanceof ViewGroup) {
                            linkedList.addLast((ViewGroup) childAt);
                        }
                    } else {
                        return;
                    }
                }
                if (!linkedList.isEmpty()) {
                    viewGroup = (ViewGroup) linkedList.removeFirst();
                } else {
                    return;
                }
            }
        }
    }

    private static void c(ViewGroup viewGroup, int i) {
        a(viewGroup, true, new bq(i, i == 1));
    }

    public static void k(View view, int i) {
        if (view != null) {
            if (i == 1) {
                view.setBackgroundColor(-14078923);
            } else {
                view.setBackgroundColor(-1183760);
            }
        }
    }

    public static void e(View view, int i, int i2) {
        if (view != null) {
            view.setBackgroundDrawable(null);
            if (i == 0) {
                ax.i(view, com.baidu.tieba.v.auto_skin_list_item_bg_up);
            } else if (i == 2) {
                ax.i(view, com.baidu.tieba.v.auto_skin_list_item_bg_down);
            } else {
                ax.i(view, com.baidu.tieba.v.list_selector_item);
            }
        }
    }

    public static void k(TextView textView, int i) {
        if (textView != null) {
            if (i == 1) {
                textView.setTextColor(-11446171);
            } else {
                textView.setTextColor(-5065030);
            }
        }
    }

    public static void c(TextView textView, int i) {
        if (textView != null) {
            textView.setTextColor(bZ(i));
        }
    }

    public static void a(CheckBox checkBox, int i) {
        if (checkBox != null) {
            checkBox.setTextColor(bZ(i));
        }
    }
}

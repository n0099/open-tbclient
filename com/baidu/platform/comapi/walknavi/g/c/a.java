package com.baidu.platform.comapi.walknavi.g.c;

import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class a {
    public static int a = -1;
    private static final int[] b = {500, 400, 300, 200, 100, 90, 80, 70, 60, 50, 30, 20, 10};

    /* loaded from: classes8.dex */
    static class b {
        static final a a = new a();
    }

    /* loaded from: classes8.dex */
    public interface c {
        void a(int i, int i2);
    }

    public static a a() {
        return b.a;
    }

    private a() {
    }

    public void a(int i, c cVar) {
        int i2;
        int i3 = 0;
        if (i > 0 && i < 10) {
            i2 = (int) (i / 2.5d);
            if (i2 != 1) {
                if (i2 == 2) {
                    i3 = 1;
                } else {
                    i3 = i2 == 3 ? 2 : -1;
                }
            }
        } else if (i >= 10 && i < 20) {
            i2 = 1;
            i3 = 3;
        } else if (i >= 20 && i < 30) {
            i3 = 4;
            i2 = 1;
        } else if (i >= 30 && i < 50) {
            i3 = 5;
            i2 = 1;
        } else if (i >= 50 && i < 60) {
            i3 = 6;
            i2 = 1;
        } else if (i >= 60 && i < 70) {
            i3 = 7;
            i2 = 1;
        } else if (i >= 70 && i < 80) {
            i3 = 8;
            i2 = 1;
        } else if (i >= 80 && i < 90) {
            i3 = 9;
            i2 = 1;
        } else if (i >= 90 && i < 100) {
            i3 = 10;
            i2 = 1;
        } else if (i < 100) {
            i2 = 0;
            i3 = -1;
        } else {
            C0232a b2 = b(i);
            i3 = b2.a;
            i2 = b2.b;
        }
        if (a != i3) {
            cVar.a(i3, i2);
        }
        a = i3;
    }

    private C0232a b(int i) {
        C0232a c0232a = new C0232a();
        int i2 = (i / 10) * 10;
        int i3 = 0;
        while (true) {
            if (i3 >= b.length) {
                break;
            } else if (i2 < b[i3] || i2 % b[i3] != 0) {
                i3++;
            } else {
                c0232a.a = c(b[i3]);
                c0232a.b = i2 / b[i3];
                break;
            }
        }
        return c0232a;
    }

    private int c(int i) {
        if (i == 500) {
            return 15;
        }
        if (i == 400) {
            return 14;
        }
        if (i == 300) {
            return 13;
        }
        if (i == 200) {
            return 12;
        }
        if (i == 100) {
            return 11;
        }
        if (i != 90) {
            if (i == 80) {
                return 9;
            }
            if (i == 70) {
                return 8;
            }
            if (i == 60) {
                return 7;
            }
            if (i == 50) {
                return 6;
            }
            if (i == 30) {
                return 5;
            }
            if (i == 20) {
                return 4;
            }
            if (i == 10) {
                return 3;
            }
            return 0;
        }
        return 10;
    }

    public int a(int i) {
        if (i == 0 || i == 1 || i == 2) {
            return R.drawable.aiapps_entry_guide_nightmode_mask;
        }
        if (i == 3) {
            return R.drawable.aiapps_favorite_guide_add_bg;
        }
        if (i == 4) {
            return R.drawable.aiapps_favorite_guide_arrow;
        }
        if (i == 5) {
            return R.drawable.aiapps_empty_icon_error;
        }
        if (i == 6) {
            return R.drawable.aiapps_enter_fullscreen;
        }
        if (i == 7) {
            return R.drawable.aiapps_emptyview_btn_bg_pressed;
        }
        if (i == 8) {
            return R.drawable.aiapps_discovery_home_menu_item_selector;
        }
        if (i == 9) {
            return R.drawable.aiapps_emptyview_btn_bg;
        }
        if (i == 10) {
            return R.drawable.aiapps_empty_icon_network;
        }
        if (i == 11) {
            return R.drawable.aiapps_favorite_guide_add_text;
        }
        if (i == 12) {
            return R.drawable.aiapps_discovery_feedback_menu_bg;
        }
        if (i == 13) {
            return R.drawable.aiapps_dialog_btn_bg_day_right;
        }
        if (i == 14) {
            return R.drawable.aiapps_entry_guide_bg;
        }
        if (i == 15) {
            return R.drawable.aiapps_emptyview_btn_bg_default;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.platform.comapi.walknavi.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0232a {
        public int a;
        public int b;

        C0232a() {
        }
    }
}

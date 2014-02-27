package com.baidu.adp.lib.debug.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.adp.lib.debug.service.SwitchDebugService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.Vector;
/* loaded from: classes.dex */
public class b extends BaseAdapter implements View.OnFocusChangeListener, View.OnTouchListener, AdapterView.OnItemClickListener {
    private static Vector<a> b = null;
    private static boolean[] c = null;
    private Context a;

    public b(Context context) {
        this.a = null;
        this.a = context;
        a();
        c = new boolean[b.size()];
        for (int i = 0; i < c.length; i++) {
            c[i] = false;
        }
    }

    private static void a() {
        if (b == null) {
            Properties properties = SwitchDebugService.a;
            if (properties == null) {
                com.baidu.adp.lib.util.e.c("File of config is null!");
                return;
            }
            synchronized (b.class) {
                if (b == null) {
                    b = new Vector<>();
                    String property = properties.getProperty("edit_options");
                    if (property != null) {
                        String[] split = property.split(",");
                        for (String str : split) {
                            a aVar = new a();
                            aVar.a(properties.getProperty("edit_options_" + str + "_title"));
                            String property2 = properties.getProperty("edit_options_" + str + "_access");
                            if (property2 != null) {
                                String[] split2 = property2.split(":");
                                aVar.b(split2[0]);
                                aVar.c(split2[1]);
                                aVar.a(properties.getProperty("edit_options_" + str + "_defaultValues").split(","));
                                b.add(aVar);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.a).inflate(com.baidu.adp.c.adp_debug_custom_config_items, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(com.baidu.adp.d.adp_debug_custom_config_title);
        TextView textView2 = (TextView) inflate.findViewById(com.baidu.adp.d.adp_debug_edit_custom_config);
        ListView listView = (ListView) inflate.findViewById(com.baidu.adp.d.adp_debug_custom_config_defaults_list);
        Button button = (Button) inflate.findViewById(com.baidu.adp.d.switch_custom_config);
        button.setTag(getItem(i));
        textView2.setTag(Integer.valueOf(i));
        textView.setOnTouchListener(this);
        textView2.setOnFocusChangeListener(this);
        ((Button) inflate.findViewById(com.baidu.adp.d.delete_custom_config)).setOnTouchListener(this);
        button.setOnTouchListener(this);
        textView2.setInputType(1);
        listView.setOnItemClickListener(this);
        a aVar = (a) getItem(i);
        textView.setText(aVar.a());
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < aVar.b().length; i2++) {
            HashMap hashMap = new HashMap();
            hashMap.put("default_value", aVar.b()[i2]);
            arrayList.add(hashMap);
        }
        listView.setAdapter((ListAdapter) new SimpleAdapter(this.a, arrayList, com.baidu.adp.c.adp_debug_custom_config_default_value_item, new String[]{"default_value"}, new int[]{com.baidu.adp.d.adp_debug_constom_config_default_value}));
        a(listView);
        if (!c[i]) {
            listView.setVisibility(8);
        } else {
            listView.setVisibility(0);
        }
        return inflate;
    }

    private static void a(ListView listView) {
        ListAdapter adapter = listView.getAdapter();
        if (adapter != null) {
            int i = 0;
            for (int i2 = 0; i2 < adapter.getCount(); i2++) {
                View view = adapter.getView(i2, null, listView);
                view.measure(0, 0);
                i += view.getMeasuredHeight();
            }
            ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
            layoutParams.height = (listView.getDividerHeight() * (adapter.getCount() - 1)) + i;
            listView.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object item = adapterView.getAdapter().getItem(i);
        if (item != null) {
            ((TextView) ((View) adapterView.getParent()).findViewById(com.baidu.adp.d.adp_debug_edit_custom_config)).setText((String) ((HashMap) item).get("default_value"));
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Object tag;
        boolean z;
        String str;
        if (motionEvent.getAction() == 0) {
            if (view.getId() == com.baidu.adp.d.delete_custom_config) {
                ((TextView) ((View) view.getParent()).findViewById(com.baidu.adp.d.adp_debug_edit_custom_config)).setText("");
            } else if (view.getId() == com.baidu.adp.d.switch_custom_config && (tag = view.getTag()) != null) {
                a aVar = (a) tag;
                String c2 = aVar.c();
                String d = aVar.d();
                String charSequence = ((TextView) ((View) view.getParent()).findViewById(com.baidu.adp.d.adp_debug_edit_custom_config)).getText().toString();
                try {
                    Class<?> cls = Class.forName(c2);
                    cls.getMethod(d, String.class).invoke(cls, charSequence);
                    z = true;
                } catch (Exception e) {
                    com.baidu.adp.lib.util.e.b(e.getMessage());
                    z = false;
                }
                if (z) {
                    str = "配置修改成功！";
                } else {
                    str = "配置修改失败！！！";
                }
                Toast makeText = Toast.makeText(this.a.getApplicationContext(), str, 1);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
        }
        return false;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (view.getId() == com.baidu.adp.d.adp_debug_edit_custom_config && z) {
            ((View) view.getParent().getParent().getParent()).findViewById(com.baidu.adp.d.adp_debug_custom_config_defaults_list).setVisibility(0);
            Object tag = view.getTag();
            if (tag != null) {
                c[((Integer) tag).intValue()] = true;
            }
        }
    }
}

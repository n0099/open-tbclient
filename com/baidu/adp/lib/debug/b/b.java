package com.baidu.adp.lib.debug.b;

import android.content.Context;
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
import com.baidu.adp.R;
import com.baidu.adp.lib.debug.service.SwitchDebugService;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.Vector;
/* loaded from: classes.dex */
public class b extends BaseAdapter implements View.OnFocusChangeListener, View.OnTouchListener, AdapterView.OnItemClickListener {
    private static Vector<a> gS = null;
    private static boolean[] gT = null;
    private Context mContext;

    public b(Context context) {
        this.mContext = null;
        this.mContext = context;
        initData();
        if (gS != null) {
            gT = new boolean[gS.size()];
            for (int i = 0; i < gT.length; i++) {
                gT[i] = false;
            }
        }
    }

    private static void initData() {
        if (gS == null) {
            Properties properties = SwitchDebugService.customConfig;
            if (properties == null) {
                BdLog.e("File of config is null!");
                return;
            }
            synchronized (b.class) {
                if (gS == null) {
                    gS = new Vector<>();
                    String property = properties.getProperty("edit_options");
                    if (property != null) {
                        String[] split = property.split(",");
                        for (String str : split) {
                            a aVar = new a();
                            aVar.setTitle(properties.getProperty("edit_options_" + str + "_title"));
                            String property2 = properties.getProperty("edit_options_" + str + "_access");
                            if (property2 != null) {
                                String[] split2 = property2.split(":");
                                aVar.Q(split2[0]);
                                aVar.R(split2[1]);
                                aVar.c(properties.getProperty("edit_options_" + str + "_defaultValues").split(","));
                                gS.add(aVar);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return gS.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return gS.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, R.drawable.adp_debug_custom_config_items, null);
        TextView textView = (TextView) inflate.findViewById(R.id.adp_debug_custom_config_title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.adp_debug_edit_custom_config);
        ListView listView = (ListView) inflate.findViewById(R.id.adp_debug_custom_config_defaults_list);
        Button button = (Button) inflate.findViewById(R.id.switch_custom_config);
        button.setTag(getItem(i));
        textView2.setTag(Integer.valueOf(i));
        textView.setOnTouchListener(this);
        textView2.setOnFocusChangeListener(this);
        ((Button) inflate.findViewById(R.id.delete_custom_config)).setOnTouchListener(this);
        button.setOnTouchListener(this);
        textView2.setInputType(1);
        listView.setOnItemClickListener(this);
        a aVar = (a) getItem(i);
        textView.setText(aVar.getTitle());
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < aVar.cS().length; i2++) {
            HashMap hashMap = new HashMap();
            hashMap.put("default_value", aVar.cS()[i2]);
            arrayList.add(hashMap);
        }
        listView.setAdapter((ListAdapter) new SimpleAdapter(this.mContext, arrayList, R.drawable.adp_debug_custom_config_default_value_item, new String[]{"default_value"}, new int[]{R.id.adp_debug_constom_config_default_value}));
        a(listView);
        if (!gT[i]) {
            listView.setVisibility(8);
        } else {
            listView.setVisibility(0);
        }
        return inflate;
    }

    public static void a(ListView listView) {
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
            ((TextView) ((View) adapterView.getParent()).findViewById(R.id.adp_debug_edit_custom_config)).setText((String) ((HashMap) item).get("default_value"));
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Object tag;
        boolean z;
        String str;
        if (motionEvent.getAction() == 0) {
            if (view.getId() == R.id.delete_custom_config) {
                ((TextView) ((View) view.getParent()).findViewById(R.id.adp_debug_edit_custom_config)).setText("");
            } else if (view.getId() == R.id.switch_custom_config && (tag = view.getTag()) != null) {
                a aVar = (a) tag;
                String className = aVar.getClassName();
                String methodName = aVar.getMethodName();
                String charSequence = ((TextView) ((View) view.getParent()).findViewById(R.id.adp_debug_edit_custom_config)).getText().toString();
                try {
                    Class<?> cls = Class.forName(className);
                    cls.getMethod(methodName, String.class).invoke(cls, charSequence);
                    z = true;
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    z = false;
                }
                if (z) {
                    str = "配置修改成功！";
                } else {
                    str = "配置修改失败！！！";
                }
                Toast makeText = Toast.makeText(this.mContext.getApplicationContext(), str, 1);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
        }
        return false;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (view.getId() == R.id.adp_debug_edit_custom_config && z) {
            ((View) view.getParent().getParent().getParent()).findViewById(R.id.adp_debug_custom_config_defaults_list).setVisibility(0);
            Object tag = view.getTag();
            if (tag != null) {
                gT[((Integer) tag).intValue()] = true;
            }
        }
    }
}
